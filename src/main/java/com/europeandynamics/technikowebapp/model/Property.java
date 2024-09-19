package com.europeandynamics.technikowebapp.model;

import com.europeandynamics.technikowebapp.model.enums.PropertyType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String address;

    private int yearOfConstruction;

    @Column(nullable = false)
    private PropertyType propertyType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PropertyOwner owner;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PropertyRepair> repairs;
}
