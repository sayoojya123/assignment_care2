package cwk4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 *
 * @author A.A.Marczyk
 * @version 20/01/24
 */
public class GameGUI {
    private CARE gp = new Tournament("Fred");
    private JFrame myFrame = new JFrame("Game GUI");
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel();
    private JButton meetBtn = new JButton("Meet Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    public static void main(String[] args) {
        new GameGUI();
    }

    public GameGUI() {
        makeFrame();
        makeMenuBar(myFrame);
    }


    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing, BorderLayout.CENTER);
        listing.setVisible(false);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4, 1));
        eastPanel.add(meetBtn);
        eastPanel.add(viewBtn);
        eastPanel.add(clearBtn);
        eastPanel.add(quitBtn);

        clearBtn.addActionListener(new ClearBtnHandler());
        meetBtn.addActionListener(new MeetBtnHandler());
        viewBtn.addActionListener(new ViewStateHandler());
        quitBtn.addActionListener(new QuitBtnHandler());

        meetBtn.setVisible(true);
        viewBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame) {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the File menu
        JMenu championMenu = new JMenu("Champions");
        menubar.add(championMenu);

        JMenuItem listChampionItem = new JMenuItem("List Champions in reserve");
        listChampionItem.addActionListener(new ListReserveHandler());
        championMenu.add(listChampionItem);

        //Add menu items to list the team, view a champion, and enter a champion
        JMenuItem listTeamItem = new JMenuItem("List Team");
        listTeamItem.addActionListener(new ListTeamHandler());
        championMenu.add(listTeamItem);

        JMenuItem viewChampionItem = new JMenuItem("View Champion");
        viewChampionItem.addActionListener(new ViewChampionHandler());
        championMenu.add(viewChampionItem);

        JMenuItem enterChampionItem = new JMenuItem("Enter Champion");
        enterChampionItem.addActionListener(new EnterChampionHandler());
        championMenu.add(enterChampionItem);


        // Create the Challenges menu
        JMenu challengesMenu = new JMenu("Challenges");
        menubar.add(challengesMenu);

        // Add menu item to list all challenges
        JMenuItem listChallengesItem = new JMenuItem("List All Challenges");
        listChallengesItem.addActionListener(new ListChallengesHandler());
        challengesMenu.add(listChallengesItem);

    }

    private class ListReserveHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listing.setVisible(true);
            String xx = gp.getReserve();
            listing.setText(xx);
        }
    }

    private class ListTeamHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listing.setVisible(true);
            String teamDetails = gp.getTeam();
            listing.setText(teamDetails);
        }
    }


    private class ListChallengesHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listing.setVisible(true);
            String allChallenges = gp.getAllChallenges();
            listing.setText(allChallenges);
        }
    }

    private class ViewStateHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listing.setVisible(true);
            String state = gp.toString();
            listing.setText(state);
        }
    }


    private class ViewChampionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String championName = JOptionPane.showInputDialog("Enter the name of the champion:");
            String championDetails = gp.getChampionDetails(championName);
            JOptionPane.showMessageDialog(myFrame, championDetails);
        }
    }

    private class EnterChampionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String championName = JOptionPane.showInputDialog("Enter the name of the champion:");
            int result = gp.enterChampion(championName);
            String message;
            switch (result) {
                case 0:
                    message = "Champion entered successfully.";
                    break;
                case 1:
                    message = "Champion is not in reserve.";
                    break;
                case 2:
                    message = "Not enough money in the treasury.";
                    break;
                case -1:
                    message = "No such champion.";
                    break;
                default:
                    message = "Unknown error.";
            }
            JOptionPane.showMessageDialog(myFrame, message);
        }
    }


    private class ClearBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listing.setText(" ");
        }
    }

    private class MeetBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int result = -1;
            String answer = "no such challenge";
            String inputValue = JOptionPane.showInputDialog("Challenge number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.meetChallenge(num);
            switch (result) {
                case 0:
                    answer = "challenge won by champion";
                    break;
                case 1:
                    answer = "challenge lost on skills, champion disqualified";
                    break;
                case 2:
                    answer = "challenge lost as no suitable champion is available";
                    break;
                case 3:
                    answer = "challenge lost and vizier completely defeated";
                    break;
            }

            JOptionPane.showMessageDialog(myFrame, answer);
        }
    }

    private class QuitBtnHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int answer = JOptionPane.showConfirmDialog(myFrame,
                    "Are you sure you want to quit?", "Finish",
                    JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION) {
                System.exit(0); //closes the application
            }
        }
    }

}
   
