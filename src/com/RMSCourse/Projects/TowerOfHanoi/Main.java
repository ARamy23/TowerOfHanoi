package com.RMSCourse.Projects.TowerOfHanoi;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Main
{

    public static Stack<String> towerMain = new Stack<String>();
    public static Stack<String> towerMid = new Stack<String>();
    public static Stack<String> towerGoal = new Stack<String>();
    public static Stack<String> towerHasWon = new Stack<String>();
    public static int towerHeight;
    public static void greetings(String name)
    {
        if(name.equalsIgnoreCase("Mahmoud Soubih"))
            System.out.println("Welcome ya 7ag :D!");
        else
        System.out.println("Welcome, " + name+ " !");
    }
    
    public static void displayInstructions()
    {
        /*
        Display instructions here
         */
    }

    public static void makeTowers()
    {
        for(int i = towerHeight -1; i >= 0; i--)
        {
            towerMain.add(i+1 +"");
        }
        for(int i = towerHeight -1; i >= 0; i--)
        {
            towerHasWon.add(i+1 +"");
        }

//        for (int i = 0 ; i < towerHeight ; i ++)
//        {
//                towerMid.add("");
//        }
//
//        for (int i = 0 ; i < towerHeight ; i ++)
//        {
//                towerGoal.add("");
//        }
    }

    public static void displayStart()
    {
        for (int i = towerHeight -1; i >= 0; i--)
        {
            System.out.println(towerMain.get(i)+"\t\t"+"[Move tiles here]"+"\t\t"+"[Move tiles here]");
        }

    }
    public static void displayTowers()
    {
        for(int i = towerHeight-1; i >= 0; i--)
        {
            String display = "";
            if(!(towerMain.isEmpty()) && i < towerMain.size())
            {
                display += towerMain.get(i);
            }
            display += "\t\t";
            if(!(towerMid.isEmpty()) && i < towerMid.size())
            {
                display += towerMid.get(i);
            }
            display += "\t\t";
            if(!(towerGoal.isEmpty()) && i < towerGoal.size())
            {
                display += towerGoal.get(i);
            }
            System.out.println(display);
        }

    }
    public static void selectAndMoveTile(int selectTower, int moveTo)
    {

        inputLoop: do
        {
            switch(selectTower)
            {
                case 1:
                    switch(moveTo)
                    {
                        case 2:
                            if((towerMid.isEmpty()) || parseInt(towerMain.peek())< parseInt(towerMid.peek()))
                                towerMid.add(towerMain.pop());
                            break inputLoop;
                        case 3:
                            if((towerGoal.isEmpty()) || parseInt(towerMain.peek()) < parseInt(towerGoal.peek()))
                                towerGoal.add(towerMain.pop());
                            break inputLoop;
                        default:
                            System.out.println("Invalid Entry");
                            break;
                    }
                    break;
                case 2:
                    switch(moveTo)
                    {
                        case 1:
                            if((towerMain.isEmpty()) || parseInt(towerMid.peek())< parseInt(towerMain.peek()))
                                towerMain.add(towerMid.pop());
                            break inputLoop;
                        case 3:
                            if((towerGoal.isEmpty())||parseInt(towerMid.peek()) < parseInt(towerGoal.peek()))
                                towerGoal.add(towerMid.pop());
                            break inputLoop;
                        default:
                            System.out.println("Invalid Entry");
                            break;
                    }
                    break;
                case 3:
                    switch(moveTo)
                    {
                        case 1:
                            if((towerMain.isEmpty()) || parseInt(towerGoal.peek())< parseInt(towerMain.peek()))
                                towerMain.add(towerGoal.pop());
                            break inputLoop;
                        case 2:
                            if((towerMid.isEmpty()) || parseInt(towerGoal.peek()) < parseInt(towerMid.peek()))
                                towerMid.add(towerGoal.pop());
                            break inputLoop;
                        default:
                            System.out.println("Invalid Entry");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid Entry");
                    break;
            }
        }while(true);
    }

    public static boolean hasWon()
    {
        if(towerGoal.containsAll(towerHasWon))
        {
            System.out.println("YOU HAVE WON !");
            return true;
        }
        return false;
    }

    public static void clearTowers()
    {
        towerMain.clear();
        towerMid.clear();
        towerGoal.clear();
        towerHasWon.clear();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Your Name:- ");
        String name = in.nextLine();
        greetings(name);
        System.out.print("Enter Tower Height [difficulty]:");
        towerHeight = in.nextInt();
        makeTowers();
        displayStart();
        gameLoop : while(true)
        {
            System.out.println("1-Move a Tile\n2-Exit");
            int prompt = in.nextInt();
            switch(prompt)
            {
                case 1:
                    System.out.print("Enter the tower to be selected: ");
                    int selectTower = in.nextInt();
                    System.out.print("Enter the tower to which the tile is transferred: ");
                    int moveTo = in.nextInt();
                    selectAndMoveTile(selectTower,moveTo);
                    displayTowers();
                    break;
                case 2:
                    break gameLoop;
            }
            if(hasWon())
            {
                System.out.println("1-New game\n2-Exit");
                prompt = in.nextInt();
                switch(prompt)
                {
                    case 1:
                        clearTowers();
                        System.out.print("Enter Tower Height [difficulty]:");
                        towerHeight = in.nextInt();
                        makeTowers();
                        displayStart();
                        break;
                    case 2:
                        break gameLoop;
                }
            }

        }

        }
    }

