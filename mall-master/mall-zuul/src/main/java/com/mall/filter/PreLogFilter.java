package com.mall.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * ServletDetectionFilter	pre	-3	检测当前请求是通过DispatcherServlet处理运行的还是ZuulServlet运行处理的。
 * Servlet30WrapperFilter	pre	-2	对原始的HttpServletRequest进行包装。
 * FormBodyWrapperFilter	pre	-1	将Content-Type为application/x-www-form-urlencoded或multipart/form-data的请求包装成FormBodyRequestWrapper对象。
 * DebugFilter	route	1	根据zuul.debug.request的配置来决定是否打印debug日志。
 * PreDecorationFilter	route	5	对当前请求进行预处理以便执行后续操作。
 * RibbonRoutingFilter	route	10	通过Ribbon和Hystrix来向服务实例发起请求，并将请求结果进行返回。
 * SimpleHostRoutingFilter	route	100	只对请求上下文中有routeHost参数的进行处理，直接使用HttpClient向routeHost对应的物理地址进行转发。
 * SendForwardFilter	route	500	只对请求上下文中有forward.to参数的进行处理，进行本地跳转。
 * SendErrorFilter	post	0	当其他过滤器内部发生异常时的会由它来进行处理，产生错误响应。
 * SendResponseFilter	post	1000	利用请求上下文的响应信息来组织请求成功的响应内容。
 */
@Component
public class PreLogFilter extends ZuulFilter {

    /**
     * 过滤器类型，有pre、routing、post、error四种。
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /**
     * 过滤器执行顺序，数值越小优先级越高。
     */
    @Override
    public int filterOrder() {
        return FilterConstants.DEBUG_FILTER_ORDER;
    }
    /**
     * 是否进行过滤，返回true会执行过滤。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 自定义的过滤器逻辑，当shouldFilter()返回true时会执行。
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
