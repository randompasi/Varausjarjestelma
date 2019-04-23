package fi.antti.varaus.repository;

    import static org.assertj.core.api.Assertions.assertThat;
    import static org.mockito.Mockito.mock;

    import java.util.*;

    import fi.antti.varaus.model.Event;
    import fi.antti.varaus.model.User;
    import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;



    @RunWith(SpringRunner.class)
    @DataJpaTest
    public class EventRepositoryTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private EventRepository eventRepository;

        @Test
        public void testSaveEvent(){
            Event event = getEvent();
            Event savedInDb = entityManager.persist(event);
            Optional<Event> getFromDb = eventRepository.findById(event.getId());
            assertThat(getFromDb.get()).isEqualTo(savedInDb);
        }

        @Test
        public void testFindByDatesBetween(){
            Event event = getEvent();
            Event savedInDb = entityManager.persist(event);
            List<Event> getFromDb = eventRepository.findByDatesBetween(event.getStart(), event.getEnd());
            assertThat(getFromDb.get(0)).isEqualTo(savedInDb);
        }

        @Test
        public void testGetEnrolled(){
            Event event = getEvent();
            Event savedInDb = entityManager.persist(event);
            Optional<Event> getFromDb = eventRepository.findById(event.getId());
            assertThat(getFromDb.get().getUsers().size()).isEqualTo(savedInDb.getUsers().size());
        }

        private Event getEvent() {
            Event event = new Event();
            event.setDescription("Delhi");
            event.setTitle("Koe");
            event.setEnrollLimit(3L);
            event.setStart(new Date(1546293600000L));
            event.setEnd(new Date(1546380000000L));
            Set<User> users = new HashSet<>();
            users.add(getUser());
            users.add(getUser());
            event.setUsers(users);
            return event;
        }


        private User getUser(){
            User user = new User();
            user.setPassword("asd");
            user.setUsername("asd");
            user.setPasswordConfirm("asd");
            User savedUser = entityManager.persist(user);
            return savedUser;
        }
    }
