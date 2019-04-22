package fi.antti.varaus.repository;


/**
 * interface jonka avulla spring luo ohjelman aikana tietokannan ja kyselyt Käyttäjä repositoriin
 */


import fi.antti.varaus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
