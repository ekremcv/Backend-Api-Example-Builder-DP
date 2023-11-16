package com.ekrem.FalconBuilderDesign.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "projects")
public class Project {


    @Id
    Integer projectid;
    String projectname;


    @ManyToOne
    @JoinColumn(name = "responsible_userid")
    User user;




}
