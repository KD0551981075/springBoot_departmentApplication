package com.springBoot.application.controller;

import com.springBoot.application.entity.DepartmentEntity;
import com.springBoot.application.error.DepartmentNotFoundException;
import com.springBoot.application.service.IDepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    private DepartmentEntity departmentEntity;

    @MockBean
    private IDepartmentService MockDepartmentService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
        departmentEntity = DepartmentEntity.builder().departmentId(1L).departmentCode("ms055198").departmentContact("vancouver").departmentName("amazon").build();

    }

    @Test
    void saveDepartment() throws Exception {
        DepartmentEntity input = DepartmentEntity.builder().departmentCode("ms055198").departmentContact("vancouver").departmentName("amazon").build();
        Mockito.when(MockDepartmentService.saveDepartment(input)).thenReturn(departmentEntity);

        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"amazon\",\n" +
                        "\t\"departmentContact\":\"vancouver\",\n" +
                        "\t\"departmentCode\":\"ms055198\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(MockDepartmentService.getDepartmentById(1L)).thenReturn(departmentEntity);

        mockMvc.perform(get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(departmentEntity.getDepartmentName()));
    }
}