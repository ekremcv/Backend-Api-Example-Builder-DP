package com.ekrem.FalconBuilderDesign.dao;

import com.ekrem.FalconBuilderDesign.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project,Integer> {
}
