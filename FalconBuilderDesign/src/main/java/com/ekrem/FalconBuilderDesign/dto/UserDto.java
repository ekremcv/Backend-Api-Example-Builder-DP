package com.ekrem.FalconBuilderDesign.dto;

import com.ekrem.FalconBuilderDesign.model.AssignProject;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    String firstname;
    String lastname;
    String email;

    List<AssignProject>assignmentProjectList;
    public static class Builder{
        String firstname;
        String lastname;
        String email;

        List<AssignProject>assignmentProjectList;


        public Builder firstName(String firstname){
            this.firstname=firstname;
            return this;
        }
        public Builder lastName(String lastname){
            this.lastname=lastname;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder assignProjectsList(List<AssignProject> assignmentProjectList){
            this.assignmentProjectList=assignmentProjectList;
            return this;
        }
        public UserDto build(){
            return new UserDto(firstname,lastname,email,assignmentProjectList);
        }
    }
}
