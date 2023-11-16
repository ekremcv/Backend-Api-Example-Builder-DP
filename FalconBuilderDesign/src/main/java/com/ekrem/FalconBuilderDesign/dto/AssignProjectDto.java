package com.ekrem.FalconBuilderDesign.dto;

import com.ekrem.FalconBuilderDesign.model.AssignProject;
import com.ekrem.FalconBuilderDesign.model.Project;
import com.ekrem.FalconBuilderDesign.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.function.Function;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignProjectDto  {

    Date assignmentdate;
    User user;
    Project project;
    List<AssignProject> assignProjectList;

    public static class Builder{

        Date assignmentdate;
        User user;
        Project project;
        List<AssignProject> assignProjectList;


        public Builder assignmentDate(Date assignmentdate) {
            this.assignmentdate=assignmentdate;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder project(Project project) {
            this.project = project;
            return this;
        }
        public Builder assignProjectList(List<AssignProject>assignProjectList){
            this.assignProjectList=assignProjectList;
            return this;
        }

        public AssignProjectDto build() {
            return new AssignProjectDto(assignmentdate,user,project,assignProjectList);
        }

    }
}
