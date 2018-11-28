package com.persen.beijing.webservice;

import java.security.MessageDigest;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
//import testClick.src.testclick.HelloWebService;  
//import testClick.src.testclick.HelloWebServicePortType;  

public class TestWebservice {

    /*
     * @Test public void Test(){ //testClient(); //testRPC(); testOMElement(); }
     */

    /**
     * 第一种 MyEclipse 生成客户端方式
     */

    public void testClient() {
		/*
		HelloWebService service = new HelloWebService();
		HelloWebServicePortType portType = service
				.getHelloWebServiceHttpSoap11Endpoint();
		String result = portType.sayHello("jack");
		System.out.println(result);
		*/
    }

    /**
     * 第二种 使用axis2 RPC调用webservice 需要导入相应的jar包
     */
    public void testRPC() {
        try {
            RPCServiceClient client = new RPCServiceClient();
            Options options = client.getOptions();
            String url = "http://222.92.116.36/services/BssImprestChargeService";
            EndpointReference end = new EndpointReference(url);
            options.setTo(end);

            String Int0 = "16";
            String Int1 = "2O3I4J21L2K3J";
            String Int2 = "1";
            String Int3 = "17098821706";
            String Int4 = "113";
            String Int5 = "0.1";
            String Int6 = "2";
            String Int7 = "json";

            String mdString = Int0 + Int1 + Int2 + Int3 + Int4 + Int5 + Int6
                    + Int7 + "A223L1J2H3S0DF98SKLJ";
            String Int8 = TestWebservice.MD5(mdString);
            System.out.println(Int8);
            Object[] obj = new Object[]{Int0, Int1, Int2, Int3, Int4, Int5,
                    Int6, Int7, Int8};
            Class<?>[] classes = new Class[]{String.class};

            QName qname = new QName(
                    "http://webservice.service.business.sncp.woniu.com",
                    "bssChargeByDealflag");
            String result = (String) client.invokeBlocking(qname, obj, classes)[0];
            System.out.println(result);
        } catch (AxisFault e) {
            e.printStackTrace();
        }
    }

    /**
     * 第三种
     *
     * @throws AxisFault
     */
    public void testOMElement() {
        try {
            ServiceClient sc = new ServiceClient();
            Options opts = new Options();
            String url = "http://222.92.116.36/services/BssImprestChargeService?wsdl";
            EndpointReference end = new EndpointReference(url);
            opts.setTo(end);
            opts.setAction("bssChargeByDealflag");
            sc.setOptions(opts);

            OMFactory fac = OMAbstractFactory.getOMFactory();
            OMNamespace omNs = fac.createOMNamespace("http://testClick", "");
            OMElement method = fac.createOMElement("sayHello", omNs);
            OMElement value = fac.createOMElement("name", omNs);
            value.setText("admin");
            method.addChild(value);
            OMElement res = sc.sendReceive(method);
            res.getFirstElement().getText();
            System.out.println(res.getFirstElement().getText());
        } catch (AxisFault e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        TestWebservice ws = new TestWebservice();
        ws.testRPC();
    }
}