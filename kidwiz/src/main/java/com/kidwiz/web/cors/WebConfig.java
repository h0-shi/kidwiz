package com.kidwiz.web.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost") // Vue 앱의 도메인
		//.allowedOrigins("*")
		.allowedMethods("GET", "POST", "DELETE")
		//.maxAge(3000);
		.allowCredentials(true);
	}
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("/PersonTest")
	 * .addResourceLocations("file:///path/to/vue/project/dist/PersonTest.vue"); }
	 */
	

}