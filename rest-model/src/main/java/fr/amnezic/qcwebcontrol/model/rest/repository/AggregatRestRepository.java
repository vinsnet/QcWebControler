package fr.amnezic.qcwebcontrol.model.rest.repository;

import org.springframework.data.rest.repository.annotation.RestResource;

import fr.amnezic.qcwebcontrol.model.jpa.repository.AggregatRepository;

@RestResource
public interface AggregatRestRepository extends AggregatRepository {

}
