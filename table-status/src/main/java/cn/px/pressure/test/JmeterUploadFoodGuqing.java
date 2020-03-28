package cn.px.pressure.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.Interruptible;
import org.apache.jmeter.samplers.SampleResult;
import org.bouncycastle.util.encoders.Base64;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by lijianyu on 2018/9/27.
 */
public class JmeterUploadFoodGuqing extends AbstractJavaSamplerClient implements Serializable, Interruptible {

    private String urlPaht = "/irs-iface/om/inf/food/v1/uploadFoodGuqing";
    private String hosts;
    private String sessionId;
    private HttpClient httpClient;
    private String url;

    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("hosts", null);
        params.addArgument("sessionId", null);
        params.addArgument("foodId", null);
        params.addArgument("enable", null);
        params.addArgument("soldOutRemain", null);
        return params;
    }

    @Override
    public void setupTest(JavaSamplerContext context) {
        this.hosts = context.getParameter("hosts");

        StringBuilder urlBuilder = new StringBuilder(hosts).append(urlPaht);
        url = urlBuilder.toString();
        System.out.println("url:" + url);

        httpClient = new HttpClient();
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult results = new SampleResult();

        results.sampleStart();

        try {
            this.sessionId = javaSamplerContext.getParameter("sessionId");
            Long foodId = javaSamplerContext.getLongParameter("foodId");
            String enable = javaSamplerContext.getParameter("enable");
            Long soldOutRemain = javaSamplerContext.getLongParameter("soldOutRemain");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("sessionId", sessionId);
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonData = new JSONObject();
            jsonData.put("foodId", foodId);
            jsonData.put("enable", Boolean.valueOf(enable));
            jsonData.put("soldOutRemain", soldOutRemain);
            jsonArray.add(jsonData);
            jsonObject.put("data", jsonArray);

            System.out.println("json:" + jsonObject);

            String result = HttpClientUtil.poseRequestInputStreamByGzip(httpClient, url, jsonObject);

            System.out.println("result:" + result);

            JSONObject retJson = JSONObject.fromObject(result);

            results.setDataEncoding("UTF-8");
            Integer code = retJson.getInt("code");
            if (200 == code) {
                results.setSuccessful(true);
            } else {
                results.setSuccessful(false);
            }
        } catch (Exception e) {
            results.setSuccessful(false);
        }
        results.sampleEnd();
        return results;
    }

    @Override
    public void teardownTest(JavaSamplerContext arg0) {
        ((SimpleHttpConnectionManager) httpClient.getHttpConnectionManager()).shutdown();
    }

    @Override
    public boolean interrupt() {
        return false;
    }
}
