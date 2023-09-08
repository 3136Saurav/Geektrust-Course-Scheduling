package com.geektrust.coursescheduling.commands.impl;

import com.geektrust.coursescheduling.commands.Command;
import com.geektrust.coursescheduling.constants.CommonConstants;
import com.geektrust.coursescheduling.exceptions.CourseAlreadyPresentException;
import com.geektrust.coursescheduling.exceptions.InputDataErrorException;
import com.geektrust.coursescheduling.services.CourseService;

public class AddCourseCommand implements Command {

    CourseService courseService;

    public AddCourseCommand(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void execute(String[] tokens) {
        try {
            if (tokens.length != CommonConstants.SIX) {
                throw new InputDataErrorException();
            }

            String courseName = tokens[CommonConstants.ONE];
            String instructorName = tokens[CommonConstants.TWO];
            String date = tokens[CommonConstants.THREE];
            int minEmployees = Integer.parseInt(tokens[CommonConstants.FOUR]);
            int maxEmployees = Integer.parseInt(tokens[CommonConstants.FIVE]);
            courseService.addCourse(courseName, instructorName, date, minEmployees, maxEmployees);
        } catch (InputDataErrorException e) {
            System.out.println(e.getMessage());
        } catch (CourseAlreadyPresentException e) {
            System.out.println(e.getMessage());
        }
    }
}
