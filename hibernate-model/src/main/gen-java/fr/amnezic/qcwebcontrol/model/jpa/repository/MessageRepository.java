package fr.amnezic.qcwebcontrol.model.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.amnezic.qcwebcontrol.model.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message	,Long >  {

}
