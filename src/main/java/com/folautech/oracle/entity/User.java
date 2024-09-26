package com.folautech.oracle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Clob;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // Here you are using the sequence generator. Hiberate will automatically create the sequence in the database
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGenSeq")
    @SequenceGenerator(name = "userGenSeq", sequenceName = "user_gen_seq", allocationSize = 1)
    private Long id;

//    // here you manually added the sequnce generator using liquibase
//    // create sequence manual_seq start with 1 increment by 1;
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANUAL_SEQ")
//    private Long id;

    @Column(name = "uuid", unique = true, updatable = false)
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "personal_key", nullable = false)
    private Long personalKey;

    @Column(name = "height_in_ft")
    private Float heightInFt;

    @Column(name = "active")
    private boolean active;

    @Column(name = "comments", columnDefinition = "CLOB")
    private String comments;

    @PrePersist
    public void prePersist() {

        if (this.uuid == null) {
            this.uuid = "user-" + java.util.UUID.randomUUID().toString().replaceAll("-", "");
        }
    }
}
