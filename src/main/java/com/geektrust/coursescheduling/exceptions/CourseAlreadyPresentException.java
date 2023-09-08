package com.geektrust.coursescheduling.exceptions;

public class CourseAlreadyPresentException extends RuntimeException {
    public CourseAlreadyPresentException() {
        super("COURSE_ALREADY_FOUND");
    }
}
