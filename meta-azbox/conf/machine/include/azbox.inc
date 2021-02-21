# We know about rtc
include conf/machine/include/build-extras.inc

BRAND_OEM = "azbox"
MACHINE_BRAND = "AZBOX"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " \
    azbox-dvb-modules \
    "

DVBPROVIDER = "kernel"


MACHINE_EXTRA_RRECOMMENDS += " \
    azbox-compat \
    kernel-module-cifs \
    "
EXTRA_IMAGEDEPENDS += " \
    kmod-native \
    "
    
GST_VERSION = "1.0"

DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dtsdownmix "

MACHINE_FEATURES += " kernel26 alsa usbhost wifi nl80211 3dtv switchoff lpcm textlcd 32bpp hdtv dvbapi5 dvb-c blindscan-dvbs boxmodel HDMI"

PREFERRED_VERSION_linux-azbox = "3.9.2"
PREFERRED_VERSION_linux-libc-headers = "4.20"

GLIBC_EXTRA_OECONF = "--with-tls --with-__thread"

PREFERRED_PROVIDER_virtual/kernel = "linux-azbox"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "azbox-blindscan-dvbs-utils"

require conf/machine/include/tune-mips32.inc
require conf/machine/include/soc-family.inc
include conf/machine/include/autoload-filesystems.inc

SYSVINIT_ENABLED_GETTYS = ""

KERNEL_EXTRA_CMD = "--disable-compressor=lzo "

IMAGE_FSTYPES ?= "jffs2"

EXTRA_IMAGECMD_jffs2 = " -p 0x800 -e 0x20000 -n -l"

IMAGE_CMD_jffs2_prepend = " \
    rm -f ${DEPLOY_DIR_IMAGE}/*.manifest; \
    rm -f ${DEPLOY_DIR_IMAGE}/.manifest; \
    mkdir -p ${DEPLOY_DIR_IMAGE}/USB; \
    mkdir -p ${DEPLOY_DIR_IMAGE}/WEBIF; \
    rm -fR ${IMAGE_ROOTFS}/boot/*; \
    mkfs.jffs2 \
        --root=${IMAGE_ROOTFS} \
        --faketime \
        ${KERNEL_EXTRA_CMD} \
        --compression-mode=size \
        --output=${DEPLOY_DIR_IMAGE}/image0.jffs2 \
        ${EXTRA_IMAGECMD}; \
    "   

IMAGE_CMD_jffs2_prepend = " \
    rm -rf ${IMAGE_ROOTFS}/tmp/*; \
    "
	
BLINDSCAN_BINARY = "avl_azbox_blindscan"

TARGET_ARCH = "mipsel"
DEFAULTTUNE = "mips32el"
