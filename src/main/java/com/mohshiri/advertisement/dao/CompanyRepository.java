package com.mohshiri.advertisement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohshiri.advertisement.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
