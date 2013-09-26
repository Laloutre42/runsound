package org.zed.coding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    private int id;

    public User() {
        super();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

}
