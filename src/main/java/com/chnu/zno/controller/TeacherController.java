package com.chnu.zno.controller;

import com.chnu.zno.dto.TeacherDto;
import com.chnu.zno.model.School;
import com.chnu.zno.model.Subject;
import com.chnu.zno.model.Teacher;
import com.chnu.zno.model.User;
import com.chnu.zno.repository.SchoolRepository;
import com.chnu.zno.repository.SubjectRepository;
import com.chnu.zno.repository.TeacherRepository;
import com.chnu.zno.repository.UserRepository;
import com.chnu.zno.rest.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Api(description = "Controller for operations with Teachers")
@RestController
@RequestMapping(value = "/teacher")
@Transactional
public class TeacherController {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(UserRepository userRepository, SchoolRepository schoolRepository,
                             SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @ApiOperation(value = "Endpoint for getting all Teachers")
    @GetMapping("/")
    public GenericResponse getTeachers() {
        return GenericResponse.of(teacherRepository.findAll());
    }

    @ApiOperation(value = "Endpoint for getting Teacher by ID")
    @GetMapping("/{id}")
    public GenericResponse getTeacherById(@PathVariable Integer id) {
        return GenericResponse.of(teacherRepository.findById(id));
    }

    @ApiOperation(value = "Endpoint for adding a new Teacher")
    @PostMapping("/")
    public GenericResponse addTeacher(@RequestBody TeacherDto teacherDto) {
        School school = schoolRepository.findById(teacherDto.getSchoolId()).orElse(null);
        Subject subject = subjectRepository.findById(teacherDto.getSubjectId()).orElse(null);
        User user = userRepository.findById(teacherDto.getUserId()).orElse(null);
        return GenericResponse.of(teacherRepository.save(new Teacher().setName(teacherDto.getName())
                .setSurname(teacherDto.getSurname())
                .setSubjectName(teacherDto.getSubjectName())
                .setUser(user)
                .setSchool(school)
                .setSubject(subject)));
    }

    @ApiOperation(value = "Endpoint for deleting a Teacher by ID")
    @DeleteMapping("/{id}")
    public GenericResponse deleteTeacherById(@PathVariable Integer id) {
        teacherRepository.deleteById(id);
        return GenericResponse.empty();
    }
}
