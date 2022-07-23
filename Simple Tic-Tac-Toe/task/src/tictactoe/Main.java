package tictactoe;

import java.util.Scanner;

public class Main {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String[] POSSIBLE_RESULTS = {"X wins", "O wins", "Impossible", "Draw", "Game not finished"};
    private static final int X_WINS = 0;
    private static final int O_WINS = 1;
    private static final int IMPOSSIBLE = 2;
    private static final int DRAW = 3;
    private static final int NOT_FINISHED = 4;

    public static void main(String[] args) {

        String[][] game = getGame();

        printDashes();
        printGame(game);
        printDashes();

        newUserMove(game);

        printDashes();
        printGame(game);
        printDashes();
        // System.out.println(getGameResult(game));
    }

    private static void newUserMove(String[][] game) {
        boolean valid = false;
        int[] userInput;
        do {
            userInput = getUserInput();
            if (game[userInput[0]][userInput[1]].trim().isEmpty() || game[userInput[0]][userInput[1]].equals("_")) {
                valid = true;
                game[userInput[0]][userInput[1]] = "X";
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } while (!valid);

    }

    public static String getGameResult(String[][] game) {

        int countX = 0;
        int countO = 0;
        String result = null;
        int numOfWinners = 0;

        for (String[] x : game) {
            for (String z : x) {
                if (z.equalsIgnoreCase("O")) countO++;
                if (z.equalsIgnoreCase("X")) countX++;
            }
        }

        if (game[0][0].equalsIgnoreCase(game[0][1]) && game[0][0].equalsIgnoreCase(game[0][2])) {
            result = game[0][0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[1][0].equalsIgnoreCase(game[1][1]) && game[1][0].equalsIgnoreCase(game[1][2])) {
            result = game[1][0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[2][0].equalsIgnoreCase(game[2][1]) && game[2][0].equalsIgnoreCase(game[2][2])) {
            result = game[2][0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0][0].equalsIgnoreCase(game[1][1]) && game[0][0].equalsIgnoreCase(game[2][2])) {
            result = game[0][0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0][2].equalsIgnoreCase(game[1][1]) && game[0][2].equalsIgnoreCase(game[2][0])) {
            result = game[0][2].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0][0].equalsIgnoreCase(game[1][0]) && game[0][0].equalsIgnoreCase(game[2][0])) {
            result = game[0][0].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0][1].equalsIgnoreCase(game[1][1]) && game[0][1].equalsIgnoreCase(game[2][1])) {
            result = game[0][1].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
            numOfWinners++;
        }
        if (game[0][2].equalsIgnoreCase(game[1][2]) && game[0][2].equalsIgnoreCase(game[2][2])) {
            result = game[0][2].equalsIgnoreCase("X") ? POSSIBLE_RESULTS[X_WINS] : POSSIBLE_RESULTS[O_WINS];
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

    public static void printGame(String[][] game) {
        for (String[] line : game) {
            System.out.print("| ");
            for (String position : line) {
                System.out.print(position + " ");
            }
            System.out.println("|");
        }
    }

    public static String[][] getGame() {
        Scanner scanner = new Scanner(System.in);
        String symbols = scanner.nextLine();
        String[][] game = new String[ROWS][COLS];

        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (index < symbols.length()) {
                    game[i][j] = String.valueOf(symbols.charAt(index));
                    index++;
                } else {
                    game[i][j] = "";
                }
            }
        }
        return game;
    }

    public static int[] getUserInput() throws NumberFormatException {
        Scanner input = new Scanner(System.in);
        int[] values = new int[2];
        boolean validInput = false;
        do {
            try {
                String[] userInput = input.nextLine().split(" ");
                values[0] = Integer.parseInt(userInput[0]);
                values[1] = Integer.parseInt(userInput[1]);
                if ((values[0] >= 1 && values[0] <= 3 && (values[1] >= 1 && values[1] <= 3))) {
                    validInput = true;

                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("wrong format");
            }

        } while (!validInput);
        normalizeUserInput(values);
        return values;
    }

    public static void normalizeUserInput(int[] values) {
        values[0]--;
        values[1]--;

    }
}
	
