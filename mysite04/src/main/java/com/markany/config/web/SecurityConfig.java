package com.markany.config.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.markany.security.AuthInterceptor;
import com.markany.security.AuthUserHandlerMethodArgumentResolver;

@Configuration
@EnableWebMvc
public class SecurityConfig extends WebMvcConfigurerAdapter {
	// 1. Argument Resolver
	public HandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(authUserHandlerMethodArgumentResolver());
	}
	
	
	// 2 .Interceptors
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new AuthInterceptor();
	}
	
	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new AuthInterceptor();
	}
	
	@Bean
	public HandlerInterceptor authInterceptor() {
		return new AuthInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
				.addInterceptor(loginInterceptor())
				.addPathPatterns("/user/auth");
		registry
				.addInterceptor(authInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/user/auth")
				.excludePathPatterns("/user/logout")
				.excludePathPatterns("/assets/**");
	}
	
}





