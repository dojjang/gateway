package com.example;

import com.example.filters.ErrorFilter;
import com.example.filters.PostFilter;
import com.example.filters.PreFilter;
import com.example.filters.RouteFilter;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
//@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {

		GatewayApplication app = new GatewayApplication();
		app.initGroovyFilterManager();

		SpringApplication.run(GatewayApplication.class, args);
	}

	private void initGroovyFilterManager() {
		FilterLoader.getInstance().setCompiler(new GroovyCompiler());

		try {
			FilterFileManager.setFilenameFilter(new GroovyFileFilter());

			String basePath = "D:/dev/gateway/src/main/filters/";

			FilterFileManager.init(1, basePath + "pre", basePath + "route", basePath + "post", basePath + "error");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

//	@Bean
//	public PreFilter preFilter() {
//		return new PreFilter();
//	}
//	@Bean
//	public RouteFilter routeFilter() {
//		return new RouteFilter();
//	}
//	@Bean
//	public PostFilter postFilter() {
//		return new PostFilter();
//	}
//	@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}

}
