package fr.amnezic.qcwebcontrol.model.rest.handlers;

import java.util.List;

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

	  List<Aggregat> aggregats = aggregatRepository.findByLabel(m.getContenu());
	  Aggregat firstAggragat = null;
	  if(aggregats==null || aggregats.isEmpty()){
		  firstAggragat = new Aggregat();
		  firstAggragat.setLabel(m.getContenu());
	  }else{
		  firstAggragat = aggregats.get(0);
	  }
	  firstAggragat.setCount(firstAggragat.getCount()+1);
	  aggregatRepository.save(firstAggragat);
  }



}
