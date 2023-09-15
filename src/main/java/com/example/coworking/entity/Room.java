package com.example.coworking.entity;

import com.example.coworking.abstraction.AbstractModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room", schema = "public")
public class Room extends AbstractModel {

    private Integer capacity;
    private BigDecimal price;
    @ManyToOne
    private Coworking coworking;
}
