package com.geektrust.coursescheduling.config;

import com.geektrust.coursescheduling.commands.*;
import com.geektrust.coursescheduling.commands.impl.*;
import com.geektrust.coursescheduling.repository.CourseRepository;
import com.geektrust.coursescheduling.repository.RegistrationRepository;
import com.geektrust.coursescheduling.services.CourseService;
import com.geektrust.coursescheduling.services.RegistrationService;

public class ApplicationConfig {
    private static final CourseRepository courseRepository = CourseRepository.getInstance();
    private static final RegistrationRepository registrationRepository = RegistrationRepository.getInstance();
    private static final CourseService courseService = new CourseService(courseRepository);
    private static final RegistrationService registrationService = new RegistrationService(courseRepository, registrationRepository);
    private static final Command addCourseCommand = new AddCourseCommand(courseService);
    private static final Command allotCommand = new AllotCommand(registrationService);
    private static final Command cancelCommand = new CancelCommand(registrationService);
    private static final Command registerCommand = new RegisterCommand(registrationService);
    private static final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.addCommand("ADD-COURSE-OFFERING", addCourseCommand);
        commandInvoker.addCommand("REGISTER", registerCommand);
        commandInvoker.addCommand("CANCEL", cancelCommand);
        commandInvoker.addCommand("ALLOT", allotCommand);
        return commandInvoker;
    }

}
