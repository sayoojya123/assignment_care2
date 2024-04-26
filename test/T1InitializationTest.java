/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cwk4.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author comqaam
 */
public class T1InitializationTest {
    CARE game;

    public T1InitializationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new Tournament("Olek");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:

    //Enter a champion who is in reserve and has enough money in the treasury.
    @Test
    public void testEnterChampion1() {
        Tournament tournament = new Tournament("Vizier");
        int result = tournament.enterChampion("Ganfrank");
        assertEquals(result, 0);
        assertEquals(tournament.getTeam(), "************ Vizier's Team of champions********\nGanfrank\n");
    }

    //Enter a champion who is not in reserve.
    @Test
    public void testEnterChampion2() {

        Tournament tournament = new Tournament("Vizier");

        int result = tournament.enterChampion("Tom");

        assertEquals(result, -1);

    }

    //    Enter a champion who is in reserve but there is not enough money in the treasury.
    @Test

    public void testEnterChampion3() {

        Tournament tournament = new Tournament("Vizier");

        tournament.enterChampion("Drabina");
        tournament.enterChampion("Golum");

        int result = tournament.enterChampion("Flimsi");

        assertEquals(result, 2);
    }

//    Enter a champion who is not in reserve.
    @Test
    public void testEnterChampion4() {

        Tournament tournament = new Tournament("Vizier");
        tournament.setTreasury(10000);
        for (Champion champion : tournament.getChampions()) {
            tournament.enterChampion(champion.getName());
        }

        int result = tournament.enterChampion("Krypton");

        assertEquals(result, 1);

    }

    //Get the reserve when there are no champions in the reserve.
    @Test
    public void testGetReserve1() {

        Tournament tournament = new Tournament("Vizier");
        tournament.setTreasury(10000);
        for (Champion champion : tournament.getChampions()) {
            tournament.enterChampion(champion.getName());
        }

        assertEquals(tournament.getReserve(), "************ Champions available in reserves********\nNo Champions in Reserve\n");

    }

    //just a local method to check a String for contents
    private boolean containsText(String text, String[] s) {
        boolean check = true;
        for (int i = 0; i < s.length; i++)
            check = check && text.contains(s[i]);
        return check;
    }

    @Test
    public void gameCorrectlyInitialised() {
        String result = game.toString();
        String[] xx = {"Olek", "1000", "Is OK", "No champions"};
        boolean actual = containsText(result, xx);
        assertTrue(actual);
    }

    @Test
    public void treasuryTest() {
        int expected = 1000;
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    @Test
    public void defeatedTest() {
        boolean actual = game.isDefeated();
        assertFalse(actual);
    }

    @Test
    public void checkTeamEmptyAtStart() {
        boolean result = true;
        List<String> champs = new ArrayList<String>(Arrays.asList("Ganfrank", "Rudolf",
                "Elblond", "Flimsi", "Drabina", "Golum", "Argon", "Neon", "Xenon"));

        for (String chmp : champs) {
            result = result && !game.isInViziersTeam(chmp);
        }
        assertTrue(result);
    }
}
