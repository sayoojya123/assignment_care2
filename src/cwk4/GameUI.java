package cwk4;

import java.io.*;
import java.util.*;

/**
 * Command line interface
 *
 * @author A.A.Marczyk
 * @version 10/03/2024
 */
public class GameUI {

    private Scanner myIn = new Scanner(System.in);

    public void runGame() {
        Tournament tr;
        int choice;
        String vizierName;
        String output = "";
        int result = -1;
        try {
            System.out.println("Enter vizier's name");
            String s = myIn.nextLine();
            //myIn.nextLine();
            tr = new Tournament(s); // create
            //tr = new Tournament(s,"challengesAM.txt"); // alternative create task 3.5
            choice = 100;
            while (choice != 0) {
                choice = getMenuItem();
                if (choice == 1) {
                    System.out.println(tr.getReserve());
                } else if (choice == 2) {
                    System.out.println(tr.getTeam());
                } else if (choice == 3) {
                    System.out.println("Enter Champion name");
                    String ref = (myIn.nextLine()).trim();
                    System.out.println(tr.getChampionDetails(ref));
                } else if (choice == 4) {
                    System.out.println("Enter Champion name");
                    String ref = (myIn.nextLine()).trim();
                    result = tr.enterChampion(ref);

                    if (result == 0) {

                        System.out.println("Champion entered successfully.");

                    } else if (result == 1) {

                        System.out.println("Champion not in reserve.");

                    } else if (result == 2) {

                        System.out.println("Not enough money in the treasury.");

                    } else if (result == -1) {

                        System.out.println("No such champion.");
                    }

                } else if (choice == 5) {
                    System.out.println("Enter Challenge number");
                    String ref = (myIn.nextLine()).trim();
                    Integer chalNo = Integer.parseInt(ref.toString());
                    int challengResult = tr.meetChallenge(chalNo);
                    handleChallengeResult(challengResult);
                } else if (choice == 6) {
                    System.out.println("Enter Champion name");
                    String ref = (myIn.nextLine()).trim();
                    int retireResult = tr.retireChampion(ref);
                    handleRetireChampionOutput(retireResult, ref);
                } else if (choice == 7) {
                    // provide code here
                    System.out.println(tr);
                } else if (choice == 8) {
                    System.out.println(tr.getAllChallenges());
                } else if (choice == 9) // Task 3.5 only
                {
                    System.out.println("Write to file");
                    System.out.println("Enter file name");
                    String filename = myIn.nextLine();
                    tr.saveGame(filename);
                } else if (choice == 10) // Task 3.5 only
                {
                    System.out.println("Restore from file");
                    System.out.println("Enter file name");
                    String filename = myIn.nextLine();
                    CARE tr2 = tr.loadGame(filename);
                    if (tr2 != null) {
                        System.out.println(tr2.toString());
                    } else {
                        System.out.println("No such file");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Thank-you");
    }

    public void handleChallengeResult(int result) {
        switch (result) {
            case 0:
                System.out.println("Challenge won by champion. Reward added to the treasury.");
                break;
            case 1:
                System.out.println("Challenge lost on skills. Reward deducted from the treasury and champion disqualified.");
                break;
            case 2:
                System.out.println("Challenge lost as no suitable champion is available. Reward deducted from the treasury.");
                break;
            case 3:
                System.out.println("Challenge lost and vizier completely defeated (no money and no champions to withdraw).");
                break;
            case -1:
                System.out.println("No such challenge.");
                break;
            default:
                System.out.println("Invalid result.");
                break;
        }
    }


    /**
     * Handles the output of the retireChampion method by printing necessary output to the console
     *
     * @param result the integer result returned by the retireChampion method
     * @param name   the name of the champion
     */
    public void handleRetireChampionOutput(int result, String name) {
        switch (result) {
            case 0:
                System.out.println(name + " has been retired from the vizier's team and moved back to reserves successfully.");
                break;
            case 1:
                System.out.println(name + " cannot be retired because they are disqualified.");
                break;
            case 2:
                System.out.println(name + " is not in the vizier's team, so cannot be retired.");
                break;
            case -1:
                System.out.println("No champion found with the name " + name + ".");
                break;
            default:
                System.out.println("Unexpected result from retireChampion method.");
                break;
        }
    }


    private int getMenuItem() throws IOException {
        int choice = 100;
        System.out.println("\nMain Menu");
        System.out.println("0. Quit");
        System.out.println("1. List champions in reserve");
        System.out.println("2. List champions in viziers team");
        System.out.println("3. View a champion");
        System.out.println("4. Enter champion into vizier's team");
        System.out.println("5. Meet a challenge");
        System.out.println("6. Retire a champion");
        System.out.println("7. View game state");
        System.out.println("8. See all challenges");
        System.out.println("9. Save this game");
        System.out.println("10. Load this game");


        while (choice < 0 || choice > 10) {
            System.out.println("Enter the number of your choice");
            choice = myIn.nextInt();
        }
        myIn.nextLine();
        return choice;
    }

    private String processChallengeResult(int res) {

        String out;
        if (res == 0) {
            out = "Challenge won";
        } else if (res == 1) {
            out = "Challenge lost on skill level";
        } else if (res == 2) {
            out = "Challenge lost as no champion available";
        } else if (res == 3) {
            out = "Challenge lost with no further resources. You lose the game ";
        } else if (res == -1) {
            out = "No such challenge";
        } else {
            out = "No such result";
        }
        return out;
    }

    public static void main(String[] args) {
        new GameUI().runGame();
    }
}