LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = " dtc-native"

SRC_URI = " \
	file://reTerminal-overlay.dts \
"

# FILES_${PN} = "\
# 	lib \
# 	lib/firmware \
#     lib/firmware/reTerminal-overlay.dtbo \
# "

S = "${WORKDIR}"

do_compile() {
    dtc -@ -I dts -O dtb -o reTerminal-overlay.dtbo reTerminal-overlay.dts
}

do_install() {
    install -d ${DEPLOY_DIR_IMAGE}
    install -m 0755 ${S}/*.dtbo ${DEPLOY_DIR_IMAGE}
    
    install -d  ${D}/lib/firmware
    install -m 0755 ${S}/*.dtbo ${D}/lib/firmware
}

# SUMMARY = "Seeed reterminal device tree overlay"
# DESCRIPTION = "Include all the device dtoverlay of reterminal"
# HOMEPAGE = "https://github.com/Seeed-Studio/seeed-linux-dtoverlays"
# LICENSE = "MIT"
# LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# inherit linux-kernel-base module-base

# KERNEL_VERSION = "${@get_kernelversion_file("${STAGING_KERNEL_BUILDDIR}")}"

# SRCREV = "${AUTOREV}"

# SRC_URI = "\
# 	file://Makefile \
# 	file://scripts/Kbuild.include \
# 	file://scripts/basic/fixdep \
# 	file://overlays/rpi/Makefile \
# 	file://overlays/rpi/reTerminal-overlay.dts \
# 	file://0001-compatible-for-yocto.patch \
# "

# DEPENDS += " dtc-native"

# S = "${WORKDIR}"

# INSANE_SKIP:${PN} = "file-rdeps"

# do_compile() {
# 	oe_runmake \
# 		ARCH=${ARCH} \
# 		KBUILD=${STAGING_KERNEL_DIR} \
# 		O=${STAGING_KERNEL_BUILDDIR} \
# 		CROSS_COMPILE=${TARGET_PREFIX} \
# 		all_rpi
# }

# do_install() {
# 	install -d ${D}/lib/modules/${KERNEL_VERSION}/extra/
# 	oe_runmake \
# 		ARCH=${ARCH} \
# 		KBUILD=${STAGING_KERNEL_DIR} \
# 		CROSS_COMPILE=${TARGET_PREFIX} \
# 		KO_DIR=${D}/lib/modules/${KERNEL_VERSION}/extra/ \
# 		install_rpi
# }

# FILES:${PN} += "/lib/modules/${KERNEL_VERSION}/extra"
