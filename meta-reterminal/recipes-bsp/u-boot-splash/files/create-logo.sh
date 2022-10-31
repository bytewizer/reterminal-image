#!/bin/bash
IMAGE_JPG_INPUT=bytewizer.jpg
IMAGE_UBOOT=splash.bmp
IMAGE_KERNEL=logo_custom_clut224.ppm

echo "Converting $IMAGE_JPG_INPUT" 
jpegtopnm $IMAGE_JPG_INPUT | ppmquant 224 > tmp.ppm
pnmnoraw tmp.ppm > $IMAGE_KERNEL

echo ">> Kernel image created: $IMAGE_KERNEL" 
ppmtobmp -bpp 8 tmp.ppm > $IMAGE_UBOOT

echo ">> U-boot image created: $IMAGE_UBOOT" 
rm tmp.ppm