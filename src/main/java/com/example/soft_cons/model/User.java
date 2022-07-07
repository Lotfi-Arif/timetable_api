package com.example.soft_cons.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
// @NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    private long id;
    private String name;
    public User(){}

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    // @Column(name = "title", nullable = false)
    public String getName() {
        return name;
    }

}