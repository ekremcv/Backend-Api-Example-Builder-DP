package com.ekrem.FalconBuilderDesign.controller;

import com.ekrem.FalconBuilderDesign.dto.UserDto;
import com.ekrem.FalconBuilderDesign.dto.UserFilterDto;
import com.ekrem.FalconBuilderDesign.model.User;
import com.ekrem.FalconBuilderDesign.paginator.UserPaginator;
import com.ekrem.FalconBuilderDesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserPaginator userPaginator;


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserFilterDto>> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getAllUsersWithAP")
    public ResponseEntity<List<UserDto>> getAllUsersWithAp(){
        return userService.getAllUsersWithAP();
    }

    @GetMapping("/{no}/{size}")
    public ResponseEntity<List<UserFilterDto>> getPaginationUser(@PathVariable int no,
                                      @PathVariable int size,@RequestBody UserFilterDto userFilterDto) {
        return userPaginator.getPaginationUser(no, size,userFilterDto);
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("delete/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userid){
        return userService.deleteUser(userid);
    }

    @PutMapping("update/{userid}")
    public ResponseEntity<String>  updateUser(@RequestBody User user,@PathVariable Integer userid){
        return userService.updateUser(user,userid);
    }




}
