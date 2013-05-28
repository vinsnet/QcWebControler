package fr.amnezic.qcwebcontrol.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import fr.amnezic.qcwebcontrol.model.jpa.JpaModelRepositoriesConfig ;


public class RestModelWebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {

	    // Create the 'root' Spring application context
	    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	    rootContext.register(JpaModelRepositoriesConfig.class);
	    //TODO ano 32
	    
	    
	    // Manage the lifecycle of the root application context
	    container.addListener(new ContextLoaderListener(rootContext));
	    
	    AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
	    DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		dispatcherContext.register(RepositoryRestMvcConfiguration.class);
	    ServletRegistration.Dynamic reg = container.addServlet("model-rest-exporter", dispatcherServlet);
	    // Register and map the dispatcher servlet
	    reg.setLoadOnStartup(1);
	    reg.addMapping("/model/*");
	    
	}
}

