package com.bharris.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String first_name;

    @Column(nullable = false)
    String last_name;

    @Column(nullable = false)
    String email;

    @OneToMany
    Collection<Event> event;

    public Client(String first_name, String last_name, String email, Event event) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        //this.event = event;
    }

    public Client(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Event getEvent() {
        return (Event) event;
    }

    public void setEvent(Event event) {
        this.event = (Collection<Event>) event;
    }
}
