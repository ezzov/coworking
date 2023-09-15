package com.example.coworking.entity;

import com.example.coworking.abstraction.AbstractModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coworking", schema = "public")
public class Coworking extends AbstractModel {

    private String name;
    private String address;
}
