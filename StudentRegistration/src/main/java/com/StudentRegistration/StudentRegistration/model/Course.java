package com.StudentRegistration.StudentRegistration.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="course_table")
public class Course {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "id")
    private CourseDefinition courseDefinition;
    @ManyToOne
    @JoinColumn(name = "unitId")
    private AcademicUnit department;

    public Course() {
    }

    public Course(int  id, Semester semester, Teacher teacher, CourseDefinition courseDefinition, AcademicUnit department) {
        this.id = id;
        this.semester = semester;
        this.teacher = teacher;
        this.courseDefinition = courseDefinition;
        this.department = department;
    }

    public int  getId() {
        return id  ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public CourseDefinition getCourseDefinition() {
        return courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public AcademicUnit getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit department) {
        this.department = department;
    }
}