package com.iiht.supplierFinanceSystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.supplierFinanceSystem.model.Supplier;


@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long>{

	Optional<Supplier> findByName(String name); 

}
