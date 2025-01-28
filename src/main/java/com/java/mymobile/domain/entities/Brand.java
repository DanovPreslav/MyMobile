package com.java.mymobile.domain.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;


    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }




}
