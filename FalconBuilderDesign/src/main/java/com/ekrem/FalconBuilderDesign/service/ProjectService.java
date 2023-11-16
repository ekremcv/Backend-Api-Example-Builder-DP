package com.ekrem.FalconBuilderDesign.service;

import com.ekrem.FalconBuilderDesign.dao.ProjectDao;
import com.ekrem.FalconBuilderDesign.dto.ProjectDto;
import com.ekrem.FalconBuilderDesign.dto.mapper.Mapper;
import com.ekrem.FalconBuilderDesign.enums.StringEnums;
import com.ekrem.FalconBuilderDesign.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectService {
    @Autowired
    ProjectDao projectDao;



    public ResponseEntity<List<ProjectDto>> getAllProjects() {

        try {
            return new ResponseEntity<>(projectDao.findAll().stream().map(Mapper::convertEntityToDtoPr).collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addProject(Project project) {
        projectDao.save(project);
        return new ResponseEntity<>(StringEnums.CREATED.getValue(), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteProject(Integer projectid) {

        try {
            projectDao.deleteById(projectid);
            return new ResponseEntity<>(StringEnums.DELETED.getValue(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(StringEnums.ERROR.getValue(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> updateProject(Project project, Integer projectid) {
        projectDao.findById(projectid);
        projectDao.save(project);

        return new ResponseEntity<>(StringEnums.UPDATED.getValue(), HttpStatus.OK);

    }


}
