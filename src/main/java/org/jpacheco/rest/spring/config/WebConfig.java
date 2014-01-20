package org.jpacheco.rest.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@Import(AppConfig.class)
public class WebConfig extends WebMvcConfigurerAdapter{

	public WebConfig() {
		super();
	}

	 

	public void addViewControllers(final ViewControllerRegistry registry) {
		super.addViewControllers(registry);

		registry.addViewController("/sample.html");
		registry.addViewController("/login.html");
		registry.addViewController("/homepage.html");
	}

	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver bean = new InternalResourceViewResolver();

		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");

		return bean;
	}
}
