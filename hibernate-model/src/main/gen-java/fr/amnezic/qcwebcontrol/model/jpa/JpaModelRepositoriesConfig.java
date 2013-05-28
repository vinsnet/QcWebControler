package fr.amnezic.qcwebcontrol.model.jpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration()
@ImportResource("classpath:fr/amnezic/qcwebcontrol/model/spring-hibernate.xml")
@EnableJpaRepositories(entityManagerFactoryRef = "modelEntityManagerFactory",transactionManagerRef="modelTransactionManager")
@ComponentScan("fr.amnezic.qcwebcontrol.model.jpa.repository")
public class JpaModelRepositoriesConfig {

}
