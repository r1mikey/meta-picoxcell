SUMMARY = "Intel/Picochip picoXcell Kernel Modules"
PV = "0.0"
PR = "r0"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

inherit module

# SRC_URI = "git:///home/michael/development/picoxcell-modules;protocol=file"
SRC_URI = "git://github.com/r1mikey/picoxcell-modules.git;protocol=git"
SRCREV = "5758a492398fa16326d6f48a05e8f19c84c0195c"

S = "${WORKDIR}/git"

RDEPENDS_kernel-module-picoxcell-sdgpio_append = " kernel-module-picoxcell-config-port"
