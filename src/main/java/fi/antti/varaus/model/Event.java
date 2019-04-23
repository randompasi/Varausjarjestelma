package fi.antti.varaus.model;

/**
 * Taphtuma modelli kaikkille liikunta tunneille
 */

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="start")
    private Date start;

    @Column(name="end")
    private Date end;


    private Long enrollLimit;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "enrolled_users", joinColumns = @JoinColumn(name = "event_id"))
    private Set<User> users = new HashSet<>();



    private String title;
    private String description;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public Long getEnrollLimit() {
        return enrollLimit;
    }

    public void setEnrollLimit(Long enrollLimit) {
        this.enrollLimit = enrollLimit;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    public Event(Long id, String title, String description, Date start, Date end) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
    }
    public Event() {
        super();
    }
    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description="
                + description + ", start=" + start + ", end=" + end + "]";
    }
}