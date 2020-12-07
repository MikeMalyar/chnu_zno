package com.chnu.zno.controller;

import com.chnu.zno.dto.IntroductionDto;
import com.chnu.zno.model.Introduction;
import com.chnu.zno.model.School;
import com.chnu.zno.model.Specialty;
import com.chnu.zno.model.Subject;
import com.chnu.zno.repository.IntroductionRepository;
import com.chnu.zno.repository.SchoolRepository;
import com.chnu.zno.repository.SpecialtyRepository;
import com.chnu.zno.repository.SubjectRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Introductions")
@RestController
@RequestMapping(value = "/introduction")
@Transactional
public class IntroductionController {

    private final SpecialtyRepository specialtyRepository;
    private final SchoolRepository schoolRepository;
    private final SubjectRepository subjectRepository;
    private final IntroductionRepository introductionRepository;

    @Autowired
    public IntroductionController(SpecialtyRepository specialtyRepository, SchoolRepository schoolRepository,
                                  SubjectRepository subjectRepository, IntroductionRepository introductionRepository) {
        this.specialtyRepository = specialtyRepository;
        this.schoolRepository = schoolRepository;
        this.subjectRepository = subjectRepository;
        this.introductionRepository = introductionRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Introductions")
    @GetMapping("/")
    public GenericResponse getIntroductions() {
        return GenericResponse.of(specialtyRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Introduction by ID")
    @GetMapping("/{id}")
    public GenericResponse getIntroductionById(@PathVariable Integer id) {
        return GenericResponse.of(introductionRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Introduction")
    @PostMapping("/")
    public GenericResponse addIntroduction(@RequestBody IntroductionDto introductionDto) {
        School school = schoolRepository.findById(introductionDto.getSchoolId()).orElse(null);
        Specialty specialty = specialtyRepository.findById(introductionDto.getSpecialtyId()).orElse(null);
        Subject subject = subjectRepository.findById(introductionDto.getSubjectId()).orElse(null);
        return GenericResponse.of(introductionRepository.save(new Introduction().setSchool(school)
                .setSpecialty(specialty)
                .setSubject(subject)));
    }

    @ApiOperation(value = "Endpoint for deleting a Introduction by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteIntroductionById(@PathVariable Integer id) {
        introductionRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
