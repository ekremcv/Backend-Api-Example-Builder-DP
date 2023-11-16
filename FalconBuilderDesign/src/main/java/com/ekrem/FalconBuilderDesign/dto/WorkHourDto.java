package com.ekrem.FalconBuilderDesign.dto;

import com.ekrem.FalconBuilderDesign.model.Project;
import com.ekrem.FalconBuilderDesign.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkHourDto {
    Integer workhours;
    Date workdate;
    User user;
    Project project;


    public static class Builder {
        Integer workhours;
        Date workdate;
        User user;
        Project project;

        public Builder workHours(Integer workhours){
            this.workhours=workhours;
            return this;
        }
        public Builder workDate(Date workdate){
            this.workdate=workdate;
            return this;
        }
        public Builder user(User user){
            this.user=user;
            return this;
        }
        public Builder project(Project project){
            this.project=project;
            return this;
        }
        public WorkHourDto build(){
            return new WorkHourDto(workhours,workdate,user,project);
        }



    }
}
