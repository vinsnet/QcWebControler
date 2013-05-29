package fr.amnezic.qcwebcontrol.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.amnezic.qcwebcontrol.model.rest.handlers.EventHandler;
@Configuration()
@ComponentScan({"fr.amnezic.qcwebcontrol.model.rest.repository"})
public class RestRepositoriesConfig {

	
}
