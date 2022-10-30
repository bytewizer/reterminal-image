#!/bin/bash

# Abort script if any command returns error
set -e

IMAGE="reterminal-image"
TMP_FILE=".env_check"
BUILD_DIR="build"
# LOCAL_CONF="conf/local.conf"
# LOCAL_CONF_STR="# Added by run-build script"

# Source build environment
source ./poky/oe-init-build-env $BUILD_DIR

# Add BSP layer
bitbake-layers add-layer ../meta-rpilinux
bitbake-layers add-layer ../meta-reterminal
bitbake-layers add-layer ../poky/meta-raspberrypi
bitbake-layers add-layer ../poky/meta-openembedded/meta-oe
bitbake-layers add-layer ../poky/meta-openembedded/meta-python
bitbake-layers add-layer ../poky/meta-openembedded/meta-multimedia
bitbake-layers add-layer ../poky/meta-openembedded/meta-networking


# if ! grep -q "$LOCAL_CONF_STR" $LOCAL_CONF
# then
#   # Parse environment
#   bitbake -e $IMAGE > $TMP_FILE
#   TARGET=`grep ^MACHINE= $TMP_FILE | cut -d\" -f2`
#   rm $TMP_FILE

#   # Machine-specific variables
#   if [ "$TARGET" == "raspberrypi3-64" ]; then
#     echo "" >> $LOCAL_CONF
#     echo "$LOCAL_CONF_STR" >> $LOCAL_CONF
#     echo "ENABLE_UART = \"1\"" >> $LOCAL_CONF
#   fi
# fi

# Build
#bitbake --dry-run $IMAGE
#bitbake $IMAGE
