package com.geektrust.coursescheduling.services;

import com.geektrust.coursescheduling.entities.Course;
import com.geektrust.coursescheduling.enums.CourseStatus;
import com.geektrust.coursescheduling.exceptions.CourseAlreadyPresentException;
import com.geektrust.coursescheduling.repository.CourseRepository;
import com.geektrust.coursescheduling.util.CommonUtil;

import java.util.ArrayList;

public class CourseService {
    private static final CommonUtil commonUtil = new CommonUtil();

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(String courseName, String instructorName, String date, int minEmployees, int maxEmployees) {
        String id = commonUtil.createCourseId(courseName, instructorName);
        Course course = courseRepository.findCourseById(id);
        if (course != null) {
            throw new CourseAlreadyPresentException();
        }

        course = new Course();
        course.setId(id);
        course.setTitle(courseName);
        course.setDate(date);
        course.setInstructorName(instructorName);
        course.setMaxEmployees(maxEmployees);
        course.setMinEmployees(minEmployees);
        course.setCourseStatus(CourseStatus.COURSE_REGISTRATION_STARTED);
        courseRepository.saveCourse(course);

        System.out.println(id);
    }


}
