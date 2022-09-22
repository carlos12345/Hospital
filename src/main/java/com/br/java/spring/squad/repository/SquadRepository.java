package com.br.java.spring.squad.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.java.spring.squad.model.Squad;

public interface SquadRepository extends CrudRepository<Squad, String>{

	Squad findByCodigo(long codigo);
}
