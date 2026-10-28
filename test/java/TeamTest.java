package java;

import main.java.Player;
import main.java.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("main.java.Team Unit Tests")
class TeamTest {

    private Team team;
    private Player p1;
    private Player p2;

    @BeforeEach
    void setUp() {
        team = new Team("Vitality");
        p1 = new Player("ZywOo");
        p2 = new Player("apEX");
    }

    @Test
    @DisplayName("Should initialize team with correct default values")
    void testTeamInitialization() {
        assertEquals("Vitality", team.getName());
        assertEquals(0, team.getNbPlayers());
        assertEquals(5, team.getNbPlayersMax());
        assertTrue(team.getPlayers().isEmpty());
    }

    @Test
    @DisplayName("Should add players successfully up to max capacity")
    void testAddPlayer() {
        team.addPlayer(p1);
        assertEquals(1, team.getNbPlayers());
        assertTrue(team.getPlayers().contains(p1));

        team.addPlayer(p2);
        assertEquals(2, team.getNbPlayers());
    }

    @Test
    @DisplayName("Should not add duplicate players")
    void testAddDuplicatePlayer() {
        team.addPlayer(p1);
        team.addPlayer(p1);
        assertEquals(1, team.getNbPlayers());
    }

    @Test
    @DisplayName("Should enforce maximum player capacity")
    void testMaxPlayerLimit() {
        for (int i = 0; i < 6; i++) {
            team.addPlayer(new Player("main.java.Player" + i));
        }
        assertEquals(5, team.getNbPlayers());
        assertEquals(5, team.getPlayers().size());
    }

    @Test
    @DisplayName("Should format players list correctly")
    void testPlayersList() {
        assertEquals("no player\n", team.playersList());

        team.addPlayer(p1);
        assertTrue(team.playersList().contains("ZywOo"));
    }
}