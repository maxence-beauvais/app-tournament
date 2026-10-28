package java;

import main.java.Match;
import main.java.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("main.java.Match Unit Tests")
class MatchTest {

    private Team team1;
    private Team team2;
    private Match match;

    @BeforeEach
    void setUp() {
        team1 = new Team("Vitality");
        team2 = new Team("G2");
        match = new Match(team1, team2);
    }

    @Test
    @DisplayName("Should initialize match with 0-0 scores")
    void testInitialState() {
        assertEquals(team1, match.getTeam1());
        assertEquals(team2, match.getTeam2());
        assertEquals(0, match.getScoreTeam1());
        assertEquals(0, match.getScoreTeam2());
    }

    @Test
    @DisplayName("Should update scores correctly")
    void testSetScore() {
        match.setScore(13, 8);
        assertEquals(13, match.getScoreTeam1());
        assertEquals(8, match.getScoreTeam2());
    }

    @Test
    @DisplayName("Should identify winner and loser when main.java.Team 1 wins")
    void testTeam1Wins() {
        match.setScore(13, 5);
        assertEquals(team1, match.getWinner());
        assertEquals(team2, match.getLooser());
    }

    @Test
    @DisplayName("Should identify winner and loser when main.java.Team 2 wins")
    void testTeam2Wins() {
        match.setScore(9, 13);
        assertEquals(team2, match.getWinner());
        assertEquals(team1, match.getLooser());
    }

    @Test
    @DisplayName("Should display correct string format")
    void testToString() {
        match.setScore(13, 11);
        String expected = "Vitality vs G2 : 13 - 11";
        assertEquals(expected, match.toString());
    }
}