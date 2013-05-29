package fr.amnezic.qcwebcontrol.model.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.query.Param;


import fr.amnezic.qcwebcontrol.model.Aggregat;

@Repository
public interface AggregatRepository extends PagingAndSortingRepository<Aggregat	,Long >  {

	public List<Aggregat> findByLabel(@Param("label")String l); 

}
