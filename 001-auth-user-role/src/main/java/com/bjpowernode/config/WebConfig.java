package com.bjpowernode.config;

import com.bjpowernode.util.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		//如果报错，则自动走/error
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/login","/saveLogin","/error","/imgs/**","/js/**");
	}
	
	
/*	@Value("${upload.url}")
	String url;
	

	@Value("${upload.dir}")
	String dir;*/
	
/*	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//虚似路径映射（自定义映射）
        registry.addResourceHandler(url).addResourceLocations("file:" + dir);       
    }*/

	

}
