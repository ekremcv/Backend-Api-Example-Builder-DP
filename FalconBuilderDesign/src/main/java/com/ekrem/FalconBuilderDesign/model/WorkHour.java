package com.ekrem.FalconBuilderDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workhours")
public class WorkHour {
    @Id
    Integer workid;
    Integer workhours;
    Date workdate;


    @ManyToOne
    @JoinColumn(name = "userid")
    User user;


    @ManyToOne
    @JoinColumn(name = "projectid")
    Project project;
}
