package post

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletResponse

class PostRequest extends ZuulFilter {

    @Override
    String filterType() {
        return "post";
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
        HttpServletResponse response = ctx.getResponse();

        System.out.println("response code is : " + response.getStatus());
        //print ("response code is : " + RequestContext.currentContext().response().status());
        return null;
    }
}
