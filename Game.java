package MyStuff.TicTactoeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {
    
    Queue<Player> players;
    Board board;
    private static final int size = 3;
    private static final int numPlayeres = 2;

    public Game() {
        board = new Board(size, numPlayeres);
        players = new LinkedList<>();
    }

    public void setPlayers(List<Player> players) {
        for (Player p : players) {
            this.players.add(p);
        }
    }

    public void startGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Player player = players.poll();
            System.out.println("Enter the move for "+player.getName());
            String cmd = br.readLine();
            String commands[] = cmd.split(" ");
            int row = Integer.parseInt(commands[0]);
            int col = Integer.parseInt(commands[1]);

            if (board.isMoveValid(row, col, player)) {
                board.makeMove(row, col, player);
                if (board.hasPlayerWon(row, col, player)) {
                    System.out.println("Player" + player.getName() + " has won the game");
                    break;
                } else if (board.noValidMovesLeft(row, col, player))
                {
                    System.out.println("Game is drawn");
                    break;
                }
                
                players.add(player);
            } else {
                System.out.println("Invalid move");
            }
            
        }
    }

}
