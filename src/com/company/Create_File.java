package com.company;

import java.io.File;
import java.io.IOException;

public class Create_File {

    private String stdin_Path = "src/com/company/stdin.txt";
    private String stdout_Path = "src/com/company/stdout.txt";

    public Create_File() {
        newFiles();
    }

    public String getStdin_Path() {
        return stdin_Path;
    }

    public String getStdout_Path() {
        return stdout_Path;
    }

    public void newFiles() {
        try {
            File myObj = new File(stdin_Path);
            File myObj2 = new File(stdout_Path);

            if (myObj.createNewFile() && myObj2.createNewFile()) {
                System.out.println("Files created: " + myObj.getName() + "," + myObj2.getName());
            } else {
                System.out.println("Files already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
