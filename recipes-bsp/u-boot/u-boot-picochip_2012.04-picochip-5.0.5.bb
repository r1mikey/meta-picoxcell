require recipes-bsp/u-boot/u-boot.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

DEPENDS += "dtc-native"

# This revision corresponds to the tag "v2012.04"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "5910ada22359d6cd06b9299f1ef6020a1ea2b893"

SRC_URI += " \
    file://0001-pc7302-add-support-for-the-pc7302-platform.patch \
    file://0002-sf-add-support-for-m25p05-devices.patch \
    file://0003-picoxcell-use-the-common-serial-driver.patch \
    file://0004-picoxcell-name-change-pc3xx-to-picoxcell.patch \
    file://0005-picoxcell-replace-bss-variables-by-gd_t-members.patch \
    file://0006-pc7302-change-to-nand-flash-support-on-pc7302-platfo.patch \
    file://0007-picoxcell-move-some-startup-functions-from-board-to-.patch \
    file://0008-mach-types-add-machine-type-definition-for-pc7308-pl.patch \
    file://0009-pc7308-add-support-for-the-pc7308-platform.patch \
    file://0010-picoxcell-spi-driver-improvement.patch \
    file://0011-picoxcell-add-in-muxing-library-from-linux-for-pc30x.patch \
    file://0012-picoxcell-emac-driver-picoxcell-device-id-check-chan.patch \
    file://0013-picoxcell-change-the-way-picoxcell-part-names-are-re.patch \
    file://0014-pc7302-pc7308-enabled-use-of-mtdparts-command.patch \
    file://0015-picoxcell-add-clock-control-for-picoxcell-devices.patch \
    file://0016-nand-add-driver-for-denali-nand-controller.patch \
    file://0017-pc7308-Add-support-for-factory-reset-request-detecti.patch \
    file://0018-pc7308-add-mtd-partitions-for-the-nand-fsbl.patch \
    file://0019-pc7302-change-the-mtd-partition-mapping-definition.patch \
    file://0020-macb-initial-support-for-Cadence-GEM.patch \
    file://0021-macb-support-higher-rate-GEM-MDIO-clock-divisors.patch \
    file://0022-macb-support-DMA-bus-widths-32-bits.patch \
    file://0023-macb-allow-GEM-to-have-configurable-receive-buffer-s.patch \
    file://0024-macb-picoxcell-DMA-bus-width-setup-for-PC3x2-devices.patch \
    file://0025-macb-picoxcell-add-rmii-fixup-for-PC3x2-devices.patch \
    file://0026-pc7302-pc7308-changed-to-use-the-macb-ethernet-drive.patch \
    file://0027-pc7302-pc7308-changed-icache-setup-for-u-boot-2011.0.patch \
    file://0028-pc7308-changed-the-Ethernet-phy-address-to-3.patch \
    file://0029-pc7308-life-out-of-the-nand-driver.patch \
    file://0030-nand-disable-the-nand-controller-dma-during-initiali.patch \
    file://0031-pc7308-change-the-ddr-sdram-size-to-64-Mbytes.patch \
    file://0032-nand-changes-inline-with-kernel-denali-nand-driver-m.patch \
    file://0033-pc7308-change-the-partition-for-the-root-filesystem.patch \
    file://0034-pc7308-change-the-default-mtd-partition-parameters.patch \
    file://0035-pc7308-remove-the-mii-commands-from-the-build.patch \
    file://0036-macb-picoxcell-add-support-for-gigbit-operation-with.patch \
    file://0037-pc7302-pc7308-config-file-changes-for-u-boot-v2012.0.patch \
    file://0038-picoxcell-implement-get_tbclk.patch \
    file://0039-pc7302-pc7308-changes-for-u-boot-v2012.04.patch \
    file://0040-Revert-arm-arm926ejs-Flush-the-data-cache-before-dis.patch \
    file://0041-picoxcell-compile-with-march-armv5.patch \
    file://0042-picoxcell-add-in-the-pc3032-device-id.patch \
    file://0043-pc7302-pc7308-hardcode-the-sdram-size.patch \
    file://0044-nand-updated-the-picoxcell-exception-cases.patch \
    file://0045-pc7308-fixed-up-an-incorrect-nand-flash-layout-descr.patch \
    file://0046-pc73032-add-support-for-the-pc73032-platform.patch \
    file://0047-picoxcell-pc73032-fixup-checking-for-memif-arm-being.patch \
    file://0048-pc73032-add-a-work-round-for-the-pc30xx-rgmii-transm.patch \
    file://0049-pc73032-do-not-include-the-mii-commands-as-standard.patch \
    file://0050-pc73032-do-not-use-bufferd-writes-to-nor-flash.patch \
    file://0051-pc73032-add-environment-variables-to-support-nor-boo.patch \
    file://0052-cfi-fix-cfi-detection-on-Micron-M29WE-devices.patch \
    file://0053-cfi-enable-buffer-programming-for-M29EW-in-x8-mode.patch \
    file://0054-Revert-pc73032-do-not-use-bufferd-writes-to-nor-flas.patch \
    file://0055-nand-fix-the-denali-read-write_oob_data-functions.patch \
    file://0056-picoxcell-spi-driver-enhanced-to-run-on-pc30xx-devic.patch \
    file://0057-pc73032-memif-setup-now-uses-generated-timing-values.patch \
    file://0058-pc73032-fix-some-compiler-warnings.patch \
    file://0059-macb-picoxcell-fix-some-compiler-warnings.patch \
    file://0060-nand-pc7308-remove-hardcoded-changes-made-for-pc7308.patch \
    file://0061-nand-fixup-onfi-parameter-reading.patch \
    file://0062-NAND-Remove-ONFI-detection-message-to-from-bootup-lo.patch \
    file://0063-nand-declare-the-denali_read_buf-as-static.patch \
    file://0064-nand-fixup-onfi-parameter-reading-now-inline-with-li.patch \
    file://0065-pc73032-updated-memif-setting-to-match-latest-versio.patch \
    file://0066-pc7308-u-boot-updated-for-latest-timing-parameters-f.patch \
    file://0067-pc73032-u-boot-memif-arm-section-updated-for-latest-.patch \
    file://0068-pc73032-modify-a-work-round-for-the-pc30xx-1Gbit-rgm.patch \
    file://0069-pc7308-u-boot-updated-to-enable-bank-opportunistic-m.patch \
    file://0070-pc7308-u-boot-supports-multiple-DDR3-devices.patch \
    "

# fix up the BSP mess for modern compilers
SRC_URI += " \
    file://9001-Add-the-GCC5-compiler-header-for-master-U-Boot.patch \
    file://9002-Update-weak-alias-definitions.patch \
    file://9003-extern-inline-is-no-longer-valid-in-GCC5-replace-wit.patch \
    file://9004-The-picoxcell-read-write-register-functions-are-comp.patch \
    file://9005-Use-the-proper-I-O-accessors-for-GPIO-access-and-don.patch \
    "

PV = "v2012.04"

EXTRA_OEMAKE_append = " KCFLAGS=-fgnu89-inline"
