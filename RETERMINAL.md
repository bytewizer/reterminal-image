# Flash Raspberry Pi OS to eMMC

Flash Raspberry Pi OS to the eMMC storage of the CM4 on the reTerminal. Once the necessary drivers are installed, you just have to connect the USB Type-C port of the reTerminal to your PC, and it will show as an external drive. Start by removing the reTerminal back shell.

**Step 1.** Remove the 4 rubber covers and open the reTerminal back shell unscrewing the 4 screws underneath.

![Remove Screws](/assets/reterminal/hw-remove-screws.png)

**Step 2.** Remove the 2 screws to disassemble the heatsink.

![Remove Heatsink](/assets/reterminal/hw-remove-screws-heatsink.jpg)

**Step 3.** Flip down the boot mode switch according to the below diagram.

![Boot Switch](/assets/reterminal/hw-boot-switch.jpg)

**Step 4.** Download the rpiboot setup installer by click this [link](https://github.com/raspberrypi/usbboot/raw/master/win32/rpiboot_setup.exe) to install the necessary drivers and the boot tool.

**Step 5.** Connect reTerminal to the PC via USB Type-C cable. Windows will now find the hardware and install the necessary drivers.

**Step 6.** Open file explorer and you will see the eMMC of the Computer Module 4 shown as a USB mass storage device.

**Step 7.**  Download Raspberry Pi Imager software by visiting this [link](https://www.raspberrypi.org/software/). Open Raspberry Pi Imager software

![Raspberry Pi Imager](/assets/reterminal/rpi-imager.png)

Press CTRL + SHIFT + X on the keyboard to open Advanced options window. Here you can set a hostname, enable SSH, set a password, configure wifi, set locale settings and more.

![Raspberry Pi Imager](/assets/reterminal/rpi-imager-advanced.png)

Click CHOOSE OS and select your preferred OS. 

![Raspberry Pi Imager](/assets/reterminal/rpi-imager-os.png)

Click CHOOSE STORAGE and select the connected eMMC drive.  Finally, click WRITE

![Raspberry Pi Imager](/assets/reterminal/rpi-imager-final.png)

Please wait a few minutes until the flashing process is complete. 

**Step 11.** Flip the Boot Mode switch back to the original position and assemble the reTerminal shell.

# Pinout Diagram

![Pinout](/assets/reterminal/hw-pinout.jpg)

**Note**: Please make sure to keep the reTerminal in the orientation as illustrated below. Here the LCD is facing right side and the back is facing left side.

# Log in using a USB to serial converter

Connect jumper wires from a USB to Serial Converter to the UART pins on the 40-pin GPIO header of the reTerminal as follows.

![Uart](/assets/reterminal/hw-usb-uart.png)

Baud Rate: 115200
Data Bits: 8 
Parity: none
Stop Bits: 1
Flow Control: none

# Resources
[Getting Started with reTerminal](https://wiki.seeedstudio.com/reTerminal/)

[Hardware and Interfaces Usage](https://wiki.seeedstudio.com/reTerminal-hardware-interfaces-usage/)

[Seeed Studio Yocto SDK Build System](https://wiki.seeedstudio.com/reTerminal-Buildroot-SDK/)

[Hardware Schematics](https://files.seeedstudio.com/wiki/ReTerminal/reTerminal-v1.3_SCH.pdf)

[Raspberry Pi Compute Module 4 Datasheet](https://datasheets.raspberrypi.com/cm4/cm4-datasheet.pdf)
