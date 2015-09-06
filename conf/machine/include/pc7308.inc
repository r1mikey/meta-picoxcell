require conf/machine/include/picoxcell.inc

UBOOT_CONFIG[nand] = "picochippc7302nand,ubi"

KERNEL_MODULE_AUTOLOAD_append = " otp_pc30xx"
