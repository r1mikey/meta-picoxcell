DEFAULTTUNE ?= "armv6k"

TUNEVALID[armv6k] = "Enable instructions for ARMv6k"
TUNECONFLICTS[armv6k] = "armv4 armv5"
TUNE_CCARGS .= "${@bb.utils.contains("TUNE_FEATURES", "armv6k", " -march=armv6k", "", d)}"
MACHINEOVERRIDES =. "${@bb.utils.contains("TUNE_FEATURES", "armv6k", "armv6k:", "" ,d)}"

require conf/machine/include/arm/arch-armv6.inc

# Little Endian
AVAILTUNES += "armv6k-novfp armv6k"
ARMPKGARCH_tune-armv6k-novfp ?= "armv6k-novfp"
ARMPKGARCH_tune-armv6k ?= "armv6k"
TUNE_FEATURES_tune-armv6k-novfp ?= "armv6k"
TUNE_FEATURES_tune-armv6k ?= "${TUNE_FEATURES_tune-armv6k-novfp} vfp"
PACKAGE_EXTRA_ARCHS_tune-armv6k-novfp = "${PACKAGE_EXTRA_ARCHS_tune-armv6-novfp} armv6k"
PACKAGE_EXTRA_ARCHS_tune-armv6k = "${PACKAGE_EXTRA_ARCHS_tune-armv6} armv6k armv6k-vfp"

# Big Endian
AVAILTUNES += "armv6kb-novfp armv6kb"
ARMPKGARCH_tune-armv6kb-novfp ?= "armv6k"
ARMPKGARCH_tune-armv6kb ?= "armv6k"
TUNE_FEATURES_tune-armv6kb-novfp ?= "${TUNE_FEATURES_tune-armv6k-novfp} bigendian"
TUNE_FEATURES_tune-armv6kb ?= "${TUNE_FEATURES_tune-armv6k} bigendian"
PACKAGE_EXTRA_ARCHS_tune-armv6kb-novfp = "${PACKAGE_EXTRA_ARCHS_tune-armv6b-novfp} armv6kb"
PACKAGE_EXTRA_ARCHS_tune-armv6kb = "${PACKAGE_EXTRA_ARCHS_tune-armv6b} armv6kb armv6kb-vfp"
