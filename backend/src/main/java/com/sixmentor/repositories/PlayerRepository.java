package com.sixmentor.repositories;

import org.springframework.data.jpa.repository.JpaRepository; // importation de JpaRepository pour utiliser ces method
import com.sixmentor.models.User; // importation de notre model User afin qu'il puisse etre utilisé
import com.sixmentor.models.Player; // importation de notre model User afin qu'il puisse etre utilisé

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    Optional<Player>findByUser(User user);

}