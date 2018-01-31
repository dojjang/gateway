package pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletRequest

class PreRequest extends ZuulFilter {

    @Override
    String filterType() {
        return "pre";
    }

    @Override
    int filterOrder() {
        return 1;
    }

    @Override
    boolean shouldFilter() {
        return true;
    }

    @Override
    Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("Request Method2 : " + request.getMethod() + " Request URL2 : " + request.getRequestURL().toString());
        return null;
    }
}
