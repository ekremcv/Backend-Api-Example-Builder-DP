package com.ekrem.FalconBuilderDesign.dao;

import com.ekrem.FalconBuilderDesign.dto.UserDto;
import com.ekrem.FalconBuilderDesign.dto.UserFilterDto;
import com.ekrem.FalconBuilderDesign.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer>,PagingAndSortingRepository<User, Integer> , JpaSpecificationExecutor<User> {

}
