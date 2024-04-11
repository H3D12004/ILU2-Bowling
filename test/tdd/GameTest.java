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
    
    @Test
    void test_extension() {
        int[] lancers = {1, 2, 10, 0, 10, 4, 2, 0, 10, 6, 2, 0, 10, 6, 4, 8, 2, 2, 8, 8};
        for (int pins : lancers) {
            game.roll(pins);
        }
        assertEquals(131, game.score());
    }

    @Test
    void test_genie() {
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }
    
    @Test
    void test_1() {
        int[] lancers = {1, 4, 4, 5, 6, 4, 5, 0, 1, 7, 3, 6, 2, 1, 10, 3, 4, 2, 8, 6};
        for (int pins : lancers) {
            game.roll(pins);
        }
        assertEquals(94, game.score());
    }
    
    @Test
    void test_2() {
        int[] lancers = {0, 10, 1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 6, 4, 7, 3, 8, 2, 9, 1, 10};
        for (int pins : lancers) {
            game.roll(pins);
        }
        assertEquals(155, game.score());
    }

}
