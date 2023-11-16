package com.ekrem.FalconBuilderDesign.spec;

import com.ekrem.FalconBuilderDesign.dto.UserFilterDto;
import com.ekrem.FalconBuilderDesign.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<UserFilterDto> generalFilter(UserFilterDto userFilterDto){
        return (Root<UserFilterDto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->{

            Predicate predicate = criteriaBuilder.conjunction();

            if(userFilterDto.getFirstname() != null && !userFilterDto.getFirstname().equals("") ){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userFirstname")),userFilterDto.getFirstname() .toLowerCase()));
            }

            if(userFilterDto.getLastname() != null && !userFilterDto.getLastname().equals("")){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userLastname")),userFilterDto.getLastname().toLowerCase()));
            }

            return predicate;
        };
    }
}
