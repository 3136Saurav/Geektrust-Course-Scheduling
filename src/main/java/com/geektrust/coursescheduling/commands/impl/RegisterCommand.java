package com.geektrust.coursescheduling.commands.impl;

import com.geektrust.coursescheduling.commands.Command;
import com.geektrust.coursescheduling.constants.CommonConstants;
import com.geektrust.coursescheduling.exceptions.CourseAlreadyProcessedException;
import com.geektrust.coursescheduling.exceptions.CourseNotFoundException;
import com.geektrust.coursescheduling.exceptions.InputDataErrorException;
import com.geektrust.coursescheduling.services.RegistrationService;

public class RegisterCommand implements Command {
    private RegistrationService registrationService;

    public RegisterCommand(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void execute(String[] tokens) {

        try {
            if (tokens.length != CommonConstants.THREE) {
                throw new InputDataErrorException();
            }

            String emailId = tokens[CommonConstants.ONE];
            String courseId = tokens[CommonConstants.TWO];
            registrationService.registerCourse(emailId, courseId);
        } catch (InputDataErrorException e) {
            System.out.println(e.getMessage());
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (CourseAlreadyProcessedException e) {
            System.out.println(e.getMessage());
        }
    }
}
