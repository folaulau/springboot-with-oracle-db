package com.folautech.oracle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    // Here you are using the sequence generator. Hiberate will automatically create the sequence in the database
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGenSeq")
    @SequenceGenerator(name = "userGenSeq", sequenceName = "user_gen_seq", allocationSize = 1)
    private Long id;

    @Column(name = "uuid", unique = true, updatable = false)
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "comments", columnDefinition = "CLOB")
    private String comments;

    @PrePersist
    public void prePersist() {

        if (this.uuid == null) {
            this.uuid = "customer-" + java.util.UUID.randomUUID().toString().replaceAll("-", "");
        }
    }
}
