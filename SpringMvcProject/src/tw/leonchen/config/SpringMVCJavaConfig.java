package tw.leonchen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//等同於mvc-servlet.xml
@Configuration
@EnableWebMvc	//等同於<mvc:annotation-driven/>
@ComponentScan(basePackages = {"tw.leonchen"})	//等同於<context:component-scan base-package="tw.leonchen"/>
public class SpringMVCJavaConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmpartResolver = new CommonsMultipartResolver();
		cmpartResolver.setDefaultEncoding("UTF-8");
		return cmpartResolver;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/"); 	//資源掌控: 虛擬位置	//增加實際位置
//		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/"); 	//資源掌控: 虛擬位置	//增加實際位置
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:membersEntry.controller"); 	//輸入http://localhost:8080/SpringMvcProject/ , 自動連到membersEntry.controller	
	}

}
