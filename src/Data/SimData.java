package Data;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class SimData {
    int currentYear;
    int initialYear;
    int changeInYears;
    int currentPop;
    int initialPop;
    int changeInPop;
    int numberOfBirths;
    int numberOfDeaths;
    int numberMale;
    int numberFemale;
    double percentMale;
    double percentFemale;

    File dataFile;
    FileWriter dataFileWriter;

    public SimData(int currentYear, int initialYear, int currentPop, int initialPop, int numberOfBirths, int numberOfDeaths, int numberMale, int numberFemale){
        this.currentYear = currentYear;
        this.initialYear = initialYear;
        this.currentPop = currentPop;
        this.initialPop = initialPop;
        this.numberOfBirths = numberOfBirths;
        this.numberOfDeaths = numberOfDeaths;
        this.numberMale = numberMale;
        this.numberFemale = numberFemale;
    }

    public int getChangeInPop(){
        changeInPop =  numberOfBirths - numberOfDeaths;
        return changeInPop;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public int getInitialYear() {
        return initialYear;
    }

    public int getChangeInYears() {
        changeInYears = currentYear - initialYear;
        return changeInYears;
    }

    public int getCurrentPop() {
        return currentPop;
    }

    public int getInitialPop() {
        return initialPop;
    }

    public double getPercentMale() {
        percentMale = ((double)(numberMale) / (double)(currentPop))*100;
        return percentMale;
    }

    public double getPercentFemale() {
        percentFemale = ((double)(numberFemale) / (double)(currentPop))*100;
        return percentFemale;
    }

    public int getNumberOfBirths() {
        return numberOfBirths;
    }

    public int getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public void createNewDataFile() {
        try {
            dataFile = new File("SimulationData.txt");
            if (dataFile.createNewFile()) {
                System.out.println("File created: " + dataFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void writeOnDataFile(File file) {
        try {
            dataFileWriter = new FileWriter(file.getName());
            dataFileWriter.write("Initial Population: " + initialPop);
            dataFileWriter.write("Current Population: " + currentPop);
            dataFileWriter.write("Male Percent Population: " + percentMale);
            dataFileWriter.write("Female Percent Population: " + percentFemale);
            dataFileWriter.write("Number of Births: " + numberOfBirths);
            dataFileWriter.write("Number of Deaths: " + numberOfDeaths);
            dataFileWriter.write("Change in Population: " + changeInPop);
            dataFileWriter.write("Current Population: " + currentPop);
            dataFileWriter.write("Initial Year: " + initialYear);
            dataFileWriter.write("Current Year: " + currentYear);
            dataFileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
