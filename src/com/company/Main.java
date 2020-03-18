package com.company;

public class Main {

    public static void main(String[] args) {


        Robot robot=new Robot();

        Grid grid=new Grid();

        Create_File createFile=new Create_File();
        Read_stdin readStdin=new Read_stdin();
        robot.setReadStdin(readStdin);
        robot.setCreateFile(createFile);

        readStdin.readFromFile(createFile.getStdin_Path());
        readStdin.convertInput();
        FollowProtocol followProtocol=new FollowProtocol();
        followProtocol.setGrid(grid);
        robot.setFollowProtocol(followProtocol);

        robot.setGrid(grid);
        followProtocol.setReadStdin(readStdin);
        followProtocol.setRobot(robot);
        robot.setPosition(readStdin.getCommandListInt()[2],readStdin.getCommandListInt()[3]);
        grid.setGrid(readStdin.getCommandListInt()[0],readStdin.getCommandListInt()[1]);
        grid.printGridDimension();
        followProtocol.executeCommands();



    }
}
