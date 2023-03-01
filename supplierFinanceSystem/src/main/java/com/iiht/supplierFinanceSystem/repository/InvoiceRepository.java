package com.iiht.supplierFinanceSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.supplierFinanceSystem.model.Client;
import com.iiht.supplierFinanceSystem.model.Invoice;
import com.iiht.supplierFinanceSystem.model.Supplier;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

	List<Invoice> findAllByClient(Client client);

	List<Invoice> findAllBySupplier(Supplier supplier);

}
