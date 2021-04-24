package com.hidarisoft.testActiveMQ.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Employee implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeFirstName;
    private String employeeFullName;
    private String employeeId;
    private String employeeLastName;
    private String employeeMiddleName;
}
