package com.springBoot.application.service;

import com.springBoot.application.entity.DepartmentEntity;
import com.springBoot.application.error.DepartmentNotFoundException;

import java.util.List;

public interface IDepartmentService {

   public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    public List<DepartmentEntity> getDepartments();

    public DepartmentEntity getDepartmentById(Long departmentID) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentID);

    public DepartmentEntity updateDepartment(Long departmentID, DepartmentEntity departmentEntity);

    public DepartmentEntity findDepartmentByDepartmentName(String departmentName);
}
