package com.ekrem.FalconBuilderDesign.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserFilterDto {

    String firstname;
    String lastname;
    String email;

    public static class Builder {
        String firstname;
        String lastname;
        String email;


        public Builder firstName(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserFilterDto build() {
            return new UserFilterDto(firstname, lastname, email);
        }
    }
}
