package com.ekrem.FalconBuilderDesign.paginator;

import com.ekrem.FalconBuilderDesign.dto.UserDto;
import com.ekrem.FalconBuilderDesign.dto.UserFilterDto;
import com.ekrem.FalconBuilderDesign.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;



public interface UserPaginator {
    ResponseEntity<Page<UserDto>> getPaginationUser(int no, int size, User user);
}
