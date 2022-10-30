DESCRIPTION = ".NET Core Debugger (v17.2.10518.1) - Linux x64 Binaries"
HOMEPAGE = "https://github.com/Microsoft/MIEngine/wiki/Offroad-Debugging-of-.NET-Core-on-Linux---OSX-from-Visual-Studio"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "80cde072ac882eb0882bfb9a6bb511ceaa05c022be97715ebd2f9eafaad29182"
SRC_URI = "https://vsdebugger.azureedge.net/vsdbg-17-2-10518-1/vsdbg-linux-arm64.tar.gz;unpack=0"

#DEPENDS += "patchelf-native"

#RDEPENDS_${PN} += " openssh openssh-sftp-server icu lttng-tools lttng-ust zlib libz curl libgssglue"


#INSANE_SKIP_${PN} = "arch"
#INSANE_SKIP_${PN} += "already-stripped libdir textrel"
# INSANE_SKIP_${PN} += "libdir ldflags"
# INSANE_SKIP_${PN} += "file-rdeps"
# SKIP_FILEDEPS_${PN} = "1"
#PACKAGES =+ "${PN}"

#PACKAGES = "${PN}-dbg ${PN}"

RDEPENDS:${PN} = "\
    zlib \
"

FILES:${PN} += "\
    /.vsdbg \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${usrdir}/.vsdbg
    tar -xvzf ${WORKDIR}/vsdbg-linux-arm64.tar.gz -C ${D}${usrdir}/.vsdbg
    chmod +x ${D}${usrdir}/.vsdbg/vsdbg
    #ls ${D}${usrdir}/.vsdbg
    #2patchelf --set-interpreter /lib/ld-linux-x86-64.so.2 ${D}${usrdir}/.vsdbg/vsdbg
}

# PACKAGES =+ "${PN}-net"
# RDEPENDS_${PN} += "${PN}-net"
# SKIP_FILEDEPS_${PN}-net = "1"
# FILES_${PN}-net += "${datadir}/vsdbg/*.dll ${datadir}/vsdbg/**/*.dll"

# INSANE_SKIP_${PN} += "libdir ldflags"


# # DEPENDS = "patchelf-native"

# # RDEPENDS_${PN} += "\
# #     libcurl \
# #     libgssapi-krb5\
# #     zlib \
# # "

# FILES:${PN} += "\
#     ${D}${datadir}/vsdbg \
# "

# do_configure[noexec] = "1"
# do_compile[noexec] = "1"

# do_install() {
#     echo ${S}
#     echo ${D}
#     echo ${D}${datadir}
#     echo ${WORKDIR}
    
#     ls ${WORKDIR}
    

    
#     install -d ${D}${bindir}/vsdbg
#     tar -xvzf ${WORKDIR}/vsdbg-linux-x64.tar.gz -C ${D}${bindir}/vsdbg
#     chmod +x ${D}${bindir}/vsdbg/vsdbg

#     #install -d ${D}${bindir}
#     #ln -rs ${D}${datadir}/vsdbg/vsdbg ${D}${bindir}/vsdbg

#     # install -m 0755 ${S}/vsdbg ${D}${datadir}/vsdbg
#     # install -m 0644 ${S}/license.txt ${D}${datadir}/vsdbg
    
#     #install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/vsdbg
    
    
#     #install -m 0755 ${S} ${D}${datadir}/vsdbg
#     #find ${S} -mindepth 1 -maxdepth 1 -type d ! -regex '\(.*a\|.*b\)' -exec cp -r {} ${S} ${D}${datadir}/vsdbg \;

#     #cp -r --no-preserve=ownership  ${WORKDIR}  ${D}${datadir}/vsdbg
#     #rsync -a --exclude={'image'} ${S} ${D}${datadir}/vsdbg
    
#     #shopt -s extglob
#     #cp -r ${S}!(image) ${D}${datadir}/vsdbg/
#     #find ${S} -type f -not -iname '*/image/*' -exec cp '{}' '/dest/{}' ';'
#     #ls | grep -Pv '^(a|b)$' | xargs -I cp -r ${S} ${D}${datadir}/vsdbg/
#     # chmod +x ${D}${datadir}/vsdbg/vsdbg
    
#     # install -d ${D}${bindir}
#     # ln -rs ${D}${datadir}/vsdbg/vsdbg ${D}${bindir}/vsdbg
    
#     #install -m 0755 ${S} ${D}${datadir}/vsdbg
    
#     #install -m 0644 ${S}/license.txt ${D}${datadir}/vsdbg
#     #install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/vsdbg

#     # install -d ${D}${datadir}/vsdbg
#     # install -m 0755 ${S}/vsdbg ${D}${datadir}/vsdbg
#     # cp -r -v --no-preserve=ownership ${S} ${D}${datadir}/vsdbg

    
    
#     # install -d ${D}${datadir}/vsdbg
#     # cp -av --no-preserve=ownership ${S} ${D}${datadir}/vsdbg
#     # chmod +x ${D}${datadir}/vsdbg/vsdbg
#     # patchelf --set-interpreter /lib/ld-linux-x86-64.so.2 ${D}${datadir}/vsdbg/vsdbg
# }

# # INSANE_SKIP_${PN} += "libdir ldflags"

# # BBCLASSEXTEND = "native"