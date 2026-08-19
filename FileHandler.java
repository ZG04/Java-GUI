import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * the FileHandler class creates a file called survey_results.csv file and takes the info from the GUI and stores it in the file row by row
 */

public class FileHandler {

    private String surveyFile;
    private FileWriter fileOutput;
    private PrintWriter printWriter;
    
    /**
     * creates a FileHandler object and initializes the file with a header.
     */
    
    public FileHandler() {
        surveyFile = "survey_results.csv";
        try {
            fileOutput = new FileWriter(surveyFile);
            printWriter = new PrintWriter(fileOutput);
            printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error initializing survey file: " + e.getMessage());
        }
    }

    /**
     * adds a line of surveyData to the survey_results.csv file row by row
     * 
     * @param surveyData is a line of the data taken from the GUI separated by commas 
     */
    
    public void writeResults(String surveyData) {
        try {
            fileOutput = new FileWriter(surveyFile, true);
            printWriter = new PrintWriter(fileOutput);
            printWriter.println(surveyData);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing survey data: " + e.getMessage());
        }
    }
}