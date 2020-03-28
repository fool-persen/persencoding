package com.persen.bj.controler;

import cn.px.irs.hystrix.core.annotation.P1;
import cn.px.irs.hystrix.core.annotation.P2;
import cn.px.irs.hystrix.core.annotation.P3;
import cn.px.irs.hystrix.core.service.PropertiesService;
import cn.px.irs.hystrix.refresh.jedis.RedisTemplate;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.persen.bj.command.StringHystrixCommond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lijianyu on 2018/11/3.
 */
@RestController
public class HystrixControler {
    @Autowired
    PropertiesService propertiesService;
    //    @Autowired
//    WatchedConfigSource watchedConfigSource;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/func00/{times}")
    public String func00(@PathVariable(value = "times") long times) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put("P2.test2.coreSize" + i, "1");
            map.put("P2.test2.timeout" + i, "1");
            map.put("P2.test2.maximumSize" + i, "1");
            map.put("P2.test2.keepAliveTimeMinutes" + i, "1");
            map.put("P2.test3.HystrixControler.func30.timeout" + i, "1");
        }
        redisTemplate.hmset("testHystrix", map);
        return "succ";
    }

    @GetMapping("/func0/{times}")
    public String func0(@PathVariable(value = "times") long times) {
        try {
//            watchedConfigSource.refresh();
            System.out.println("reuqes func0 " + times);
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succ";
    }

    @GetMapping("/func1/{times}")
    @P1(threadPoolKey = "test1", fallbackMethod = "fallback1")
    @HystrixCommand()
    public String func1(@PathVariable(value = "times") long times) {
        try {
            System.out.println("reuqes func1 " + times);
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succ";
    }

    public String fallback1(long ll) {
        return "can't say hi" + ll;
    }

    @GetMapping("/func2/{times}")
    @P2(threadPoolKey = "test2", fallbackMethod = "fallback")
    @HystrixCommand()
    public String func2(@PathVariable(value = "times") long times) {
        try {
            System.out.println("reuqes func2 " + times);
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succ";
    }


    @GetMapping("/func30/{times}")
    @P3(fallbackMethod = "fallback")
    @HystrixCommand()
    public String func30(@PathVariable(value = "times") long times) {
        try {
            System.out.println("reuqes func2 " + times);
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succ";
    }

    @GetMapping("/func31/{times}")
    @P3(fallbackMethod = "fallback")
    @HystrixCommand()
    public String func31(@PathVariable(value = "times") long times) {
        try {
            System.out.println("reuqes func2 " + times);
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succ";
    }

    @GetMapping("/func32/{times}")
    @P3(fallbackMethod = "fallback")
    @HystrixCommand()
    public String func32(@PathVariable(value = "times") long times) {
        try {
            System.out.println("reuqes func2 " + times);
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        }
        return "succ";
    }

    @GetMapping("/func3")
    public String func3() {
//        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.HystrixControler#func1(long).execution.isolation.thread.timeoutInMilliseconds", "500");
//        System.out.println(System.getProperty("user.dir"));
        getAllApi();
        Boolean ret = propertiesService.refresh();

        if (ret) {
            return "succ";
        } else {
            return "fall";
        }
    }

    public String fallback(long ll, Throwable e) {
        System.out.println(e.toString());
        return "can't say hi" + ll;
    }


    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    public void getAllApi() {
        Map map = this.handlerMapping.getHandlerMethods();
        Set set = map.keySet();
        for (Object object : set) {
            RequestMappingInfo info = (RequestMappingInfo) object;
            String reqURIs = info.getPatternsCondition().toString();
            System.out.println(reqURIs.substring(1, reqURIs.length() - 1));
        }
    }

    @GetMapping("/func4/{times}")
    public String func4(@PathVariable(value = "times") long times) {
        try {
            System.out.println("reuqes func4 " + times);
            Thread.sleep(times);

            String dynamicProperty = DynamicPropertyFactory.getInstance()
                    .getStringProperty("hystrix.command.stringCommand.execution.isolation.thread.timeoutInMilliseconds",
                            "<none>")
                    .get();

            Future<String> future = new StringHystrixCommond(dynamicProperty).queue();
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "fail";
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "succ";
    }

    @GetMapping(value = "/food/menu/{menuId}/food-list")
    public String getFoodList(HttpServletRequest request, @PathVariable("menuId") Long menuId) {
        Map<String, String[]> params = request.getParameterMap();
        //?start=&size=
        int inputStart = 0;
        int inputSize = 0;

        return null;
    }

}
