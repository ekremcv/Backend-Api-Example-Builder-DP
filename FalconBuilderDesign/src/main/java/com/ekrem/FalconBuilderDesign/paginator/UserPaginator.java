package com.ekrem.FalconBuilderDesign.paginator;

import com.ekrem.FalconBuilderDesign.dto.UserFilterDto;
import com.ekrem.FalconBuilderDesign.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserPaginator {
    ResponseEntity<List<UserFilterDto>> getPaginationUser(int no, int size,UserFilterDto userFilterDto);
}
