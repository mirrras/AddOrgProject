package com.kwork.orgibiz.repository;

import com.kwork.orgibiz.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
