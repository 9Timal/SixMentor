package com.sixmentor.controllers;

import com.sixmentor.dto.LoginRequestDTO;
import com.sixmentor.dto.PlayerResponseDTO;
import com.sixmentor.models.User;
import com.sixmentor.models.Player;
import com.sixmentor.repositories.PlayerRepository;
import com.sixmentor.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200") //accepte les requete uniquement de ce localhost et bloc tous les autres serveurs
@RestController
@RequestMapping("/users")

public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PlayerRepository playerRepository;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, PlayerRepository playerRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){

        // 1. Vérifie si l'utilisateur existe déjà par email
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            // 2. Si déjà présent, on retourne un code 409 (conflit)
            return ResponseEntity.status(409).body("Cet email est déjà utilisé.");
        }
        //chiffrement du mot de passe 
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 3. Sinon on enregistre le nouvel utilisateur
        userRepository.save(user);

        // 4. On renvoie une réponse 201 (created)
        return ResponseEntity.status(201).body(Map.of("message", "Utilisateur enregistré avec succès !"));
    
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest){ 

        // Verifie si l'adresse mail existe en bdd
        Optional<User> existingUser = userRepository.findByEmail(loginRequest.getEmail());

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                
                Optional<Player> player = playerRepository.findByUser(user);
                
                if (player.isPresent()) {
                    // tu vas bientôt construire ton PlayerResponseDTO ici
                        Player p = player.get();
                        PlayerResponseDTO response = new PlayerResponseDTO(
                            p.getId(),
                            user.getFirstname(),
                            user.getLastname(),
                            user.getEmail(),
                            p.getMain_role(),
                            p.getplayerRank(),
                            p.getTotal_matchs(),
                            p.getTotal_kills(),
                            p.getTotal_assists(),
                            p.getTotal_death(),
                            user.getStatus(),
                            user.getRole()
                        );
                    return ResponseEntity.ok(response);
                } else {
                    return ResponseEntity.ok(Map.of("message", "Connexion avec rôle simple utilisateur."));

                }
                
            }
           
        }
        return ResponseEntity.status(401).body("Identifiant incorrect.");
        
    }
}