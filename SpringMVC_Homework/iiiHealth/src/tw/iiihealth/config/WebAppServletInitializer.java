package tw.iiihealth.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//目的: 取代xml檔
//2.取代web.xml
public class WebAppServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override //設定等同於beans.config.xml角色
	protected Class<?>[] getRootConfigClasses() {		
		
		return new Class[] {RootAppConfig.class};
//		return null;
	}

	@Override //設定等同於mvc-servlet.xml角色
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] {SpringMVCJavaConfig.class};
//		return null;   //如果要把xml檔搬回來，就要把上面的return註解掉，加上return null
	}

	@Override  //設定哪些網址
	protected String[] getServletMappings() {		
		return new String[] {"/"};  //斜線代表所有網址都歸我管
	}

	@Override  //設定語言UTF-8
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodeFilter=new CharacterEncodingFilter();
		encodeFilter.setEncoding("UTF-8");
		encodeFilter.setForceEncoding(true);
		return new Filter[] {encodeFilter};
		
	}
	
	

}
