DESCRIPTION = ".NET Core Install Scripts"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    https://dot.net/v1/dotnet-install.sh;sha256sum=aaa889cd9fd06f098144fc065db3ab8525133666d9a21c2ca45017aabfef4d23 \
    https://aka.ms/getvsdbgsh;sha256sum=2608424ae05550a24ac9b767a997635de1e87fe551156536d03356da421f4c64 \
"
RDEPENDS:${PN} = "\
    icu \
    libgssapi-krb5 \
    zlib \
"

FILES:${PN} += "\
    ${datadir}/ \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {    
    install -d ${D}${datadir}
    install -m 0770 ${WORKDIR}/dotnet-install.sh ${D}/${datadir}/dotnet-install.sh
    install -m 0770 ${WORKDIR}/getvsdbgsh ${D}/${datadir}/getvsdbg.sh
}