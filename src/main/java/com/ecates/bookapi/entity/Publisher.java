package com.ecates.bookapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Table(name = "publishers")
public class Publisher extends BaseEntity{

    private String name;
    private String country;

}
