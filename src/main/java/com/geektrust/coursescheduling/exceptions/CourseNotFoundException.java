package com.geektrust.coursescheduling.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("NO_COURSE_FOUND");
    }
}
