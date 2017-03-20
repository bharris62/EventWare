package com.bharris.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="vendors")
public class Vendor {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column
    String contact_name;

    @Column
    String type;

    @ManyToMany(targetEntity = Event.class)
    private Collection<Event> events;

    public Vendor(){}

    public Vendor(String name, String contact_name, String type) {
        this.name = name;
        this.contact_name = contact_name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Event> getEvent() {
        return events;
    }

    public void setEvent(Collection<Event> event) {
        this.events = event;
    }
}
