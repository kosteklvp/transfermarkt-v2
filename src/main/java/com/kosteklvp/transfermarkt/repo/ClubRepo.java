package com.kosteklvp.transfermarkt.repo;

import com.kosteklvp.transfermarkt.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club, Integer> {
}
