package com.persen.beijing.password;


public class TestChinese {

    public static void toHex(char[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.printf("%x ", (int) b[i]);
        }
        System.out.println();
    }

    public static void toHex(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.printf("%x %d ", b[i], b[i]);
        }
        System.out.println();
    }

    public static void encode() {
        String name = "I am 中文编码";
        toHex(name.toCharArray());
        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            toHex(iso8859);
            byte[] gb2312 = name.getBytes("GB2312");
            toHex(gb2312);
            byte[] gbk = name.getBytes("GBK");
            toHex(gbk);
            byte[] utf16 = name.getBytes("UTF-16");
            toHex(utf16);
            byte[] utf8 = name.getBytes("UTF-8");
            toHex(utf8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String cn = "中文编码"; // 这里存在编码转换: 将文件存储字节转成unicode存入String对象内存. 采用文件编码

        char[] charArray = cn.toCharArray();
        byte[] data = cn.getBytes();

        System.out.println("print char array : " + cn);
        toHex(cn.toCharArray());
        toHex(data);

        cn = "���ı���"; // 这里存在编码转换: 将文件存储字节转成unicode存入String对象内存. 采用文件编码。
        // 显示乱码是由于文件采用的编码无法解码文件存储字节数据。故存到String的unicode也是乱码的
        charArray = cn.toCharArray();
        System.out.println("print char array: " + cn);
        toHex(cn.toCharArray());

        encode();
    }

}
