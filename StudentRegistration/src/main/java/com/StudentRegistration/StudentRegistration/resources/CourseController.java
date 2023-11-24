package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.AcademicUnit;
import com.StudentRegistration.StudentRegistration.model.Course;
import com.StudentRegistration.StudentRegistration.model.CourseDefinition;
import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.CourseServiceImmplimentation;
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
public class CourseController {

    private final CourseServiceImmplimentation courseServiceImmplimentation;

    @PostMapping("/saveCourse")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody Course course) throws InterruptedException{

        courseServiceImmplimentation.saveCourses(course);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/deleteCourse/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable int c) throws InterruptedException{
        Course course = new Course();
        course.setId(c);
        courseServiceImmplimentation.deleteCourse(course);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
    @PutMapping ("/updateCourse/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException{
        Course course = new Course();
        course.setId(id);
        courseServiceImmplimentation.saveCourses(course);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/courseList")
    public ResponseEntity<HttpResponse> findcourseDefinition() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("coursedList",courseServiceImmplimentation.getALlCourses()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<HttpResponse> findACourse(@PathVariable int id) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("course",courseServiceImmplimentation.getCourseById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


}
