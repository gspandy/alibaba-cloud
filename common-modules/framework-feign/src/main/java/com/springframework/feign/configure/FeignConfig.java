package com.springframework.feign.configure;

//import com.springframework.trace.constant.CatMsgConstants;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author summer
 * 2018/8/1
 */
@Slf4j
public class FeignConfig implements RequestInterceptor {
    @Value("${spring.application.name}")
    private String clientServiceId;
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String X_FEIGNORIGIN_HEADER = "X-FeignOrigin";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //添加 X-FeignOrigin
        requestTemplate.header(X_FEIGNORIGIN_HEADER, clientServiceId);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes instanceof ServletRequestAttributes) {
            request = ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        if (Objects.isNull(request)) {
            log.warn(" 开始Feign远程调用 :" + requestTemplate.method() +" requestAttributes 参数为 null");
            return;
        }
        //传递请求头
        Map<String, String> headers = getHeaders(request);
        for (String headerName : headers.keySet()) {
            requestTemplate.header(headerName, getHeaders(request).get(headerName));
        }
        //支持cat 传递消息树，上下文
//        String rootId = (String) requestAttributes.getAttribute(Cat.Context.ROOT, 0);
//        String childId = (String) requestAttributes.getAttribute(Cat.Context.CHILD, 0);
//        String parentId = (String) requestAttributes.getAttribute(Cat.Context.PARENT, 0);
//        requestTemplate.header(Cat.Context.ROOT, rootId);
//        requestTemplate.header(Cat.Context.CHILD, childId);
//        requestTemplate.header(Cat.Context.PARENT, parentId);
//        requestTemplate.header(CatMsgConstants.APPLICATION_KEY, Cat.getManager().getDomain());
//        log.info(" 开始Feign远程调用 : " + requestTemplate.method() + " 消息模型 : rootId = " + rootId + " parentId = " + parentId + " childId = " + childId);
        log.info(" 开始Feign远程调用 : " + requestTemplate.method() );

    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}

