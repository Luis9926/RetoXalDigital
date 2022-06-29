package com.xaldigital.retotecnico.repository;

import com.xaldigital.retotecnico.model.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VueloRepository extends CrudRepository<Vuelo,Long> {

}
