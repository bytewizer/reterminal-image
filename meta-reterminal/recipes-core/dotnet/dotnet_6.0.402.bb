DESCRIPTION = ".NET Core 6.0 SDK (v6.0.402) - Linux x64 Binaries"
HOMEPAGE = "https://dotnet.microsoft.com/en-us/download/dotnet/6.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "patchelf-native"

RDEPENDS:${PN} = "\
    icu \
    libgssapi-krb5 \
    zlib \
"
SRC_FETCH_ID = "234daf6a-5e12-4fa3-a73b-b12db44a3154/df7c012e5e4e2cc510de9226425dad88"

SRC_URI[sha256sum] = "a5fe4d69a9c83f37509129c25dcf324d8407a60b5e7e8ec24a5f925550139c74"
SRC_URI = "https://download.visualstudio.microsoft.com/download/pr/${SRC_FETCH_ID}/dotnet-sdk-${PV}-linux-arm64.tar.gz;subdir=dotnet-${PV}"

DOTNET_RUNTIME = "6.0.10"
DOTNET_ASP = "6.0.10"
DOTNET_TEMPLATES = "6.0.10"
DOTNET_MANIFESTS = "6.0.300"

FILES:${PN} += "\
    ${datadir}/dotnet/dotnet \
    ${datadir}/dotnet/*.txt \
    ${datadir}/dotnet/host \
    ${datadir}/dotnet/shared \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    	
    install -d ${D}${bindir}
    ln -rs ${D}${datadir}/dotnet/dotnet ${D}${bindir}/dotnet

    install -d ${D}${datadir}/dotnet
    install -m 0755 ${S}/dotnet ${D}${datadir}/dotnet
    install -m 0644 ${S}/LICENSE.txt ${D}${datadir}/dotnet
    install -m 0644 ${S}/ThirdPartyNotices.txt ${D}${datadir}/dotnet

    install -d ${D}${datadir}/dotnet/host/fxr
    cp -r --no-preserve=ownership ${S}/host/fxr/${DOTNET_RUNTIME} ${D}${datadir}/dotnet/host/fxr

    install -d ${D}${datadir}/dotnet/sdk
    cp -r --no-preserve=ownership ${S}/sdk/${PV} ${D}${datadir}/dotnet/sdk

    install -d ${D}${datadir}/dotnet/sdk-manifests
    cp -r --no-preserve=ownership ${S}/sdk-manifests/${DOTNET_MANIFESTS} ${D}${datadir}/dotnet/sdk-manifests

    install -d ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App
    cp -r --no-preserve=ownership ${S}/shared/Microsoft.NETCore.App/${DOTNET_RUNTIME} ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App

    install -d ${D}${datadir}/dotnet/shared/Microsoft.AspNetCore.App
    cp -r --no-preserve=ownership ${S}/shared/Microsoft.AspNetCore.App/${DOTNET_ASP} ${D}${datadir}/dotnet/shared/Microsoft.AspNetCore.App

    install -d ${D}${datadir}/dotnet/templates
    cp -r --no-preserve=ownership  ${S}/templates/${DOTNET_TEMPLATES} ${D}${datadir}/dotnet/templates
    
    # Hack to fix liblttng-ust dependency issues
    patchelf --remove-needed liblttng-ust.so.0 ${D}${datadir}/dotnet/shared/Microsoft.NETCore.App/${DOTNET_RUNTIME}/libcoreclrtraceptprovider.so

}

INSANE_SKIP:${PN} = "already-stripped libdir staticdev"

BBCLASSEXTEND = "native"