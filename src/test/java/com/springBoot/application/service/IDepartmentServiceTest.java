package com.springBoot.application.service;

import com.springBoot.application.entity.DepartmentEntity;
import com.springBoot.application.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDepartmentServiceTest {

    @Autowired
    private IDepartmentService iDepartmentService;

    @MockBean
    private DepartmentRepository mockDepartmentRepository;


    @BeforeEach
    void setUp() {

        DepartmentEntity departmentEntity = DepartmentEntity.builder().departmentId(1L).departmentCode("ms055198").departmentContact("vancouver").departmentName("amazon").build();

        Mockito.when(mockDepartmentRepository.findByDepartmentNameIgnoreCase("amazon")).thenReturn(departmentEntity);

    }

    @Test
    @DisplayName("testSuccessful")
    public void TestFindDepartmentByDepartmentName_whenDepartmentNameMatches() {
       String DepartmentName = "amazon";
        DepartmentEntity response = iDepartmentService.findDepartmentByDepartmentName(DepartmentName);
        assertEquals(DepartmentName,response.getDepartmentName());
    }
}