package fi.antti.varaus.repository;


/**
 * interface jonka avulla spring luo ohjelman aikana tietokannan Rooleille ja kysynnät mitä voi ohjelman aikana tehda
 */


import fi.antti.varaus.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
