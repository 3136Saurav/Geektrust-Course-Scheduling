package com.geektrust.coursescheduling.config;

import com.geektrust.coursescheduling.commands.*;
import com.geektrust.coursescheduling.commands.impl.*;
import com.geektrust.coursescheduling.repository.CourseRepository;
import com.geektrust.coursescheduling.repository.RegistrationRepository;
import com.geektrust.coursescheduling.services.CourseService;
import com.geektrust.coursescheduling.services.RegistrationService;

public class ApplicationConfig {
    private final CourseRepository courseRepository = new CourseRepository();
    private final RegistrationRepository registrationRepository = new RegistrationRepository();

    private final CourseService courseService = new CourseService(courseRepository);
    private final RegistrationService registrationService = new RegistrationService(courseRepository, registrationRepository);
    private final Command addCourseCommand = new AddCourseCommand(courseService);
    private final Command allotCommand = new AllotCommand(registrationService);
    private final Command cancelCommand = new CancelCommand(registrationService);
    private final Command registerCommand = new RegisterCommand(registrationService);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.addCommand("ADD-COURSE-OFFERING", addCourseCommand);
        commandInvoker.addCommand("REGISTER", registerCommand);
        commandInvoker.addCommand("CANCEL", cancelCommand);
        commandInvoker.addCommand("ALLOT", allotCommand);
        return commandInvoker;
    }

}
