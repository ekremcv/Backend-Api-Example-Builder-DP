package com.ekrem.FalconBuilderDesign.dao;

import com.ekrem.FalconBuilderDesign.model.WorkHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHourDao extends JpaRepository<WorkHour,Integer> {
}
