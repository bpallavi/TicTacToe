package MyStuff.TicTactoeGame;

import java.io.IOException;
import java.util.*;

public class Driver {
    public static void main(String args[]) throws IOException {
        Player p = new Player("A", "X");
        Player p1 = new Player("B", "O");
        List<Player> players = new ArrayList<>();

        players.add(p1);
        players.add(p);

        Game g = new Game();
        g.setPlayers(players);
        g.startGame();

    }
}