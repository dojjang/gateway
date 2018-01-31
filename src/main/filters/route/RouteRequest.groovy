package route

import com.netflix.zuul.ZuulFilter

class RouteRequest extends ZuulFilter {

    //most often defines the stage during the routing flow when the filter will be applied (although it can be any custom string)
    @Override
    public String filterType() {
        return "route";
    }

    //applied within the Type, defines the order of execution across multiple filters
    @Override
    public int filterOrder() {
        return 1;
    }

    //the conditions required in order for the filter to be executed
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //the action to be executed if the Criteria are met
    @Override
    public Object run() {
        System.out.println("Inside Route Filter2");
        return null;
    }
}
