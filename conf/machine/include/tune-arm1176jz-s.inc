DEFAULTTUNE ?= "armv6k-novfp"

require conf/machine/include/arm/arch-armv6k.inc

TUNEVALID[arm1176jzs] = "Enable arm1176jz-s specific processor optimizations"
TUNE_CCARGS += "${@bb.utils.contains("TUNE_FEATURES", "arm1176jzs", "-mtune=arm1176jz-s", "", d)}"

AVAILTUNES += "arm1176jzs"
TUNE_FEATURES_tune-arm1176jzs = "${TUNE_FEATURES_tune-armv6k-novfp} arm1176jzs"
ARMPKGARCH_tune-arm1176jzs = "arm1176jzs"
PACKAGE_EXTRA_ARCHS_tune-arm1176jzs = "${PACKAGE_EXTRA_ARCHS_tune-armv6k-novfp} arm1176jzs"
