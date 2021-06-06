package com.springBoot.application.controller;

import com.springBoot.application.entity.DepartmentEntity;
import com.springBoot.application.error.DepartmentNotFoundException;
import com.springBoot.application.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    public IDepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    /*
    * javadoc
    * @valid : here we have added validation
    * @requestBody : and the request we are getting here from client to controller is in json format i.e, @requestBody*/

    @PostMapping("/department")
    public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity departmentEntity) {

        logger.info("+++=saveDepartment got hit here with the Id"+departmentEntity.getDepartmentId());

        return departmentService.saveDepartment(departmentEntity);
    }

    @PostMapping("/department/{id}")
    public DepartmentEntity updateDepartment(@PathVariable("id") Long departmentID, @RequestBody DepartmentEntity departmentEntity) {
        return departmentService.updateDepartment(departmentID, departmentEntity);
    }

    @GetMapping("/department")
    public List<DepartmentEntity> getDepartment() {
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentID);

    }

    //get element based on department name
    @GetMapping("/department/searchByName/{name}")
    public DepartmentEntity findDepartmentByDepartmentName(@PathVariable("name") String departmentName)
    {
        return departmentService.findDepartmentByDepartmentName(departmentName);

    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentID) {
        departmentService.deleteDepartmentById(departmentID);
        return "deleted record :" + departmentID + ": successfully";
    }


}
