package java;

import main.java.Team;
import main.java.Tournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("main.java.Tournament Unit Tests")
class TournamentTest {

    private Tournament tournament;
    private Team team1;
    private Team team2;

    @BeforeEach
    void setUp() {
        tournament = new Tournament(500000.0);
        team1 = new Team("Vitality");
        team2 = new Team("NaVi");
    }

    @Test
    @DisplayName("Should initialize tournament with correct cash prize")
    void testInitialization() {
        assertEquals(500000.0, tournament.getCashPrize());
        assertEquals(0, tournament.getNbTeams());
    }

    @Test
    @DisplayName("Should add teams and prevent duplicates")
    void testAddTeam() {
        tournament.addTeam(team1);
        assertEquals(1, tournament.getNbTeams());

        // Duplicate team should not be added
        tournament.addTeam(team1);
        assertEquals(1, tournament.getNbTeams());

        tournament.addTeam(team2);
        assertEquals(2, tournament.getNbTeams());
    }

    @Test
    @DisplayName("Should update cash prize correctly")
    void testSetCashPrize() {
        tournament.setCashPrize(1000000.0);
        assertEquals(1000000.0, tournament.getCashPrize());
    }
}