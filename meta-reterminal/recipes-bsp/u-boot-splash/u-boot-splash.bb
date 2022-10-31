SUMMARY = "Add u-boot splash image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://splash.bmp"

S = "${WORKDIR}"

FILES:${PN} = "/boot/splash.bmp"

do_install () {
	install -d ${D}/boot
	install -m 644 splash.bmp ${D}/boot/splash.bmp
}