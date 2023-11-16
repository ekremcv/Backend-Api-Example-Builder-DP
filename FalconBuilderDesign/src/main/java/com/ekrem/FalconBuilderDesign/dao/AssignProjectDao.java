package com.ekrem.FalconBuilderDesign.dao;


import com.ekrem.FalconBuilderDesign.model.AssignProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignProjectDao extends JpaRepository<AssignProject,Integer> {
}
