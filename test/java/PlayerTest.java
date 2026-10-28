package java;

import main.java.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("main.java.Player Unit Tests")
class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("ZywOo");
    }

    @Test
    @DisplayName("Should return correct initial username")
    void testGetUsername() {
        assertEquals("ZywOo", player.getUsername());
    }

    @Test
    @DisplayName("Should update username correctly")
    void testSetUsername() {
        player.setUsername("apEX");
        assertEquals("apEX", player.getUsername());
    }

    @Test
    @DisplayName("Should return formatted string representation")
    void testToString() {
        assertTrue(player.toString().contains("ZywOo"));
    }
}