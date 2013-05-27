

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InfoWebAppInitializer implements WebApplicationInitializer {

	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
	
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.setServletContext(servletContext);
		appContext.register(InfoWebAppConfig.class);
		appContext.scan("fr.vinsnet.tarots.info");
		
		appContext.refresh();
		
		DispatcherServlet servlet = new DispatcherServlet(appContext);
		
	    ServletRegistration.Dynamic reg = servletContext.addServlet("info", servlet);
	    reg.setLoadOnStartup(1);
	    reg.addMapping("/info/*");
		
	}
	
}
