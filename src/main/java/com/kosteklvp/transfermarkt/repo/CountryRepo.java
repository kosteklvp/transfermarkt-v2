package com.kosteklvp.transfermarkt.repo;

import com.kosteklvp.transfermarkt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
}
