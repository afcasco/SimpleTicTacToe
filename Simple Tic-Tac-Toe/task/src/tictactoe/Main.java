package tictactoe;

import java.util.Scanner;

public class Main {

    private static final String[] POSSIBLE_RESULTS = {"X wins", "O wins", "Impossible", "Draw", "Game not finished"};
    private static final int X_WINS = 0;
    private static final int O_WINS = 1;
    private static final int IMPOSSIBLE = 2;
    private static final int DRAW = 3;
    private static final int NOT_FINISHED = 4;

    public static void main(String[] args) {
        String[] game = getGame();
        printDashes();
        printGame(game);
        printDashes();
        System.out.println(getGameResult(game));
    }

    public static String getGameResult(String[] game) {

        int countX = 0;
        int countO = 0;
        String result = null;
        int numOfWinners = 0;

        for (String x : game) {
            if (x.equalsIgnoreCase("O")) countO++;
            if (x.equalsIgnoreCase("X")) countX++;
        }

        if (game[0].equalsIgnoreCase(game[1]) && game[0].equalsIgnoreCase(game[2])) {
            result = game[0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[3].equalsIgnoreCase(game[4]) && game[3].equalsIgnoreCase(game[5])) {
            result = game[3].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[6].equalsIgnoreCase(game[7]) && game[6].equalsIgnoreCase(game[8])) {
            result = game[6].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0].equalsIgnoreCase(game[4]) && game[0].equalsIgnoreCase(game[8])) {
            result = game[0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[2].equalsIgnoreCase(game[4]) && game[2].equalsIgnoreCase(game[6])) {
            result = game[2].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0].equalsIgnoreCase(game[3]) && game[0].equalsIgnoreCase(game[6])) {
            result = game[0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[1].equalsIgnoreCase(game[4]) && game[1].equalsIgnoreCase(game[7])) {
            result = game[1].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[2].equalsIgnoreCase(game[5]) && game[2].equalsIgnoreCase(game[8])) {
            result = game[2].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }

        if (numOfWinners == 0) {
            result = POSSIBLE_RESULTS[DRAW];
        }
        if (countO + countX != 9 && numOfWinners != 1) {
            result = POSSIBLE_RESULTS[NOT_FINISHED];
        }
        if (Math.abs(countO - countX) >= 2 || numOfWinners > 1) {
            result = POSSIBLE_RESULTS[IMPOSSIBLE];
        }

        return result;
    }

    public static void printDashes() {
        System.out.println("---------");
    }

    public static void printGame(String[] game) {
        for (int i = 0; i < game.length; i++) {
            if (i % 3 == 0) {
                System.out.print("| ");
            }
            System.out.print(game[i] + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println("|");
            }
        }
    }

    public static String[] getGame() {
        Scanner scanner = new Scanner(System.in);
        String symbols = scanner.nextLine();
        String[] game = new String[symbols.length()];

        for (int i = 0; i < symbols.length(); i++) {
            game[i] = String.valueOf(symbols.charAt(i));
        }
        return game;
    }
}
	
