package error

import com.netflix.zuul.ZuulFilter

class ErrorRequest extends ZuulFilter {

    @Override
    String filterType() {
        return "error";
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
        System.out.println("Inside Route Filter2");

        return null;
    }
}
