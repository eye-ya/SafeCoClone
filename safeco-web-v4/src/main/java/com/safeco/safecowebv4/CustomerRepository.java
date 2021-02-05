package com.safeco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	
	  @Query("select s from Customer s where s.first LIKE %?1%" +
	  " OR s.last LIKE %?1%" + " OR s.state LIKE %?1%" +
	  " OR CONCAT(s.id, '') LIKE %?1%") 
	  public Page<Customer> findAll(String keyword, Pageable pageable);
	 
}
