package com.geektrust.coursescheduling;

import com.geektrust.coursescheduling.commands.impl.CommandInvoker;
import com.geektrust.coursescheduling.config.ApplicationConfig;
import com.geektrust.coursescheduling.constants.CommonConstants;
import com.geektrust.coursescheduling.exceptions.NoSuchCommandException;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        runApplication(args);
    }

    public static void runApplication(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();

        String inputFileName = args[CommonConstants.ZERO];
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFileName));
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] tokens = line.split(" ");
                commandInvoker.executeCommand(tokens[CommonConstants.ZERO], tokens);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchCommandException e) {
            System.out.println(e.getMessage());
        }
    }
}
