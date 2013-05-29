package fr.amnezic.qcwebcontrol.model.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.amnezic.qcwebcontrol.model.Aggregat;

@Repository
public interface AggregatRepository extends PagingAndSortingRepository<Aggregat	,Long >  {

	
	public Aggregat findByLabel(String label);
	
}
