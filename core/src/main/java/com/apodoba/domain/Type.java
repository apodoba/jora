package com.apodoba.domain;

import javax.persistence.*;

/**
 * Created by apodoba on 3/31/14.
 */
@Entity
@Table(name = "Type")
public class Type {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
