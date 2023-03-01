package com.iiht.supplierFinanceSystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.supplierFinanceSystem.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

	Optional<Client> findByName(String name);

}
