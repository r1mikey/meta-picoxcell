inherit kernel
require recipes-kernel/linux/linux-yocto.inc

DEPENDS_append = " lzop-native"

LINUX_VERSION ?= "3.0"
LINUX_VERSION_EXTENSION ?= "-picochip-5.0.5"

PR = "r1"
PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE_pc7302nor = "^(pc7302nor)$"
COMPATIBLE_MACHINE_pc7302nand = "^(pc7302nand)$"
COMPATIBLE_MACHINE_pc7308 = "^(pc7308)$"
COMPATIBLE_MACHINE_pc73032nor = "^(pc73032nor)$"
COMPATIBLE_MACHINE_pc73032nand = "^(pc73032nand)$"

DEFAULT_PREFERENCE_pc7302nor = "-1"
DEFAULT_PREFERENCE_pc7302nand = "-1"
DEFAULT_PREFERENCE_pc7308 = "-1"
DEFAULT_PREFERENCE_pc73032nor = "-1"
DEFAULT_PREFERENCE_pc73032nand = "-1"

S = "${WORKDIR}/linux-${LINUX_VERSION}"

CMDLINE_DEBUG ?= '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug", d)}'
CMDLINE_append = " ${CMDLINE_DEBUG} "

SRC_URI = " \
    ${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-3.0.tar.bz2 \
    file://defconfig \
    file://0001-picoxcell-support-for-Picochip-picoXcell-SoC.patch \
    file://0002-picoxcell-support-for-the-common-system-timers.patch \
    file://0003-picoxcell-common-SoC-peripheral-support.patch \
    file://0004-picoxcell-basic-clk-infrastructure.patch \
    file://0005-picoxcell-support-for-the-PC7302-development-board.patch \
    file://0006-picoxcell-allow-for-soc-family-specialization.patch \
    file://0007-picoxcell-support-for-PC3X2-clks-and-timers.patch \
    file://0008-picoxcell-support-for-PC3X3-clks-and-timers.patch \
    file://0009-picoxcell-initial-support-for-GPIO.patch \
    file://0010-picoxcell-support-for-config-bus-read-write.patch \
    file://0011-picoxcell-support-for-pin-muxing-infrastructure.patch \
    file://0012-picoxcell-pc3x2-support-for-pin-muxing-on-pc3x2.patch \
    file://0013-picoxcell-pc3x3-support-for-pin-muxing-on-pc3x3.patch \
    file://0014-picoxcell-support-for-ARM-GPIO.patch \
    file://0015-picoxcell-pc3x2-arm-gpio-support.patch \
    file://0016-picoxcell-pc3x3-arm-gpio-support.patch \
    file://0017-picoxcell-add-the-GEM-EMAC-device.patch \
    file://0018-picoxcell-pc7302-add-nand-support.patch \
    file://0019-picoxcell-support-SDGPIO.patch \
    file://0020-picoxcell-pc3x3-sdgpio-definitions.patch \
    file://0021-picoxcell-cpufreq-support.patch \
    file://0022-picoxcell-pc3x3-cpufreq-support-for-pc3x3.patch \
    file://0023-picoxcell-add-support-for-pm.patch \
    file://0024-picoxcell-pc3x3-pm-support.patch \
    file://0025-pc7302-enable-EBI-clk-before-NAND-NOR-init.patch \
    file://0026-picoxcell-pc3x3-disable-more-clocks-at-boot-time.patch \
    file://0027-picoxcell-register-a-debugfs-dir.patch \
    file://0028-picoxcell-export-clk-state-through-debugfs.patch \
    file://0029-picoxcell-register-the-DMA-controllers.patch \
    file://0030-picoxcell-pc3x3-add-the-OTP-device.patch \
    file://0031-picoxcell-pm-don-t-use-wfi-on-UP-v6K.patch \
    file://0032-picoxcell-support-for-GEM-TSU.patch \
    file://0033-picoxcell-pc7302-register-the-TSU.patch \
    file://0034-picoxcell-support-the-AXI-bus-error-snoopers.patch \
    file://0035-pc3x2-register-the-bus-snooper-device.patch \
    file://0036-pc3x3-register-the-bus-snooper-device.patch \
    file://0037-picoxcell-support-for-GPIO-interrupts.patch \
    file://0038-at91-provide-macb-clks-with-pclk-and-hclk-name.patch \
    file://0039-macb-remove-conditional-clk-handling.patch \
    file://0040-macb-unify-at91-and-avr32-platform-data.patch \
    file://0041-macb-convert-printk-to-netdev_-and-friends.patch \
    file://0042-macb-initial-support-for-Cadence-GEM.patch \
    file://0043-macb-support-higher-rate-GEM-MDIO-clock-divisors.patch \
    file://0044-macb-support-statistics-for-GEM-devices.patch \
    file://0045-macb-support-DMA-bus-widths-32-bits.patch \
    file://0046-macb-allow-GEM-to-have-configurable-receive-buffer-s.patch \
    file://0047-macb-support-checksum-offloading-for-GEM.patch \
    file://0048-macb-support-for-wake-on-lan-support-with-magic-pack.patch \
    file://0049-macb-support-for-RX-packet-timestamping.patch \
    file://0050-drivers-otp-add-initial-support-for-OTP-memory.patch \
    file://0051-drivers-otp-add-support-for-Picoxcell-PC3X3-OTP.patch \
    file://0052-Blackfin-add-the-OTP-device-as-a-platform-device.patch \
    file://0053-drivers-otp-convert-bfin-otp-to-generic-OTP.patch \
    file://0054-picoxcell-clk-move-clk-ops-into-an-operations-struct.patch \
    file://0055-picoxcell-pc3x2-convert-to-use-clk_ops.patch \
    file://0056-picoxcell-pc3x3-convert-to-use-clk-ops.patch \
    file://0057-picoxcell-tsu-convert-to-use-clk_ops.patch \
    file://0058-picoxcell-clk-allow-clk-parenting.patch \
    file://0059-picoxcell-clk-refactor-clk-definition-helpers.patch \
    file://0060-picoxcell-pc3x3-register-arm-clk-in-Hz.patch \
    file://0061-picoxcell-pc30xx-initial-clk-and-PLL-support.patch \
    file://0062-picoxcell-pc3x3-add-the-ref-clock.patch \
    file://0063-picoxcell-pc3x2-add-the-ref-clock.patch \
    file://0064-picoxcell-dynamically-register-UARTs.patch \
    file://0065-picoxcell-pc7302-register-the-UARTs.patch \
    file://0066-pc3x3-don-t-disable-the-TRNG-clk-twice.patch \
    file://0067-pc3x2-sdgpio-support.patch \
    file://0068-picoxcell-constify-soc-and-move-to-.init.patch \
    file://0069-picoxcell-remove-soc-features.patch \
    file://0070-picoxcell-provide-a-mechanism-to-register-the-spaccs.patch \
    file://0071-picoxcell-pc3x2-register-the-spaccs.patch \
    file://0072-picoxcell-pc3x3-register-the-spaccs.patch \
    file://0073-picoxcell-provide-a-mechanism-to-register-the-TRNG.patch \
    file://0074-picoxcell-pc3x3-register-the-trng.patch \
    file://0075-crypto-picoxcell-convert-to-module-id-table.patch \
    file://0076-crypto-picoxcell-support-for-v2-SPAccs.patch \
    file://0077-crypto-picoxcell-support-for-SNOW3G.patch \
    file://0078-picoxcell-pc30x-define-the-interrupts-for-pc30xx.patch \
    file://0079-picoxcell-pc30xx-register-the-bus-snoopers.patch \
    file://0080-picoxcell-pc30xx-register-the-spaccs.patch \
    file://0081-picoxcell-pc30xx-register-cpufreq-support.patch \
    file://0082-picoxcell-pc30xx-add-the-UART-clk.patch \
    file://0083-picoxcell-rename-CONFIG_PC3X3_STOP_WDT_IN_SUSPEND-to.patch \
    file://0084-picoxcell-pc30xx-PM-support-for-PC30XX.patch \
    file://0085-clocksource-platform-driver-for-APB-timers.patch \
    file://0086-picoxcell-convert-to-dw_apb_platform-timer.patch \
    file://0087-picoxcell-pc30xx-arm-gpio-support.patch \
    file://0088-picoxcell-pc30xx-support-for-SDGPIO.patch \
    file://0089-picoxcell_fuse-add-support-for-the-picoXcell-fuse-bl.patch \
    file://0090-picoxcell-dynamically-register-the-fuse-device.patch \
    file://0091-picoxcell-pc3x2-register-the-fuse-map.patch \
    file://0092-picoxcell-pc3x3-register-the-fuse-map.patch \
    file://0093-picoxcell-pc30xx-register-the-fuse-map.patch \
    file://0094-hwmon-pc30xx-driver-for-picoxcell-pc30xx-temperature.patch \
    file://0095-picoxcell-pc30xx-register-the-onchip-temperature-sen.patch \
    file://0096-otp-pc30xx-support-for-pc30xx-OTP.patch \
    file://0097-picoxcell-pc30xx-register-the-OTP-device.patch \
    file://0098-pc3x2-add-the-timer-clocks.patch \
    file://0099-picoxcell-add-picoxcell_is_.-checks.patch \
    file://0100-picoxcell-pc7302-setup-the-muxing-correctly.patch \
    file://0101-macb-add-a-workaround-for-unaligned-packets.patch \
    file://0102-macb-workaround-for-no-detectable-DMA-bus-width.patch \
    file://0103-macb-quirk-for-undetectable-TSU-TSU-clk.patch \
    file://0104-picoxcell-register-the-emac-dynamically.patch \
    file://0105-picoxcell-pc3x2-register-the-EMAC.patch \
    file://0106-picoxcell-pc3x3-register-the-EMAC.patch \
    file://0107-picoxcell-mux-allow-multiple-mux-registrations.patch \
    file://0108-picoxcell-mux-support-muxing-of-two-peripherals.patch \
    file://0109-picoxcell-pc30xx-muxing-definitions.patch \
    file://0110-picoxcell-pc30xx-register-the-EMAC.patch \
    file://0111-basic-mmio-gpio-allow-platform-data-names.patch \
    file://0112-picoxcell-register-ARM-gpio-pins-with-names.patch \
    file://0113-picoxcell-return-the-platform-device-on-uart-creatio.patch \
    file://0114-picoxcell-add-support-for-uart-based-UICC.patch \
    file://0115-picoxcell-pc30xx-add-support-for-NAND-device-registr.patch \
    file://0116-pc7302-ensure-that-the-GPIO-NAND-muxing-is-correctly.patch \
    file://0117-picoxcell-pc7302-increase-NOR-bootloader-size-to-256.patch \
    file://0118-picoxcell-pc7302-rework-NAND-partition-sizes.patch \
    file://0119-picoxcell-pc7302-add-a-dependency-on-pc3x2-pc3x3.patch \
    file://0120-picoxcell-pc30xx-add-the-location-of-the-3rd-UART.patch \
    file://0121-picoxcell-pc7308-add-initial-support-for-the-pc7308-.patch \
    file://0122-picoxcell-add-an-axi2pico-clkdev-lookup.patch \
    file://0123-keystream-add-a-keystream-generator.patch \
    file://0124-picoif-add-picoif.patch \
    file://0125-packetmanager-add-the-picoChip-packetmanager-driver.patch \
    file://0126-picoxcell-register-the-picoarray.patch \
    file://0127-picoxcell-allow-CONFIG_HZ-to-be-configured.patch \
    file://0128-picoxcell-pc30xx-handle-the-new-IPSEC-SPAcc-location.patch \
    file://0129-picoxcell-clk-set-lower-limit-for-enable-count-to-0.patch \
    file://0130-picogpio-add-an-ioctl-based-userspace-gpio-interface.patch \
    file://0131-pc3xxfracn-add-support-for-the-PC3XX-Frac-N.patch \
    file://0132-picoxcell-add-a-fuse-reading-helper.patch \
    file://0133-picoxcell-add-socinfo-support.patch \
    file://0134-pc3xx-spi-add-support-for-the-pc3xx-spi-master.patch \
    file://0135-spi-picoxcell-add-support-for-the-pc3xx-spi-master.patch \
    file://0136-picoxcell-rename-the-SPI-clk-s.patch \
    file://0137-picoxcell-register-the-SPI-device.patch \
    file://0138-picoxcell-pc7302-register-the-SPI-board-info.patch \
    file://0139-watchdog-add-support-for-the-Synopsys-DesignWare-WDT.patch \
    file://0140-picoxcell-register-the-watchdog.patch \
    file://0141-nand-gpio-Add-MTD-command-line-partitioning-to-the-g.patch \
    file://0142-macb-add-sysfs-support-for-1588-TSU.patch \
    file://0143-picoxcell-add-a-defconfig-file.patch \
    file://0144-picoif-enable-the-axi2pico-clk.patch \
    file://0145-hw_random-picoxcell-trng-convert-to-runtime-pm.patch \
    file://0146-crypto-picoxcell-add-support-for-runtime-PM.patch \
    file://0147-picoxcell-pc3x3-use-the-dummy-clk-for-the-watchdog.patch \
    file://0148-picoxcell-pc30xx-round-PLL-output-rate-to-nearest-MH.patch \
    file://0149-nand-denali-annotate-pci-init-exit-functions-with-co.patch \
    file://0150-nand-denali-allow-the-number-of-ECC-bits-to-be-set-b.patch \
    file://0151-nand-denali-support-hardware-with-internal-ECC-fixup.patch \
    file://0152-nand-denali-support-MTD-partitioning.patch \
    file://0153-mtd-denali-support-for-cmdline-partitioning.patch \
    file://0154-nand-denali-convert-to-dev_-printk-helpers.patch \
    file://0155-nand-denali-split-the-generic-driver-and-PCI-layer.patch \
    file://0156-nand-denali-add-an-mmio-driver.patch \
    file://0157-mtd-denali-detect-the-number-of-banks-before-resetti.patch \
    file://0158-picoxcell-pc7302-add-a-false-read-location-for-GPIO-.patch \
    file://0159-picoxcell-serial-add-DesignWare-8250-USR-workaround.patch \
    file://0160-tty-serial-allow-ports-to-override-the-irq-handler.patch \
    file://0161-tty-serial8250-allow-platforms-to-override-irq-handl.patch \
    file://0162-mips-msp71xx-serial-convert-to-pr_foo-helpers.patch \
    file://0163-mips-msp71xx-serial-add-workaround-for-DW-UART.patch \
    file://0164-tty-serial8250-remove-UPIO_DWAPB-32.patch \
    file://0165-picoxcell-mux-allow-platforms-to-specify-a-set-callb.patch \
    file://0166-picoxcell-pc30xx-allow-full-muxing-of-the-decode-pin.patch \
    file://0167-picoxcell-pc30xx-allow-muxing-of-the-EBI-NAND-interf.patch \
    file://0168-packetmanager-remove-data-on-invalid-key.patch \
    file://0169-crypto-picoxcell-disable-the-device-at-removal.patch \
    file://0170-hwrng-picoxcell-disable-runtime-pm-at-device-removal.patch \
    file://0171-picoxcell-pc7308-add-mtd-partitions-for-the-nand-fsb.patch \
    file://0172-packetmanager-use-the-correct-lock-key.patch \
    file://0173-packetmanager-ensure-we-don-t-transfer-too-much-data.patch \
    file://0174-pktman-preserve-real-start-idx-rather-than-relative-.patch \
    file://0175-packetmanager-allow-reopening.patch \
    file://0176-packetmanager-remove-redundant-pktman_kreq-children.patch \
    file://0177-macb-set-quirks-before-they-are-used.patch \
    file://0178-picoxcell_fuse-fix-unbalanced-runtime-pm.patch \
    file://0179-picoxcell-update-defconfig-for-testability.patch \
    file://0180-picoxcell-pc7308-don-t-register-the-2nd-UART.patch \
    file://0181-x86-mrst-share-APB-timer-code-with-other-platforms.patch \
    file://0182-picoif-Fixed-the-cause-of-the-.pico-load-file-fail.patch \
    file://0183-picoif-Fixed-up-a-compiler-warning.patch \
    file://0184-picoxcell-pc30xx-add-emac-initialisation.patch \
    file://0185-picoxcell-pc7308-Add-support-for-flashing-an-led-whe.patch \
    file://0186-picoif-Mantis-issue-9868-Fixed-bug-that-was-preventi.patch \
    file://0187-picoxcell-pc7308-Specified-additional-v2-ipsec-clock.patch \
    file://0188-packetmanager-Fixed-inconsistency-in-spinlocks.patch \
    file://0189-nand-denali-dma-setup-changes-to-run-on-picoxcell-de.patch \
    file://0190-Buildsys-USIM-data-invert-now-enabled-in-the-default.patch \
    file://0191-Buildsys-Implement-USIM-data-invert-enabled-as-defau.patch \
    file://0192-picoxcell-pc30xx-change-the-way-the-arm-pll-frequenc.patch \
    file://0193-picoxcell-pc30xx-change-the-way-the-arm-pll-frequenc.patch \
    file://0194-picoxcell-cpu-frequency-scaling-default-governor-now.patch \
    file://0195-picoxcell-pc30xx-register-the-sdgpio-pins.patch \
    file://0196-crypto-picoxcell-fix-invalid-pointer-dereference.patch \
    file://0197-tty-serial8250-fix-incorrect-uart-type-reporting-in-.patch \
    file://0198-picoxcell-add-in-the-pc3032-device-id.patch \
    file://0199-pc73032-add-support-for-the-pc73032-platform.patch \
    file://0200-spi-picoxcell-change-the-error-reporting.patch \
    file://0201-picoxcell-update-defconfig-to-include-the-pc73032-pl.patch \
    file://0202-pc7308-add-support-for-spi-flash-on-the-pc7308-platf.patch \
    file://0203-otp-pc30xx-fixed-programming-of-the-pc30xx-OTP.patch \
    file://0204-pc73032-add-a-work-round-for-the-pc30xx-rgmii-transm.patch \
    file://0205-pc73032-add-mtd-partition-definitions-for-nor-flash.patch \
    file://0206-mtd-cfi_cmdset_0002-Micron-M29EW-bugfixes-as-per-TN-.patch \
    file://0207-mtd-enabled-buffered-programming-for-M29EW-in-x8-Mod.patch \
    file://0208-nand-fix-the-denali-read-write_oob_data-functions.patch \
    file://0209-spi-picoxcell-driver-enhanced-to-run-on-pc30xx-devic.patch \
    file://0210-nand-fixup-onfi-parameter-reading.patch \
    file://0211-nand-disable-sub-page-writes.patch \
    file://0212-picoif-pc3xx-Changed-kmalloc-flags-in-pc3xx.x.patch \
    file://0213-macb-Fixed-potential-deadlock.patch \
    file://0214-picoxcell_fuse-Added-fuse-blowing-delay-parameter.patch \
    file://0215-pc73032-modify-a-work-round-for-the-pc30xx-1Gbit-rgm.patch \
    file://0216-picoxcell-update-defconfig-to-enable-CONFIG_CRYPTO_N.patch \
    file://0217-ipv4-fix-ipsec-forward-performance-regression.patch \
    file://0218-ipv4-Reverting-fix-ipsec-forward-performance-regress.patch \
    file://0219-ipv4-fix-ipsec-forward-performance-regression.patch \
    file://0220-picogpio-bug-fix-to-prevent-sleeping-with-spin-lock-.patch \
    file://0221-tty-serial8250-fix-kernel-lockup-bug-while-communica.patch \
    file://0222-macb-Rx-zero-copy-performance-enhancement.patch \
    file://0223-phy_device-New-Ethernet-PHY-sysfs-interface-attribut.patch \
    file://0224-crypto-picoxcell-Performance-Enhancement-of-picoxcel.patch \
    file://0225-crypto-picoxcell-Disabled-LOCAL_DDT.patch \
    file://0226-crypto-picoxcell-Removed-Performance-Enhancement-of-.patch \
    file://0227-macb-minor-correction-of-MACB_SKB_SIZE.patch \
    file://0228-macb-Removed-tx-error-handling-on-UND-RLE-to-resolve.patch \
    "

SRC_URI[md5sum] = "398e95866794def22b12dfbc15ce89c0"
SRC_URI[sha256sum] = "64b0228b54ce39b0b2df086109a7b737cde58e3df4f779506ddcaccee90356a0"
