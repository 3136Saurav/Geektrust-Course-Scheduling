package com.geektrust.coursescheduling.entities;

public class Registration {
    private String registrationId;
    private String emailId;
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // REG-COURSE-WOO-DATASCIENCE WOO@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 CONFIRMED
    @Override
    public String toString() {
        return registrationId + " " + emailId + " " + course.getId() + " " + course.getTitle() + " " + course.getInstructorName() + " " + course.getDate() ;
    }
}
