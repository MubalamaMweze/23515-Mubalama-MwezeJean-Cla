package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.model.Semester;
import com.StudentRegistration.StudentRegistration.model.Student;
import com.StudentRegistration.StudentRegistration.model.Teacher;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.TeacherServiceImplimentation;
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
public class TeacherController {

    private final TeacherServiceImplimentation teacherServiceImplimentation;

    @PostMapping("/saveTeacher")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody Teacher teacher) throws InterruptedException{

        teacherServiceImplimentation.addTeacher(teacher);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/deleteTeacher/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable int tId) throws InterruptedException{
        Teacher tr = new Teacher();
        tr.setId(tId);
        teacherServiceImplimentation.deleteTeacher(tr);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
    @PutMapping ("/updateTeachers/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacherServiceImplimentation.addTeacher(teacher);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/teacherList")
    public ResponseEntity<HttpResponse> findTeacherList() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("stdCoursedList",teacherServiceImplimentation.teacherList()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/findTeacher/{name}")
    public ResponseEntity<HttpResponse> findTeacher(@PathVariable String name) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("teacher",teacherServiceImplimentation.findTeacherByName(name)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
}
