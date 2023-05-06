package com.UST.EmployeeExample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
    @Id
    @GeneratedValue

    private Long id;
    private String name;
}
