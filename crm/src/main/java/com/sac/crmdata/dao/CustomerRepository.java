package com.sac.crmdata.dao;

import com.sac.crmdata.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByEmail(String email);

    List<Customer> findByDate(Date date);

    Customer findById(Long id);
    
    @Query("Select c from Customer c where  c.id > :id")
    Stream<Customer> findByIdCriteriaReturnStream(@Param("id") Long id);
}
