package com.persen.beijing.webservice;

import java.security.MessageDigest;

public class testClient {

    public static void main(String[] args) {
        //BssImprestChargeService service = new BssImprestChargeService();
        //BssImprestChargeServicePortType bpt = service
        //		.getBssImprestChargeServiceHttpPort();
        // *访问ID，测试默认 16
        String in0 = "16";
        // *访问密码，测试默认 2O3I4J21L2K3J
        String in1 = "2O3I4J21L2K3J";
        // *访问类型，测试默认 1
        String in2 = "1";
        // *手机号
        String in3 = "17098821706";
        // *订单号
        String in4 = "114";
        // *充值金额
        String in5 = "1";
        // * 减扣标识
        String in6 = "2";
        // *返回类型，值为json或xml
        String in7 = "json";
        // *校验串MD5(Int0+Int1+Int2+Int3+Int4+Int5+Int6+int7+key)后转大写,测试环境默认用：A223L1J2H3S0DF98SKLJ,正式环境需要申请
        String mdString = in0 + in1 + in2 + in3 + in4 + in5 + in6 + in7
                + "A223L1J2H3S0DF98SKLJ";
        String in8 = MD5(mdString);
        System.out.println(in8);
        /*
		try {
			String ret = bpt.bssChargeByDealflag(in0, in1, in2, in3, in4, in5,
					in6, in7, in8);
			System.out.println(ret);
		} catch (ServiceException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
