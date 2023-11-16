package com.ekrem.FalconBuilderDesign.service;

import com.ekrem.FalconBuilderDesign.dao.AssignProjectDao;
import com.ekrem.FalconBuilderDesign.dto.AssignProjectDto;
import com.ekrem.FalconBuilderDesign.dto.mapper.Mapper;
import com.ekrem.FalconBuilderDesign.enums.StringEnums;
import com.ekrem.FalconBuilderDesign.model.AssignProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignProjectService {
    @Autowired
    AssignProjectDao assignProjectsDao;


    public ResponseEntity<List<AssignProjectDto>> getAllAssigns() {

        try {
            return new ResponseEntity<>(assignProjectsDao.findAll().stream().map(Mapper::convertEntityToDtoAp).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addAssigns(AssignProject assignProject) {

        assignProjectsDao.save(assignProject);

        return new ResponseEntity<>(StringEnums.CREATED.getValue(), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteAssigns(Integer assignmentid) {

        try {
            assignProjectsDao.deleteById(assignmentid);
            return new ResponseEntity<>(StringEnums.DELETED.getValue(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(StringEnums.ERROR.getValue(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateAssigns(AssignProject assignProject, Integer assignmentid) {
        assignProjectsDao.findById(assignmentid);
        assignProjectsDao.save(assignProject);
        return new ResponseEntity<>(StringEnums.UPDATED.getValue(), HttpStatus.OK);
    }




}
