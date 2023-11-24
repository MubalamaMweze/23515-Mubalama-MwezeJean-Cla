package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.model.Semester;
import com.StudentRegistration.StudentRegistration.model.StudentRegistration;
import com.StudentRegistration.StudentRegistration.services.StudentRegistrationService;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.StudentRegistrationServiceImplemenatation;
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
public class studentRegistrationController {


    private final StudentRegistrationServiceImplemenatation studentRegistrationServiceImplemenatation;


    @PostMapping("/saveStudentRegistration")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody StudentRegistration stdReg) throws InterruptedException{

        studentRegistrationServiceImplemenatation.createStudentRegistration(stdReg);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/deleteStdRegistration/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable int stdr) throws InterruptedException{
        StudentRegistration stdreg = new StudentRegistration();
        stdreg.setId(stdr);
        studentRegistrationServiceImplemenatation.deleteStudentRegistration(stdreg);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping ("/updateStudentRegistration/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException {
       StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.setId(id);
        studentRegistrationServiceImplemenatation.createStudentRegistration(studentRegistration);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


    @GetMapping("/stdRegistrationList")
    public ResponseEntity<HttpResponse> findStudentCourse() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("stdCoursedList",studentRegistrationServiceImplemenatation.registrationList()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/StdRegistration/{id}")
    public ResponseEntity<HttpResponse> findStudentReg(@PathVariable int id) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("course",studentRegistrationServiceImplemenatation.studRegistrationById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


}
