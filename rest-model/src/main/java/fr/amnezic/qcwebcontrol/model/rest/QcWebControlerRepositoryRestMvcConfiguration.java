package fr.amnezic.qcwebcontrol.model.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import fr.amnezic.qcwebcontrol.model.rest.handlers.EventHandler;

@Configuration
public class QcWebControlerRepositoryRestMvcConfiguration extends
		RepositoryRestMvcConfiguration {


	public QcWebControlerRepositoryRestMvcConfiguration() {
		super();
	}
	

	@Bean
	EventHandler defaultEventHandler(){
		return new EventHandler();
	}
	
	

}
