package com.ekrem.FalconBuilderDesign.controller;

import com.ekrem.FalconBuilderDesign.dto.AssignProjectDto;
import com.ekrem.FalconBuilderDesign.model.AssignProject;
import com.ekrem.FalconBuilderDesign.service.AssignProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("assigns")
public class AssignProjectController {
    @Autowired
    AssignProjectService assignProjectsService;

    @GetMapping("getAllAssigns")
    public ResponseEntity<List<AssignProjectDto>> getAllAssigns(){
        return assignProjectsService.getAllAssigns();
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addAssigns(@RequestBody AssignProject assignProject){
        return assignProjectsService.addAssigns(assignProject);
    }
    @DeleteMapping("delete/{assignmentid}")
    public ResponseEntity<String> deleteAssigns(@PathVariable Integer assignmentid){
        return assignProjectsService.deleteAssigns(assignmentid);
    }

    @PutMapping("update/{assignmentid}")
    public ResponseEntity<String>  updateAssigns(@RequestBody AssignProject assignProject, @PathVariable Integer assignmentid){
        return assignProjectsService.updateAssigns(assignProject,assignmentid);
    }

}
