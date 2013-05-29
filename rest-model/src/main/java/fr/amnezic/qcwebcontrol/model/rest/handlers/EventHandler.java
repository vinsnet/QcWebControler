package fr.amnezic.qcwebcontrol.model.rest.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.repository.annotation.HandleAfterCreate;
import org.springframework.data.rest.repository.annotation.HandleAfterSave;
import org.springframework.data.rest.repository.annotation.RepositoryEventHandler;

import fr.amnezic.qcwebcontrol.model.Aggregat;
import fr.amnezic.qcwebcontrol.model.Message;
import fr.amnezic.qcwebcontrol.model.jpa.repository.AggregatRepository;

@RepositoryEventHandler
public class EventHandler  {

	
	public EventHandler() {
	super();
	}
	
  @Autowired
  private AggregatRepository aggregatRepository;

  
  
	
  @HandleAfterCreate(Message.class)
  @HandleAfterSave(Message.class)
  
  public void handleAfterMessageSave(Message m) {

	  Aggregat aggregat = aggregatRepository.findByLabel(m.getContenu());
	  if(aggregat==null){
		  aggregat = new Aggregat();
		  aggregat.setLabel(m.getContenu());
	  }
	  aggregat.setCount(aggregat.getCount()+1);
	  aggregatRepository.save(aggregat);
  }



}
