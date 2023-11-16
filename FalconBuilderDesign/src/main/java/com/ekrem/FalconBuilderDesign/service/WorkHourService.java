package com.ekrem.FalconBuilderDesign.service;

import com.ekrem.FalconBuilderDesign.dao.WorkHourDao;
import com.ekrem.FalconBuilderDesign.dto.WorkHourDto;
import com.ekrem.FalconBuilderDesign.dto.mapper.Mapper;
import com.ekrem.FalconBuilderDesign.enums.StringEnums;
import com.ekrem.FalconBuilderDesign.model.WorkHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkHourService  {
    @Autowired
    WorkHourDao workHoursDao;

    public ResponseEntity<List<WorkHourDto>> getAllWorkHours() {

        try{
            return new ResponseEntity<>(workHoursDao.findAll().stream().map(Mapper::convertEntityToDtoWh).collect(Collectors.toList()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addWorkHour(WorkHour workHour) {

        workHoursDao.save(workHour);
        return new ResponseEntity<>(StringEnums.CREATED.getValue(),HttpStatus.CREATED);

    }

    public ResponseEntity<String> deleteWorkHour(Integer workid) {
        try {
            workHoursDao.deleteById(workid);
            return new ResponseEntity<>(StringEnums.DELETED.getValue(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(StringEnums.ERROR.getValue(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateWorkHour(WorkHour workHour, Integer workid) {
        workHoursDao.findById(workid);
        workHoursDao.save(workHour);
        return new ResponseEntity<>(StringEnums.UPDATED.getValue(),HttpStatus.OK);
    }



}
