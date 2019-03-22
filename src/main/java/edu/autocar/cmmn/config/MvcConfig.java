package edu.autocar.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import edu.autocar.cmmn.interceptor.AdminInterceptor;
import edu.autocar.cmmn.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "edu.autocar" })
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(new BeanNameViewResolver());
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-layout.xml" });
		tilesConfigurer.setCheckRefresh(true);

		return tilesConfigurer;
	}

	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Bean
	public AdminInterceptor adminInterceptor() {
		return new AdminInterceptor();
	}

	// 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		/*
		registry.addInterceptor(loginInterceptor()); // 인터셉터 등록
		
		registry.addInterceptor(adminInterceptor()) // 인터셉터 등록
				.addPathPatterns("/admin/**"); // 적용 url 패턴
		*/
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
}
