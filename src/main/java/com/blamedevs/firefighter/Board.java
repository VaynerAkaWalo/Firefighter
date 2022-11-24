package com.blamedevs.firefighter;


import java.util.Arrays;

public class Board {
    private int size;
    private boolean[][] board;

    Board(int size) {
        this.size = size;
        board = new boolean[size][size];
    }

    public int getSize() {
        return size;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public boolean isBurning(Position position) {
        if (checkCords(position))
            return board[position.x()][position.y()];
        return false;
    }

    public boolean extinguish(Position position) {
        if(checkCords(position)) {
            board[position.x()][position.y()] = false;
            return true;
        }
        return false;
    }

    public boolean setOnFire(Position position) {
        if(checkCords(position)) {
            board[position.x()][position.y()] = true;
            return true;
        }
        return false;
    }

    public void resetBoard() {
        for(boolean[] column : board) {
            Arrays.fill(column, false);
        }
    }

    private boolean checkCords(Position position) {
        return position.x() >= 0 && position.x() < size && position.y() >= 0 && position.y() < size;
    }

    public int neighbourStatus(Position position) {
        int result = 0;
        for(int i = 0; i < Neighbour.values().length; i++) {
            Position neighbour = Neighbour.values()[i].neighborPosition(position);
            if(checkCords(neighbour))
                if(isBurning(neighbour))
                    result++;
        }
        return result;
    }
}
