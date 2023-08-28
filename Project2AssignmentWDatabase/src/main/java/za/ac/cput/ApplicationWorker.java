package za.ac.cput;
import java.io.*;
import java.sql.*;


/**
 * EmailConfirmationApp.java
 * 222401680
 * @author Moegammad Nur Johnston
 * 2023/08/20
 */
public class ApplicationWorker {
    private EmailConfirmationDAO dao;

    public ApplicationWorker() {
        dao = new EmailConfirmationDAO();
    }

    public void processApplication(String course, String university, int applicationCount) {
        if (applicationCount < 3) {
            dao.insertApplication(course, university);
            generateTextFile(course, university, applicationCount);
        } else {
            System.exit(0);
        }
    }

    private void generateTextFile(String course, String university, int applicationCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("confirmation_" + applicationCount + ".txt"))) {
            writer.println("Your application has been saved. We will be applying for you"
                    + " within the next 24 hours.");
            writer.println("Course: " + course);
            writer.println("University: " + university);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}