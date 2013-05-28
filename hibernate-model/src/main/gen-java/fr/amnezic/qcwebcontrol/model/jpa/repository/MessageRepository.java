package fr.amnezic.qcwebcontrol.model.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.amnezic.qcwebcontrol.model.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message	,Long >  {

}
