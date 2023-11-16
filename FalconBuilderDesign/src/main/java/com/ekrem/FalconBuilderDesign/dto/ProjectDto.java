package com.ekrem.FalconBuilderDesign.dto;


import com.ekrem.FalconBuilderDesign.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDto {
    Integer projectid;
    String projectname;
    User user;

    public static class Builder {

        Integer projectid;
        String projectname;
        User user;


        public Builder projectid(Integer projectid) {
            this.projectid = projectid;
            return this;
        }

        public Builder projectName(String projectname) {
            this.projectname = projectname;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public ProjectDto build() {
            return new ProjectDto(projectid, projectname, user);
        }
    }
}


