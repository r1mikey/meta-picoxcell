require conf/machine/include/picoxcell.inc

UBOOT_CONFIG[nand] = "picochippc7302nand,ubi"
UBOOT_CONFIG[nor] = "picochippc7302nor,jffs2"

KERNEL_MODULE_AUTOLOAD_append = " otp_pc30xx"
