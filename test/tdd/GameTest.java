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
    
    @Test
    void test_spare() {
        game.roll(7);
        game.roll(3); //Spare (7+3)
        game.roll(4);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertEquals(18, game.score()); // 7+3+4(bonus pour spare)+4 = 18
    }
    
    @Test
    void test_strike() {
        game.roll(10); //Strike (10)
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assertEquals(24, game.score());
    }

    @Test
    void test_cas_general() {
        int[] lancers = {1, 2, 10, 0, 10, 4, 2, 0, 10, 6, 2, 0, 10, 6, 4, 8, 2, 2, 7};
        for (int pins : lancers) {
            game.roll(pins);
        }
        assertEquals(122, game.score());
    }
    
}
