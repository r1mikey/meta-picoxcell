SUMMARY = "Intel/Picochip picoXcell Kernel Modules"
PV = "0.0"
PR = "r0"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"

inherit module

SRC_URI = "git:///home/michael/development/picoxcell-modules;protocol=file"
# SRC_URI = "git://github.com/r1mikey/picoxcell-modules.git;protocol=git"
SRCREV = "126c075024422e6513a9f06e672e62a076cd32cc"

S = "${WORKDIR}/git"
