import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Чак Норрис", 100 );
    Player player2 = new Player(2, "Брюс Ли", 100 );
    Player player3 = new Player(3, "Конор Макгрегор", 21 );

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    void register() {

        ArrayList<Player> expected = new ArrayList<>(Arrays.asList(player1,player2,player3));
        ArrayList<Player> actual = game.getPlayerList();

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void roundPlayer1Win() {

        int expected = 1;
        int actual = game.round("Чак Норрис","Конор Макгрегор");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundPlayer2Win() {

        int expected = 2;
        int actual = game.round("Конор Макгрегор","Брюс Ли");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundDraw() {

        int expected = 0;
        int actual = game.round("Чак Норрис","Брюс Ли");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundPlayer1NotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
         game.round("Жан-Клод Ван Дамм","Чак Норрис");
        });
    }

    @Test
    void roundPlayer2NotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Брюс Ли", "Джеки Чан");
        });
    }
}