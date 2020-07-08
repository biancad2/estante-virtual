package br.fatec.estantevirtual;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

@EnableAutoConfiguration
@ComponentScan({"br.fatec.estantevirtual"})
public class EstanteVirtualApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EstanteVirtualApplication.class, args);
	}
	
	 @Bean
	    public ServletRegistrationBean servletRegistrationBean() {
	        FacesServlet servlet = new FacesServlet();
	        return new ServletRegistrationBean(servlet, "*.jsf");
	    }

	    @Bean
	    public FilterRegistrationBean rewriteFilter() {
	        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
	        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
	                DispatcherType.ASYNC, DispatcherType.ERROR));
	        rwFilter.addUrlPatterns("/*");
	        return rwFilter;
	    }

}
