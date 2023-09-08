package com.geektrust.coursescheduling.exceptions;

public class CourseAlreadyProcessedException extends RuntimeException {
    public CourseAlreadyProcessedException() {
        super("COURSE_ALLOTTED_OR_CANCELLED");
    }
}
