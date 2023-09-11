package com.geektrust.coursescheduling.services;

import com.geektrust.coursescheduling.entities.Course;
import com.geektrust.coursescheduling.entities.Registration;
import com.geektrust.coursescheduling.enums.CourseStatus;
import com.geektrust.coursescheduling.exceptions.CourseAlreadyProcessedException;
import com.geektrust.coursescheduling.exceptions.CourseNotFoundException;
import com.geektrust.coursescheduling.repository.CourseRepository;
import com.geektrust.coursescheduling.repository.RegistrationRepository;
import com.geektrust.coursescheduling.util.CommonUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistrationService {
    private static final CommonUtil commonUtil = new CommonUtil();

    private CourseRepository courseRepository;
    private RegistrationRepository registrationRepository;

    public RegistrationService(CourseRepository courseRepository, RegistrationRepository registrationRepository) {
        this.courseRepository = courseRepository;
        this.registrationRepository = registrationRepository;
    }

    public void registerCourse(String emailId, String courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new CourseNotFoundException();
        }

        if (CourseStatus.COURSE_ALLOTTED.equals(course.getCourseStatus()) || CourseStatus.COURSE_CANCELLED.equals(course.getCourseStatus())) {
            throw new CourseAlreadyProcessedException();
        }

        List<Registration> registrationList = registrationRepository.findRegistrationsByCourseId(courseId);
        if (registrationList != null && registrationList.size() >= course.getMaxEmployees()) {
            System.out.println("COURSE_FULL_ERROR");
            return;
        }

        String employeeNameFromEmail = commonUtil.getEmployeeNameFromEmail(emailId);
        Registration registration = new Registration();
        registration.setRegistrationId(commonUtil.createRegistrationId(course, employeeNameFromEmail));
        registration.setEmailId(emailId);
        registration.setCourse(course);
        registrationRepository.saveRegistration(courseId, registration);

        System.out.println(registration.getRegistrationId() + " ACCEPTED");
    }

    public void cancelRegistration(String registrationId) {
        String courseNameFromRegistration = commonUtil.getCourseNameFromRegistration(registrationId);
        Course course = courseRepository.findCourseByCourseName(courseNameFromRegistration);

        if (course == null) {
            System.out.println(registrationId + " CANCEL_REJECTED");
            return;
        }

        if (CourseStatus.COURSE_ALLOTTED.equals(course.getCourseStatus()) || CourseStatus.COURSE_CANCELLED.equals(course.getCourseStatus())) {
            System.out.println(registrationId + " CANCEL_REJECTED");
            return;
        }

        // REG-COURSE-WOO-DATASCIENCE
        List<Registration> registrationList = registrationRepository.findRegistrationsByCourseId(course.getId());

        if (registrationList == null) {
            System.out.println(registrationId + " CANCEL_REJECTED");
            return;
        }

        boolean registrationFound = false;
        List<Registration> updatedRegistrationList = new ArrayList<>();
        for (Registration registration : registrationList) {
            if (!registrationId.equals(registration.getRegistrationId())) {
                updatedRegistrationList.add(registration);
            } else {
                registrationFound = true;
            }
        }

        if (!registrationFound) {
            System.out.println(registrationId + " CANCEL_REJECTED");
            return;
        }

        registrationRepository.updateRegistrations(course.getId(), updatedRegistrationList);
        System.out.println(registrationId + " CANCEL_ACCEPTED");
    }

    public void allotCourse(String courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new CourseNotFoundException();
        }

//        if (CourseStatus.COURSE_ALLOTTED.equals(course.getCourseStatus()) || CourseStatus.COURSE_CANCELLED.equals(course.getCourseStatus())) {
//            return;
//            throw new CourseAlreadyProcessedException();
//        }

        List<Registration> registrationList = registrationRepository.findRegistrationsByCourseId(courseId);

        if (registrationList.size() < course.getMinEmployees() || registrationList.size() > course.getMaxEmployees()) {
            course.setCourseStatus(CourseStatus.COURSE_CANCELLED);
            for (Registration registration : registrationList) {
                System.out.println(registration + " COURSE_CANCELED");
            }
            return;
        }

        course.setCourseStatus(CourseStatus.COURSE_ALLOTTED);

        Collections.sort(registrationList, (a, b) -> a.getRegistrationId().compareTo(b.getRegistrationId()));

        for (Registration registration : registrationList) {
            System.out.println(registration + " CONFIRMED");
        }
    }
}
