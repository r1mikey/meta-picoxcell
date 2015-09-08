KMACHINE = "picoxcell"
KBRANCH = "picoxcell-consolidation"
KMETA = "kernel-meta"
MBRANCH = "picoxcell-devel"

SRC_URI = "git:///home/michael/development/linux-picoxcell;branch=${KBRANCH};name=machine \
           git:///home/michael/development/yocto-kernel-cache-picoxcell;type=kmeta;name=meta;branch=${MBRANCH};destsuffix=${KMETA}"

SRCREV_machine = '${@oe.utils.conditional("PREFERRED_PROVIDER_virtual/kernel", "linux-yocto-dev", "${AUTOREV}", "8b5e1960272f0327825ff98cbbb1c0daf3029531", d)}'
SRCREV_meta = '${@oe.utils.conditional("PREFERRED_PROVIDER_virtual/kernel", "linux-yocto-dev", "${AUTOREV}", "2f1c28d7fa415efcd138b7659c139c1a8e5e2ffb", d)}'

LINUX_VERSION = "4.2-rc+"
LINUX_VERSION_EXTENSION = "-picoxcell-yoctodev-${LINUX_KERNEL_TYPE}"
PV = "${LINUX_VERSION}+git${SRCPV}"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "(pc7302nand|pc7302nor|pc73032nand|pc73032nor|pc7308)"

# LEVELS:
#   0: no reporting
#   1: report options that are specified, but not in the final config
#   2: report options that are not hardware related, but set by a BSP
KCONF_AUDIT_LEVEL = "2"
KCONF_BSP_AUDIT_LEVEL = "2"
