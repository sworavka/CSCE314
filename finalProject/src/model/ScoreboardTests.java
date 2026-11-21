package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTests {

    //Initial model state.
    @Test
    void testInitialState() {
        Scoreboard scoreboard = new Scoreboard();
        assertNull(scoreboard.getHomeTeamName());
        assertNull(scoreboard.getAwayTeamName());
        assertEquals(0, scoreboard.getHomeScore());
        assertEquals(0, scoreboard.getAwayScore());
    }

    // Setting and updating team names.
    @Test
    void testSetTeamNames() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        assertEquals("Team A", scoreboard.getHomeTeamName());
        assertEquals("Team B", scoreboard.getAwayTeamName());
    }

    @Test
    void testUpdateTeamNames() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.setTeamNames("Team C", "Team D");
        assertEquals("Team C", scoreboard.getHomeTeamName());
        assertEquals("Team D", scoreboard.getAwayTeamName());
    }

    // Each valid scoring amount.
    // Scoring for both teams.
    @Test
    void testAddOnePointToHome() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(1);
        assertEquals(1, scoreboard.getHomeScore());
        assertEquals("Extra point", scoreboard.validateScore(1));
        assertEquals("Home +1 (Extra point)", scoreboard.getLastOperation());
    }
    @Test
    void testAddTwoPointsToHome() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(2);
        assertEquals(2, scoreboard.getHomeScore());
        assertEquals("Safety", scoreboard.validateScore(2));
        assertEquals("Home +2 (Safety)", scoreboard.getLastOperation());
    }
    @Test
    void testAddThreePointsToHome() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(3);
        assertEquals(3, scoreboard.getHomeScore());
        assertEquals("Field goal", scoreboard.validateScore(3));
        assertEquals("Home +3 (Field goal)", scoreboard.getLastOperation());
    }
    @Test
    void testAddSixPointsToHome() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(6);
        assertEquals(6, scoreboard.getHomeScore());
        assertEquals("Touchdown", scoreboard.validateScore(6));
        assertEquals("Home +6 (Touchdown)", scoreboard.getLastOperation());
    }
    @Test
    void testAddOnePointToAway() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToAway(1);
        assertEquals(1, scoreboard.getAwayScore());
        assertEquals("Extra point", scoreboard.validateScore(1));
        assertEquals("Away +1 (Extra point)", scoreboard.getLastOperation());
    }
    @Test
    void testAddTwoPointsToAway() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToAway(2);
        assertEquals(2, scoreboard.getAwayScore());
        assertEquals("Safety", scoreboard.validateScore(2));
        assertEquals("Away +2 (Safety)", scoreboard.getLastOperation());
    }
    @Test
    void testAddThreePointsToAway() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToAway(3);
        assertEquals(3, scoreboard.getAwayScore());
        assertEquals("Field goal", scoreboard.validateScore(3));
        assertEquals("Away +3 (Field goal)", scoreboard.getLastOperation());
    }
    @Test
    void testAddSixPointsToAway() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToAway(6);
        assertEquals(6, scoreboard.getAwayScore());
        assertEquals("Touchdown", scoreboard.validateScore(6));
        assertEquals("Away +6 (Touchdown)", scoreboard.getLastOperation());
    }

    // Consecutive scoring operations.
    @Test
    void testConsecutiveScoring() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(3);
        scoreboard.addPointsToAway(2);
        scoreboard.addPointsToHome(6);
        assertEquals(9, scoreboard.getHomeScore());
        assertEquals(2, scoreboard.getAwayScore());
    }

    // Undoing one or multiple actions.
    @Test
    void testUndoLastAction() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(3);
        scoreboard.addPointsToAway(2);
        scoreboard.undoLast();
        assertEquals(3, scoreboard.getHomeScore());
        assertEquals(0, scoreboard.getAwayScore());
    }
    @Test
    void testUndoMultipleActions() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(3);
        scoreboard.addPointsToAway(2);
        scoreboard.addPointsToHome(6);
        scoreboard.undoLast();
        scoreboard.undoLast();
        assertEquals(3, scoreboard.getHomeScore());
        assertEquals(0, scoreboard.getAwayScore());
    }

    // Undoing with empty history.
    @Test
    void testUndoWithEmptyHistory() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.undoLast();
        assertEquals(0, scoreboard.getHomeScore());
        assertEquals(0, scoreboard.getAwayScore());
    }

    // Clearing the game.
    // Preserving names after clearing.
    @Test
    void testClearGame() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(3);
        scoreboard.addPointsToAway(2);
        scoreboard.clearGame();
        assertEquals(0, scoreboard.getHomeScore());
        assertEquals(0, scoreboard.getAwayScore());
        assertEquals("Team A", scoreboard.getHomeTeamName());
        assertEquals("Team B", scoreboard.getAwayTeamName());
    }
    @Test
    void testClearGameAndUndo() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A", "Team B");
        scoreboard.addPointsToHome(3);
        scoreboard.addPointsToAway(2);
        scoreboard.clearGame();
        scoreboard.undoLast();
        assertEquals(0, scoreboard.getHomeScore());
        assertEquals(0, scoreboard.getAwayScore());
    }
    
    // Rejecting invalid team names and scoring requests.
    @Test
    void testSetNullTeamNames() {
        Scoreboard scoreboard = new Scoreboard();
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.setTeamNames(null, "Team B");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.setTeamNames("Team A", null);
        });
    }
    @Test
    void testSetEmptyTeamNames() {
        Scoreboard scoreboard = new Scoreboard();
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.setTeamNames("", "Team B");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.setTeamNames("Team A", " ");
        });
    }
    
    @Test
    void testAddDisallowedPoints() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A","Team B");
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.addPointsToHome(7);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.addPointsToAway(5);
        });
    }

    @Test
    void testAddPointsBeforeSettingTeamNames() {
        Scoreboard scoreboard = new Scoreboard();
        assertThrows(IllegalStateException.class, () -> {
            scoreboard.addPointsToHome(3);
        });
        assertThrows(IllegalStateException.class, () -> {
            scoreboard.addPointsToAway(2);
        });
    }

    @Test
    void testAddStringAsPoints() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setTeamNames("Team A","Team B");
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.addPointsToHome(Integer.parseInt("abc"));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            scoreboard.addPointsToAway(Integer.parseInt("xyz"));
        });
    }
}