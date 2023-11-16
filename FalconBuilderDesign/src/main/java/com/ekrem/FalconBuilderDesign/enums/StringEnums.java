package com.ekrem.FalconBuilderDesign.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StringEnums {


    DELETED("Deleted"),
    ERROR("Delete process is failed"),
    UPDATED("Table Updated"),
    CREATED("Successful");

    String value;




}
