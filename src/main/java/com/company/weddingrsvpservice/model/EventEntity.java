package com.company.weddingrsvpservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EventEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name ="description",  nullable = false)
    private String description;

    @Column(name = "total_attending")
    private Integer totalAttending;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(Integer totalAttending) {
        this.totalAttending = totalAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(totalAttending, that.totalAttending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, totalAttending);
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", totalAttending=" + totalAttending +
                '}';
    }
}

//Annotation MappedSuperClass to allow an entity to inherit properties from a base class.


