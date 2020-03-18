package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Read_stdin {


    private int[] commandListInt;
    private String data;

    public Read_stdin() {

    }

    public int[] getCommandListInt() {
        return commandListInt;
    }

    public void readFromFile(String inputFile) {
        try {
            File myObj = new File(inputFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println("the instructions from stdin is " + data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void convertInput() {
        String[] commandList = data.split(",");
        commandListInt = new int[commandList.length];
        for (int i = 0; i < commandList.length; i++) {
            commandListInt[i] = Integer.parseInt(commandList[i]);
        }
    }


    public void writeToStdout(String outputFile, String result) {
        try {
            FileWriter myWriter = new FileWriter(outputFile);

            myWriter.write(result);

            myWriter.close();
            System.out.println("Final simulation result Successfully wrote to the stdout file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
