package com.springBoot.application.repository;

import com.springBoot.application.entity.DepartmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        DepartmentEntity departmentEntity = DepartmentEntity.builder().departmentId(1L).departmentCode("ms055198").departmentContact("vancouver").departmentName("cerner").build();
        testEntityManager.persist(departmentEntity);
    }

    @Test
    @DisplayName("FindByDepartmentNameIgnoreCase")
    @Disabled
    public void TestFindByDepartmentNameIgnoreCase_withValidName()
    {
        DepartmentEntity response = departmentRepository.findById(1L).get();
        assertEquals(response.getDepartmentName(),"cerner");

    }


}