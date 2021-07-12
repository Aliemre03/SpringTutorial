package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class TodoItem {
    @Id
    private Long id;
    @NotBlank
    private String title;
    private boolean done;

}
