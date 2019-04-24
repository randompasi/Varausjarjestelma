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


    private int participantLimit;


    @ElementCollection
    private Set<String> users = new HashSet<>();



    private String title;
    private String description;

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }


    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
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
        String casted =  "Event [id=" + id + ", title=" + title + ", description="
                + description + ", start=" + start + ", end=" + end + ", limit=" + participantLimit  + "]";
        for (String s : users) {
            casted += ",users : "+ s  + " ";
        }
        return casted;
    }
}