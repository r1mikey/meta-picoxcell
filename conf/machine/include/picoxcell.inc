DEFAULTTUNE ?= "arm1176jzs"

require conf/machine/include/tune-arm1176jz-s.inc

SOC_FAMILY = "picoxcell"
include conf/machine/include/soc-family.inc

USE_VT = "0"
SERIAL_CONSOLES = "115200;ttyS0"

UBOOT_ENTRYPOINT ?= "0x00008000"
UBOOT_LOADADDRESS ?= "0x00008000"

# PREFERRED_PROVIDER_virtual/kernel = "linux-yocto-dev"
# KERNEL_IMAGETYPE ?= "Image"
# KERNEL_CLASSES_append = " kernel-fitimage"

MACHINE_FEATURES = "serial"
MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc"
# MACHINE_EXTRA_RRECOMMENDS += " kernel-modules"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "pulseaudio bluez5"
