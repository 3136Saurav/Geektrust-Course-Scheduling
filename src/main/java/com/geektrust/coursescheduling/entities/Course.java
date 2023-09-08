package com.geektrust.coursescheduling.entities;

import com.geektrust.coursescheduling.enums.CourseStatus;

import java.time.LocalDate;
import java.util.List;

public class Course {
    private String id;
    private String title;
    private String instructorName;
    private String date;
    private int minEmployees;
    private int maxEmployees;
    private CourseStatus courseStatus;

    public Course() {
    }

    public Course(String title, String instructorName, String date, int minEmployees, int maxEmployees) {
        this.title = title;
        this.instructorName = instructorName;
        this.date = date;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public void setMinEmployees(int minEmployees) {
        this.minEmployees = minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

}
