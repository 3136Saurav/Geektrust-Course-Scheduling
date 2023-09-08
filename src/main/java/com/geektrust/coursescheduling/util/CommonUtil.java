package com.geektrust.coursescheduling.util;

import com.geektrust.coursescheduling.entities.Course;

public class CommonUtil {

    public String getEmployeeNameFromEmail(String emailId) {
        int index = emailId.indexOf('@');
        String name = emailId.substring(0, index);
        return name;
    }

    public String getCourseNameFromRegistration(String registrationId) {
        String[] splits = registrationId.split("-");
        String courseName = splits[3];
        return courseName;
    }
    public String getEmployeeNameFromRegistration(String registrationId) {
        String[] splits = registrationId.split("-");
        String employeeName = splits[2];
        return employeeName;
    }

    public String createRegistrationId(Course course, String employeeNameFromEmail) {
        return "REG-COURSE-" + employeeNameFromEmail + "-" + course.getTitle();
    }

    public String createCourseId(String courseName, String instructorName) {
        return "OFFERING-" + courseName + "-" + instructorName;
    }

}
