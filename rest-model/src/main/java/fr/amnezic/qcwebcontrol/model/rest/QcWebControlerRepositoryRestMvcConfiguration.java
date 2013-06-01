package fr.amnezic.qcwebcontrol.model.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import fr.amnezic.qcwebcontrol.model.rest.handlers.EventHandler;

@Configuration
public class QcWebControlerRepositoryRestMvcConfiguration extends
		RepositoryRestMvcConfiguration {


	public QcWebControlerRepositoryRestMvcConfiguration() {
		super();
	}
	
	@Override protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		  config.setPageParamName("p")
		        .setLimitParamName("l")
		        .setSortParamName("s");
		}

	@Bean
	EventHandler defaultEventHandler(){
		return new EventHandler();
	}
	
	

}
