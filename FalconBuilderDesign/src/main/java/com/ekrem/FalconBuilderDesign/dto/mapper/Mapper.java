package com.ekrem.FalconBuilderDesign.dto.mapper;

import com.ekrem.FalconBuilderDesign.dto.*;
import com.ekrem.FalconBuilderDesign.model.AssignProject;
import com.ekrem.FalconBuilderDesign.model.Project;
import com.ekrem.FalconBuilderDesign.model.User;
import com.ekrem.FalconBuilderDesign.model.WorkHour;


public class Mapper {


    public  static AssignProjectDto convertEntityToDtoAp(AssignProject assignProject) {
        AssignProjectDto.Builder assignProjectBuilder=new AssignProjectDto.Builder();

        AssignProjectDto assignProjectDto;
        return assignProjectDto=assignProjectBuilder.
                assignmentDate(assignProject.getAssignmentdate()).
                user(assignProject.getUser()).
                project(assignProject.getProject()).
                assignProjectList(assignProject.getUser().getAssignProjectList()).build();



    }


    public static WorkHourDto convertEntityToDtoWh(WorkHour workHour) {
        WorkHourDto.Builder workHourBuilder=new WorkHourDto.Builder();
        WorkHourDto workHourDto;

        return workHourDto=workHourBuilder.
                workHours(workHour.getWorkhours()).
                workDate(workHour.getWorkdate()).
                user(workHour.getUser()).
                project(workHour.getProject()).build();


    }
    public static ProjectDto convertEntityToDtoPr(Project project) {
        ProjectDto.Builder projectBuilder=new ProjectDto.Builder();

        ProjectDto projectDto;
        return projectDto=projectBuilder.projectid(project.getProjectid()).
                projectName(project.getProjectname()).
                user(project.getUser()).build();


    }
    public static UserDto convertEntityToDtoWithAp(User user){
        UserDto.Builder userBuilder =new UserDto.Builder();
        UserDto userDto;
        return userDto=userBuilder.
                firstName(user.getFirstname()).
                lastName(user.getLastname()).
                email(user.getEmail()).
                assignProjectsList(user.getAssignProjectList()).build();




    }
    public static UserFilterDto convertEntityToDtoUser(User user){
        UserFilterDto.Builder userFilterBuilder=new UserFilterDto.Builder();
        UserFilterDto userFilterDto;
        return userFilterDto=userFilterBuilder.
                firstName(user.getFirstname()).
                lastName(user.getLastname()).
                email(user.getEmail()).build();


    }
}


