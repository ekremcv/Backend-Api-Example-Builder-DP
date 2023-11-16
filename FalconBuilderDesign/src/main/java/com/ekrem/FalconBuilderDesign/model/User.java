package com.ekrem.FalconBuilderDesign.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userid")
    private
    Integer userid;
    @Column(name = "firstname")
    private
    String firstname;
    @Column(name = "lastname")
    private
    String lastname;
    @Column(name = "email")
    private
    String email;

    @OneToMany
    @JoinColumn(name="userid")
    @JsonBackReference
    List<AssignProject> assignProjectList;




}
