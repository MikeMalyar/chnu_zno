package com.chnu.zno.controller;

import com.chnu.zno.dto.SpecialtyDto;
import com.chnu.zno.model.School;
import com.chnu.zno.model.Specialty;
import com.chnu.zno.repository.SchoolRepository;
import com.chnu.zno.repository.SpecialtyRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Specialties")
@RestController
@RequestMapping(value = "/specialty")
@Transactional
public class SpecialtyController {

    private final SpecialtyRepository specialtyRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public SpecialtyController(SpecialtyRepository specialtyRepository, SchoolRepository schoolRepository) {
        this.specialtyRepository = specialtyRepository;
        this.schoolRepository = schoolRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Specialties")
    @GetMapping("/")
    public GenericResponse getSpecialties() {
        return GenericResponse.of(specialtyRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Specialty by ID")
    @GetMapping("/{id}")
    public GenericResponse getSpecialtyById(@PathVariable Integer id) {
        return GenericResponse.of(specialtyRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Specialty")
    @PostMapping("/")
    public GenericResponse addSpecialty(@RequestBody SpecialtyDto specialtyDto) {
        School school = schoolRepository.findById(specialtyDto.getSchoolId()).orElse(null);
        return GenericResponse.of(specialtyRepository.save(
                new Specialty().setName(specialtyDto.getName())
                    .setSpecialtyId(specialtyDto.getSpecialtyId())
                    .setMin_gpa(specialtyDto.getMin_gpa())
                    .setSchool(school)
        ));
    }

    @ApiOperation(value = "Endpoint for deleting a Specialty by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteSpecialtyById(@PathVariable Integer id) {
        specialtyRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
