package com.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.entity.CustomerData;

public interface DataRepository extends JpaRepository<CustomerData,Long> {

}
