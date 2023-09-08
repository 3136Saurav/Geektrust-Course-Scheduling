package com.geektrust.coursescheduling.commands.impl;

import com.geektrust.coursescheduling.commands.Command;
import com.geektrust.coursescheduling.constants.CommonConstants;
import com.geektrust.coursescheduling.exceptions.InputDataErrorException;
import com.geektrust.coursescheduling.services.RegistrationService;

public class CancelCommand implements Command {
    private RegistrationService registrationService;

    public CancelCommand(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void execute(String[] tokens) {
        try {
            if (tokens.length != CommonConstants.TWO) {
                throw new InputDataErrorException();
            }

            String registrationId = tokens[CommonConstants.ONE];
            registrationService.cancelRegistration(registrationId);
        } catch (InputDataErrorException e) {
            System.out.println(e.getMessage());
        }
    }
}
