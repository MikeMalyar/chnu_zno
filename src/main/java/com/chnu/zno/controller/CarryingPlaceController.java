package com.chnu.zno.controller;

import com.chnu.zno.dto.CarryingPlaceDto;
import com.chnu.zno.model.CarryingPlace;
import com.chnu.zno.model.School;
import com.chnu.zno.model.Teacher;
import com.chnu.zno.repository.CarryingPlaceRepository;
import com.chnu.zno.repository.SchoolRepository;
import com.chnu.zno.repository.TeacherRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Carrying Places")
@RestController
@RequestMapping(value = "/carryingPlace")
@Transactional
public class CarryingPlaceController {

    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;
    private final CarryingPlaceRepository carryingPlaceRepository;

    @Autowired
    public CarryingPlaceController(TeacherRepository teacherRepository, SchoolRepository schoolRepository,
                                   CarryingPlaceRepository carryingPlaceRepository) {
        this.teacherRepository = teacherRepository;
        this.schoolRepository = schoolRepository;
        this.carryingPlaceRepository = carryingPlaceRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Carrying Place")
    @GetMapping("/")
    public GenericResponse getCarryingPlaces() {
        return GenericResponse.of(carryingPlaceRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Carrying Place by ID")
    @GetMapping("/{id}")
    public GenericResponse getCarryingPlaceById(@PathVariable Integer id) {
        return GenericResponse.of(carryingPlaceRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Carrying Place")
    @PostMapping("/")
    public GenericResponse addCarryingPlace(@RequestBody CarryingPlaceDto carryingPlaceDto) {
        School school = schoolRepository.findById(carryingPlaceDto.getSchoolId()).orElse(null);
        Teacher teacher = teacherRepository.findById(carryingPlaceDto.getTeacherId()).orElse(null);
        return GenericResponse.of(carryingPlaceRepository.save(
                new CarryingPlace().setCount(carryingPlaceDto.getCount())
                        .setNumber(carryingPlaceDto.getNumber())
                        .setSchool(school)
                        .setTeacher(teacher)
        ));
    }

    @ApiOperation(value = "Endpoint for deleting a Carrying Place by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteCarryingPlaceById(@PathVariable Integer id) {
        carryingPlaceRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
