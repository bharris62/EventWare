package com.bharris.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="events")
public class Event implements Serializable{
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String venue;

    @Column(nullable = false)
    String venue_contact;

    @ManyToMany(mappedBy = "events", targetEntity=Vendor.class)
    private Collection<Vendor> vendors;

    public Event(String venue, String venue_contact, Collection<Vendor> vendor) {
        this.venue = venue;
        this.venue_contact = venue_contact;
        this.vendors = vendor;
    }

    public Event(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getVenue_contact() {
        return venue_contact;
    }

    public void setVenue_contact(String venue_contact) {
        this.venue_contact = venue_contact;
    }

    public Vendor getVendor() {
        return (Vendor) this.vendors;
    }

    public void setVendor(Vendor vendor) {
        this.vendors = (Collection<Vendor>) vendor;
    }

    public void setVendor(Collection<Vendor> vendor) {
        this.vendors = vendor;
    }
}
