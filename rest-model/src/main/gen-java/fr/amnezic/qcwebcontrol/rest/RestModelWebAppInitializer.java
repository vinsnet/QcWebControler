package fr.amnezic.qcwebcontrol.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import fr.amnezic.qcwebcontrol.model.jpa.JpaModelRepositoriesConfig;
import fr.amnezic.qcwebcontrol.model.rest.QcWebControlerRepositoryRestMvcConfiguration;

public class RestModelWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext jpaContext = new AnnotationConfigWebApplicationContext();
		jpaContext.register(JpaModelRepositoriesConfig.class);
		jpaContext.refresh();

		AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
		restContext.setParent(jpaContext);
		restContext.register(RestRepositoriesConfig.class);

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(restContext));

		restContext.register(getRepositoryRestMvcConfigurationClass());
		DispatcherServlet dispatcherServlet = new RepositoryRestDispatcherServlet(
				restContext);
		ServletRegistration.Dynamic reg = container.addServlet(
				"model-rest-exporter", dispatcherServlet);
		// Register and map the dispatcher servlet
		reg.setLoadOnStartup(1);
		reg.addMapping("/model/*");

	}

	/**
	 * @generated not
	 */
	protected Class<? extends RepositoryRestMvcConfiguration> getRepositoryRestMvcConfigurationClass() {
		return fr.amnezic.qcwebcontrol.model.rest.QcWebControlerRepositoryRestMvcConfiguration.class;
	}

}
