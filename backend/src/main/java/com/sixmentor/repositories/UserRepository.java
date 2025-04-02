package com.sixmentor.repositories; // décrire où l'on se trouve 

import org.springframework.data.jpa.repository.JpaRepository; // importation de JpaRepository pour utiliser ces method
import com.sixmentor.models.User; // importation de notre model User afin qu'il puisse etre utilisé

import java.util.Optional;

// création de l'interfae UserRepository qui vas utiliser les methods de JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{
    // User => entité qu’on va manipuler
    // Long  => type de la clé primaire (@Id dans le modèle User)
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

} 
