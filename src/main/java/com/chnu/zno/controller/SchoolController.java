package com.chnu.zno.controller;

import com.chnu.zno.model.School;
import com.chnu.zno.repository.SchoolRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Schools")
@RestController
@RequestMapping(value = "/school")
@Transactional
public class SchoolController {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Schools")
    @GetMapping("/")
    public GenericResponse getSchools() {
        return GenericResponse.of(schoolRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting School by ID")
    @GetMapping("/{id}")
    public GenericResponse getSchoolById(@PathVariable Integer id) {
        return GenericResponse.of(schoolRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new School")
    @PostMapping("/")
    public GenericResponse addSchool(@RequestBody School school) {
        return GenericResponse.of(schoolRepository.save(school));
    }

    @ApiOperation(value = "Endpoint for deleting a School by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteSchoolById(@PathVariable Integer id) {
        schoolRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
