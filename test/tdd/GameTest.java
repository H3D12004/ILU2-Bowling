package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    void test_aucune_quille() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    void test_20_fois_1() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    void test_10_fois_1_et_10_fois_2() {
        for (int i = 0; i < 10; i++) {
            game.roll(1);
        }
        for (int i = 0; i < 10; i++) {
            game.roll(2);
        }
        assertEquals(30, game.score());
    }
}
