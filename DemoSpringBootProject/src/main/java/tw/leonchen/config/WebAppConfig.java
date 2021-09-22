package tw.leonchen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	//ex: 帳:mary 密:icandoitbetter & 帳:louis 密:test123
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login/page").setViewName("login");
		registry.addViewController("/login/welcome").setViewName("welcome");
		registry.addViewController("/logout/page").setViewName("logout");
		registry.addViewController("/logout").setViewName("logoutResult");
	}

}
