package com.chnu.zno.controller;

import com.chnu.zno.model.Subject;
import com.chnu.zno.repository.SubjectRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Subjects")
@RestController
@RequestMapping(value = "/subject")
@Transactional
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Subjects")
    @GetMapping("/")
    public GenericResponse getSubjects() {
        return GenericResponse.of(subjectRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Subject by ID")
    @GetMapping("/{id}")
    public GenericResponse getSubjectById(@PathVariable Integer id) {
        return GenericResponse.of(subjectRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Subject")
    @PostMapping("/")
    public GenericResponse addSubject(@RequestBody Subject subject) {
        return GenericResponse.of(subjectRepository.save(subject));
    }

    @ApiOperation(value = "Endpoint for deleting a Subject by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteSubjectById(@PathVariable Integer id) {
        subjectRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
