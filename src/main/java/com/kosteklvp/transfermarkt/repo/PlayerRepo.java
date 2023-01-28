package com.kosteklvp.transfermarkt.repo;

import com.kosteklvp.transfermarkt.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
}
