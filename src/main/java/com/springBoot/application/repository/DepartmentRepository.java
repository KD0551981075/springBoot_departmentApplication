package com.springBoot.application.repository;


import com.springBoot.application.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    DepartmentEntity findByDepartmentNameIgnoreCase(String departmentName);

}
