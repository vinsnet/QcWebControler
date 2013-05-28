	
package fr.amnezic.qcwebcontrol;
	

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.amnezic.qcwebcontrol.model.Message;
	

	public class DaoTest{

		
	
		
			public static void main(String[] args) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
				AbstractApplicationContext context =   new ClassPathXmlApplicationContext(new String []{"fr/amnezic/qcwebcontrol/model/spring-hibernate.xml"});
	
				//DataSourceTransactionManager tm = (JtaTransactionManager)context.getBean("modelTransactionManager");
				EntityManagerFactory emf = (EntityManagerFactory)context.getBean("modelEntityManagerFactory");
				EntityManager em = emf.createEntityManager();
				EntityTransaction t = em.getTransaction();
				t.begin();
				
				Message m1 = new Message();
				m1.setContenu("Coucou Wayna");
				
				Message m2 = new Message();
				m2.setContenu("Coucou Chet'Bi");
				m2.setDateValidation(new Date());
				m2.setIsValid(true);


				em.persist(m1);
				em.persist(m2);
				t.commit();
				context.close();
			}

		
		
	}

