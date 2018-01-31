package com.example.filters;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//요청에 대한 라우팅을 다루는 필터이다. Apache httpclient를 사용하여 정해진 Url로 보낼수 있고, Neflix Ribbon을 사용하여 동적으로 라우팅 할 수도 있다.

public class RouteFilter extends ZuulFilter {

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
        System.out.println("Inside Route Filter");
        return null;
    }
}
