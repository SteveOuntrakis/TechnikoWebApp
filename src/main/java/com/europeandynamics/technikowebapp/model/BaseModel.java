package com.europeandynamics.technikowebapp.model;

public interface BaseModel {

    Long getId();

    void setId(Long id);
    
    boolean isDeleted(); 

    void setDeleted(boolean deleted);
}
