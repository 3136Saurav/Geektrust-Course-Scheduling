package com.geektrust.coursescheduling.repository;

import com.geektrust.coursescheduling.entities.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseRepository {

    private Map<String, Course> courseMap = new HashMap<>();

    public CourseRepository() {
    }

    public void saveCourse(Course course) {
        courseMap.put(course.getId(), course);
    }

    public Course findCourseById(String id) {
        return courseMap.get(id);
    }

    public Course findCourseByCourseName(String courseName) {
        for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
            if (courseName.equals(entry.getValue().getTitle())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
