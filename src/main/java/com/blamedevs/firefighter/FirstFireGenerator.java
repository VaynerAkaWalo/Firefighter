package com.blamedevs.firefighter;

import java.util.Random;

public class FirstFireGenerator implements FireGenerator{

    private Board board;
    private Random random;

    {
        random = new Random();
    }

    FirstFireGenerator(Board board) {
        this.board = board;
    }

    @Override
    public void Fire(){


        while (true) {
            for(int y = 0; y < board.getSize(); y++) {
                for(int x = 0; x < board.getSize(); x++) {
                    Position position = new Position(x, y);
                    if(!board.isBurning(position)) {
                        int neighbourStatus = board.neighbourStatus(new Position(x, y));
                        int chance = 2;
                        if(neighbourStatus > 0) {
                            chance += 10;
                        }
                        chance += neighbourStatus * 3;

                        if(random.nextInt(101) < chance)
                            board.setOnFire(position);
                    }
                }
            }
            try {
                Thread.sleep(5000);
            }
            catch (Exception e) {

            }
        }
    }
}
