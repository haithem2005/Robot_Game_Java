package com.company;

import java.awt.*;

public class Robot {
    private String direction = "north";
    private Point position;
    private Grid grid;
    private Read_stdin readStdin;
    private Create_File createFile;

    private FollowProtocol followProtocol;

    public Robot() {
    }

    public void setReadStdin(Read_stdin readStdin) {
        this.readStdin = readStdin;
    }

    public void setCreateFile(Create_File createFile) {
        this.createFile = createFile;
    }

    public void setFollowProtocol(FollowProtocol followProtocol) {
        this.followProtocol = followProtocol;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setPosition(int x, int y) {
        position = new Point(x, y);
        System.out.println("start position of the robot has been  set to x = " + x + " and y = " + y);

    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public void left() {
        switch (direction) {
            case "north":
                setDirection("west");
                printPosition("robot turns its head left at position ");
                break;
            case "east":
                setDirection("north");
                printPosition("robot turns its head left at position ");
                break;
            case "west":
                setDirection("south");
                printPosition("robot turns its head left at position ");
                break;
            case "south":
                setDirection("east");
                printPosition("robot turns its head left at position ");
                break;

        }
    }

    public void right() {
        switch (direction) {
            case "north":
                setDirection("east");
                printPosition("robot turns its head right at position ");
                break;
            case "east":
                setDirection("south");
                printPosition("robot turns its head right at position ");
                break;
            case "west":
                setDirection("north");
                printPosition("robot turns its head right at position ");
                break;
            case "south":
                setDirection("west");
                printPosition("robot turns its head right at position ");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public void forward() {

           switch (direction) {

               case "north": {
                   if (grid.isValid(position.x, position.y - 1)) {
                       position.y -= 1;
                       printPosition("robot move foreword one cell new position is ");
                   } else {
                       terminateGame();

                   }
               }
               break;
               case "south":
                   if (grid.isValid(position.x, position.y + 1)) {
                       position.y += 1;
                       printPosition("robot move foreword one cell new position is ");
                   }
                   else {
                       terminateGame();
                   }
                   break;
               case "west":
                   if (grid.isValid(position.x - 1, position.y)) {
                       position.x -= 1;
                       printPosition("robot move foreword one cell new position is");
                   } else {
                       terminateGame();

                   }
                   break;
               case "east":
                   if (grid.isValid(position.x + 1, position.y)) {
                       position.x += 1;
                       printPosition("robot move foreword one cell new position is");
                   } else {
                       terminateGame();

                   }
                   break;
               default:
                   throw new IllegalStateException("Unexpected value: " + direction);

           }
    }

    public void terminateGame(){
        System.out.println("the robot fall form the table, please try again");
        readStdin.writeToStdout(createFile.getStdout_Path(), "[-1, -1]");
        followProtocol.setExit(true);

    }

    public  void PrintFinalPosition(){
        readStdin.writeToStdout(createFile.getStdout_Path(), getPosition().x + " " + getPosition().y);

    }


    public void backward() {
        switch (direction) {
            case "north":
                if (grid.isValid(position.x, position.y + 1)) {
                    position.y += 1;
                    printPosition("robot move backward one cell new position is");
                } else {
                    terminateGame();
                }
                break;
            case "south":
                if (grid.isValid(position.x, position.y - 1)) {
                    position.y -= 1;
                    printPosition("robot move backward one cell new position is ");
                } else {
                    terminateGame();
                }
                break;
            case "west":
                if (grid.isValid(position.x + 1, position.y)) {
                    position.x += 1;
                    printPosition("robot move backward one cell new position is");
                } else {
                    terminateGame();
                }
                break;
            case "east":
                if (grid.isValid(position.x - 1, position.y)) {
                    position.x -= 1;
                    printPosition("robot move backward one cell new position is");
                } else {
                    terminateGame();
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }


    }

    public void printPosition(String message) {
        System.out.println(message + "  x= " + getPosition().x + " y= " + getPosition().y);

    }
}
