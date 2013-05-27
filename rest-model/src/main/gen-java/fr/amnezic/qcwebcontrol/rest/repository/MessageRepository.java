package fr.amnezic.qcwebcontrol.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import fr.amnezic.qcwebcontrol.model.Message;

@RestResource(exported=true,rel="message")
public interface MessageRepository extends PagingAndSortingRepository<Message	,Long >  {

}
