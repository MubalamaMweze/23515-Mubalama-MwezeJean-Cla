package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.model.Semester;
import com.StudentRegistration.StudentRegistration.model.Student;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.StudentCourseServiceImplimentation;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.StudentServiceImplimentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {


    private final StudentServiceImplimentation studentServiceImplimentation;



    @PostMapping("/saveStudent")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody Student std) throws InterruptedException{

        studentServiceImplimentation.saveStudent(std);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/deleteStd/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable Integer stdId) throws InterruptedException{
        Student std = new Student();
        std.setId(stdId);
        studentServiceImplimentation.deleteStudent(std);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


    @PutMapping ("/updateStudent/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException {
        Student student = new Student();
        student.setId(id);
        studentServiceImplimentation.saveStudent(student);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
    @GetMapping("/stdList")
    public ResponseEntity<HttpResponse> findStudentCourse() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("stdCoursedList",studentServiceImplimentation.studentList()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/Std/{id}")
    public ResponseEntity<HttpResponse> findStudent(@PathVariable int id) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("course",studentServiceImplimentation.findStudentById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

}
