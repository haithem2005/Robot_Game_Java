package com.company;

public class FollowProtocol {

    private boolean exit = false;
    private Robot robot;
    private Read_stdin readStdin;
    private Grid grid;


    public void setExit(boolean exit) {
        this.exit = exit;
    }


    public void setRobot(Robot robot) {
        this.robot = robot;
    }


    public void setReadStdin(Read_stdin readStdin) {
        this.readStdin = readStdin;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void executeCommands() {

        while (!exit) {

            for (int k = 4; k < readStdin.getCommandListInt().length; k++) {

                switch (readStdin.getCommandListInt()[k]) {
                    case 1:
                        if (grid.isOnTable()) {
                            robot.forward();
                        } else {
                            setExit(true);
                        }
                        break;
                    case 2:
                        if (grid.isOnTable()) {
                            robot.backward();
                        } else {
                            setExit(true);
                        }
                        break;
                    case 3:
                        if (grid.isOnTable()) {
                            robot.right();
                        } else {
                            setExit(true);
                        }
                        break;
                    case 4:
                        if (grid.isOnTable()) {
                            robot.left();
                        } else {
                            setExit(true);
                        }
                        break;
                    case 0:

                        if (grid.isOnTable()) {
                            System.out.println("All commands have been processed successfully, thank you for playing");
                            robot.PrintFinalPosition();
                        }
                        setExit(true);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + k);
                }
            }
        }
    }
}
