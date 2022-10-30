SUMMARY = "A minimal console-only base image for the reTerminal"
HOMEPAGE = "https://www.seeedstudio.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-minimal.bb

#
# Supported languages
#
IMAGE_LINGUAS = "en-us"

#
# Software features shipped 
#
DISTRO_FEATURES:append = " bluetooth wifi"

#
# Extra image configuration defaults
#
EXTRA_IMAGE_FEATURES ?= "ssh-server-openssh package-management"

#
# Enable u-boot kernel image
#
RPI_USE_U_BOOT = "1"

#
# Enable systemd in configuration
#
INIT_MANAGER = "systemd"

#
# Additional installed packages
#
CORE_OS = "\
	kernel-modules \
	linux-firmware-rpidistro-bcm43455 \
	seeed-linux-dtoverlays \
	bluez5 \
    openssh \ 
	openssh-sftp-server \
	openssl \
    firewall \
"
EXTRA_TOOLS = "\
	apt \
	zlib \
	bash \
	nano \
	curl \
	mc \
	dotnet \
	wpa-supplicant \
	i2c-tools \
"

IMAGE_INSTALL:append = " \
    ${CORE_OS} \
    ${EXTRA_TOOLS} \
"

#
# Enable wic format for flashing to sdcard
#
IMAGE_FSTYPES = "wic"

#
# Set the size of root file system to 32GB
#
# IMAGE_ROOTFS_SIZE = "319488" 
# IMAGE_OVERHEAD_FACTOR = "1.0"
# IMAGE_ROOTFS_EXTRA_SPACE = "53248"
# IMAGE_ROOTFS_MAXSIZE = "372736"

IMAGE_ROOTFS_SIZE = "10240" 