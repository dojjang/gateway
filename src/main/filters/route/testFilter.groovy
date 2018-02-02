package route

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletRequest


class testFilter extends ZuulFilter {

    @Override
    String filterType() {
        return "route";
    }

    @Override
    int filterOrder() {
        return 1;
    }

    @Override
    boolean shouldFilter() {
//        String path = RequestContext.getCurrentContext().getRequest().getRequestURI();
//        return "/microservice/".equals(path);
        return true;
    }

    @Override
    Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        println "test"

        //URL reUrl = new URL("http://localhost:8086");

        println "test2"
        //ctx.setRouteHost(reUrl);


        return null;
    }
}
