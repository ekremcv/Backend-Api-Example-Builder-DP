package com.ekrem.FalconBuilderDesign.spec;


import com.ekrem.FalconBuilderDesign.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> generalFilter(User user){
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->{

            Predicate predicate = criteriaBuilder.conjunction();

            if(user.getFirstname() != null && !user.getFirstname().equals("") ){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userFirstname")),user.getFirstname() .toLowerCase()));
            }

            if(user.getLastname() != null && !user.getLastname().equals("")){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userLastname")),user.getLastname().toLowerCase()));
            }

            return predicate;
        };
    }
}
