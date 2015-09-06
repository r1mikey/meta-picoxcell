DEFAULTTUNE ?= "arm1176jzs"

require conf/machine/include/tune-arm1176jz-s.inc

SOC_FAMILY = "picoxcell"
include conf/machine/include/soc-family.inc

USE_VT = "0"
SERIAL_CONSOLES = "115200;ttyS0"

UBOOT_ENTRYPOINT ?= "0x00008000"
UBOOT_LOADADDRESS ?= "0x00008000"

UBOOT_CONFIG ??= "nor"
UBOOT_CONFIG_pc7302 ??= "nor nand"
UBOOT_CONFIG_pc73032 ??= "nor nand"
UBOOT_CONFIG_pc7308 = "nand"
UBOOT_CONFIG[nand] = "picochippc7302nand picochippc73032nand picochippc7308"
UBOOT_CONFIG[nor] = "picochippc7302nor picochippc73032nor"

KERNEL_IMAGETYPE ?= "uImage"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-picochip"
PREFERRED_PROVIDER_u-boot = "u-boot-picochip"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-picochip"

_STORAGETECH_FSTYPE = '${@base_contains("UBOOT_CONFIG", "nor", "jffs2", "", d)}'
_STORAGETECH_FSTYPE += '${@base_contains("UBOOT_CONFIG", "nand", "ubi", "", d)}'
IMAGE_FSTYPES ?= 'tar.gz ${_STORAGETECH_FSTYPE}'
UBI_VOLNAME ?= "rootfs"
MKUBIFS_ARGS ?= "-m 2048 -e 126976 -c 528 "
UBINIZE_ARGS ?= "-m 2048 -p 128KiB"
JFFS2_ERASEBLOCK ?= "0x20000"

# PREFERRED_PROVIDER_virtual/kernel = "linux-yocto-dev"
# KERNEL_IMAGETYPE ?= "Image"
# KERNEL_CLASSES_append = " kernel-fitimage"

MACHINE_FEATURES ?= "serial"
MACHINE_FEATURES_BACKFILL_CONSIDERED ?= "rtc"
MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"
DISTRO_FEATURES_BACKFILL_CONSIDERED ?= "pulseaudio bluez5"
DEPENDS_pn-packagegroup-core-boot += "virtual/bootloader"

KERNEL_MODULE_AUTOLOAD = " \
    picoif \
    dw_wdt \
    keystream \
    packetmanager \
    picoxcell-fuse \
    picogpio \
    picoxcell_spi \
    picoxcell_crypto \
    picoxcell-rng \
    "
