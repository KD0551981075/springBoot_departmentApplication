package com.springBoot.application.service;

import com.springBoot.application.entity.DepartmentEntity;
import com.springBoot.application.error.DepartmentNotFoundException;
import com.springBoot.application.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity getDepartmentById(Long departmentID) throws DepartmentNotFoundException {
        Optional<DepartmentEntity> response = departmentRepository.findById(departmentID);

        if(!response.isPresent())
            throw new DepartmentNotFoundException("-Exception occured due to no department Id-");

        return response.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public DepartmentEntity updateDepartment(Long departmentID, DepartmentEntity departmentEntity) {

        //1. get existing values from DB
        //2.check in incoming values on null and replace with existing values
        //3. send it to db
        //ggsud

        DepartmentEntity dataFromDB = departmentRepository.getById(departmentID);

        if (Objects.nonNull(departmentEntity.getDepartmentName()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentName())) {
            dataFromDB.setDepartmentName(departmentEntity.getDepartmentName());
        }
        if (Objects.nonNull(departmentEntity.getDepartmentCode()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentCode())) {
            dataFromDB.setDepartmentCode(departmentEntity.getDepartmentCode());
        }
        if (Objects.nonNull(departmentEntity.getDepartmentContact()) && !"".equalsIgnoreCase(departmentEntity.getDepartmentContact())) {
            dataFromDB.setDepartmentContact(departmentEntity.getDepartmentContact());
        }
        return departmentRepository.save(dataFromDB);
    }

    @Override
    public DepartmentEntity findDepartmentByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
