package com.ekrem.FalconBuilderDesign.service;

import com.ekrem.FalconBuilderDesign.dao.UserDao;
import com.ekrem.FalconBuilderDesign.dto.UserDto;
import com.ekrem.FalconBuilderDesign.dto.UserFilterDto;
import com.ekrem.FalconBuilderDesign.dto.mapper.Mapper;
import com.ekrem.FalconBuilderDesign.enums.StringEnums;
import com.ekrem.FalconBuilderDesign.model.User;
import com.ekrem.FalconBuilderDesign.paginator.UserPaginator;
import com.ekrem.FalconBuilderDesign.spec.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserPaginator {

    @Autowired
    UserDao userDao;



    public ResponseEntity<List<UserFilterDto>> getAllUsers() {

        try{
            return new ResponseEntity<>(userDao.findAll().stream().map(Mapper::convertEntityToDtoUser).collect(Collectors.toList()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<List<UserDto>> getAllUsersWithAP() {

        try{
            return new ResponseEntity<>(userDao.findAll().stream().map(Mapper::convertEntityToDtoWithAp).collect(Collectors.toList()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> addUser(User user) {
        userDao.save(user);
        return new ResponseEntity<>(StringEnums.CREATED.getValue(), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteUser(Integer userid) {
        try {
            userDao.deleteById(userid);
            return new ResponseEntity<>(StringEnums.DELETED.getValue(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(StringEnums.ERROR.getValue(), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> updateUser(User user,Integer userid) {
        userDao.findById(userid);
        userDao.save(user);
        return new ResponseEntity<>(StringEnums.UPDATED.getValue(),HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Page<UserDto>> getPaginationUser(int no,int size,User user){
        Pageable pageable=PageRequest.of(no,size);
        Page<UserDto> userPage=  userDao.findAll(UserSpecification.generalFilter(user),pageable).map(Mapper::convertEntityToDtoWithAp);
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }
}
