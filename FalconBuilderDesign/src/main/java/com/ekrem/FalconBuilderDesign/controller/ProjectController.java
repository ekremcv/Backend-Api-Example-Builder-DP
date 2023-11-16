package com.ekrem.FalconBuilderDesign.controller;

import com.ekrem.FalconBuilderDesign.dto.ProjectDto;
import com.ekrem.FalconBuilderDesign.model.Project;
import com.ekrem.FalconBuilderDesign.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("getAllProjects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return projectService.getAllProjects();
    }


    @PostMapping("/add")
    public ResponseEntity<String>  addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }
    @DeleteMapping("delete/{projectid}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer projectid){
        return projectService.deleteProject(projectid);
    }
    @PutMapping("update/{projectid}")
    public ResponseEntity<String>  updateProject(@RequestBody Project project, @PathVariable Integer projectid){
        return projectService.updateProject(project,projectid);
    }
}
