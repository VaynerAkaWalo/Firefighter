package com.blamedevs.firefighter;

public class Tester {

    public static void main(String[] args) {
        Board board = new Board(30);
        FireGenerator fireGenerator = new FirstFireGenerator(board);
        fireGenerator.Fire();
    }

    public static void wypiszPlansze(Board board) {

        boolean[][] array = board.getBoard();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for(int y = 0; y < board.getSize(); y++) {
            for(int x = 0; x < board.getSize(); x++) {
                System.out.print(array[x][y] ? "f" : "l");
            }
            System.out.print("\n");
        }
    }

}
