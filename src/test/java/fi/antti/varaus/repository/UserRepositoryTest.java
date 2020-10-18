package fi.antti.varaus.repository;


import fi.antti.varaus.model.Event;
import fi.antti.varaus.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testSaveEvent(){
        User user = getUser();
        User savedInDb = entityManager.persist(user);
        User getFromDb = userRepository.findByUsername(user.getUsername());
        assertThat(getFromDb).isEqualTo(savedInDb);
    }


    private User getUser() {
        User user = new User();
        user.setUsername("Antti");
        user.setPassword("Angus McDougal");
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return user;
    }

}


