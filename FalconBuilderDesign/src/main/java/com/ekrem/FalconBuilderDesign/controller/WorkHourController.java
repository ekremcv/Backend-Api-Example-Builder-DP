package com.ekrem.FalconBuilderDesign.controller;

import com.ekrem.FalconBuilderDesign.dto.WorkHourDto;
import com.ekrem.FalconBuilderDesign.model.WorkHour;
import com.ekrem.FalconBuilderDesign.service.WorkHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("workhour")
public class WorkHourController {
    @Autowired
    WorkHourService workHoursService;

    @GetMapping("getAllWorkHours")
    public ResponseEntity<List<WorkHourDto>> getAllWorkHours() {
        return workHoursService.getAllWorkHours();
    }

    @PostMapping("/add")
    public ResponseEntity<String>  addWorkHour(@RequestBody WorkHour workHour ){
        return workHoursService.addWorkHour(workHour);
    }
    @DeleteMapping("delete/{workid}")
    public ResponseEntity<String> deleteWorkHour(@PathVariable Integer workid){
        return workHoursService.deleteWorkHour(workid);
    }
    @PutMapping("update/{workid}")
    public ResponseEntity<String>  updateWorkHour(@RequestBody WorkHour workHour, @PathVariable Integer workid){
        return workHoursService.updateWorkHour(workHour,workid);
    }

}
