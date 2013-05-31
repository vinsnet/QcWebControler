package fr.amnezic.qcwebcontrol.model.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;


import fr.amnezic.qcwebcontrol.model.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message	,Long >  {


}
