package com.europeandynamics.technikowebapp.model;

import com.europeandynamics.technikowebapp.model.enums.RepairType;
import com.europeandynamics.technikowebapp.model.enums.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PropertyRepair implements BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private RepairType repairType;

    @Column(nullable = false)
    private String shortDescription;

    @Column(nullable = false)
    private Date dateSubmitted;

    private String description;

    private Date proposedStartDate;

    private Date proposedEndDate;

    private Double proposedCost;

    private Boolean ownerAcceptance;

    @Column(nullable = false)
    private Status Status;

    private Date actualStartDate;

    private Date actualEndDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

}
