package com.bharris.entities;

import com.bharris.utilities.PasswordStorage;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String first_name;


    @Column(nullable = false)
    String email;

    @OneToMany
    Collection<Client> client;

    public User(String username, String password, String first_name, String email) throws PasswordStorage.CannotPerformOperationException {
        this.username = username;
        setPassword(password);
        this.first_name = first_name;
        this.email = email;
        //this.client = client;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordStorage.CannotPerformOperationException {
        this.password = PasswordStorage.createHash(password);
    }

    public boolean verifyPassword(String password) throws PasswordStorage.InvalidHashException, PasswordStorage.CannotPerformOperationException {

        return PasswordStorage.verifyPassword(password, getPasswordHash());
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client getClient() {
        return (Client) client;
    }

    public void setClient(Client client) {
        this.client = (Collection<Client>) client;
    }

    public String getPasswordHash() {
        return password;
    }
}
