package com.geektrust.coursescheduling;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // Redirect System.out to the outputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        // Reset System.out to its original PrintStream
        System.setOut(originalOut);
    }
    @Test
    @DisplayName("Integration Test #0: SampleInput #0")
    public void sampleInput0Test() throws IOException {
        String args = "sample_input/input0.txt";
        String expectedOutput = "OFFERING-JAVA-JAMES\n" +
                "INPUT_DATA_ERROR\n" +
                "OFFERING-KUBERNETES-WOODY\n" +
                "REG-COURSE-ANDY-JAVA ACCEPTED\n" +
                "REG-COURSE-WOO-JAVA ACCEPTED\n" +
                "COURSE_FULL_ERROR\n" +
                "INPUT_DATA_ERROR\n" +
                "REG-COURSE-ANDY-JAVA ANDY@GMAIL.COM OFFERING-JAVA-JAMES JAVA JAMES 15062022 CONFIRMED\n" +
                "REG-COURSE-WOO-JAVA WOO@GMAIL.COM OFFERING-JAVA-JAMES JAVA JAMES 15062022 CONFIRMED\n" +
                "REG-COURSE-ANDY-JAVA CANCEL_REJECTED\n";

        Main.runApplication(new String[]{args});

        Assertions.assertEquals(expectedOutput.replaceAll("\n", "").replaceAll("\r", ""), outputStream.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
    }

    @Test
    @DisplayName("Integration Test #1: SampleInput #1")
    public void sampleInput1Test() throws IOException {
        String args = "sample_input/input1.txt";
        String expectedOutput = "OFFERING-DATASCIENCE-BOB\n" +
                "REG-COURSE-WOO-DATASCIENCE ACCEPTED\n" +
                "REG-COURSE-ANDY-DATASCIENCE ACCEPTED\n" +
                "REG-COURSE-ANDY-DATASCIENCE ANDY@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 CONFIRMED\n" +
                "REG-COURSE-WOO-DATASCIENCE WOO@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 CONFIRMED\n";

        Main.runApplication(new String[]{args});

        Assertions.assertEquals(expectedOutput.replaceAll("\n", "").replaceAll("\r", ""), outputStream.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
    }

    @Test
    @DisplayName("Integration Test #2: SampleInput #2")
    public void sampleInput2Test() throws IOException {
        String args = "sample_input/input2.txt";
        String expectedOutput = "OFFERING-PYTHON-JOHN\n" +
                "REG-COURSE-WOO-PYTHON ACCEPTED\n" +
                "REG-COURSE-ANDY-PYTHON ACCEPTED\n" +
                "REG-COURSE-BOBY-PYTHON ACCEPTED\n" +
                "REG-COURSE-BOBY-PYTHON CANCEL_ACCEPTED\n" +
                "REG-COURSE-ANDY-PYTHON ANDY@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED\n" +
                "REG-COURSE-WOO-PYTHON WOO@GMAIL.COM OFFERING-PYTHON-JOHN PYTHON JOHN 05062022 CONFIRMED";

        Main.runApplication(new String[]{args});

        Assertions.assertEquals(expectedOutput.replaceAll("\n", "").replaceAll("\r", ""), outputStream.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
    }

    @Test
    @DisplayName("Integration Test #3: SampleInput #3")
    public void sampleInput3Test() throws IOException {
        String args = "sample_input/input3.txt";
        String expectedOutput = "OFFERING-DATASCIENCE-BOB\n" +
                "REG-COURSE-ANDY-DATASCIENCE ACCEPTED\n" +
                "REG-COURSE-WOO-DATASCIENCE ACCEPTED\n" +
                "INPUT_DATA_ERROR\n" +
                "REG-COURSE-ANDY-DATASCIENCE ANDY@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 COURSE_CANCELED\n" +
                "REG-COURSE-WOO-DATASCIENCE WOO@GMAIL.COM OFFERING-DATASCIENCE-BOB DATASCIENCE BOB 05062022 COURSE_CANCELED";

        Main.runApplication(new String[]{args});

        Assertions.assertEquals(expectedOutput.replaceAll("\n", "").replaceAll("\r", ""), outputStream.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
    }

}