package com.blamedevs.firefighter;

import org.springframework.stereotype.Component;

@Component
public class GameService {

    Board board;
    FireGenerator fireGenerator;

    GameService() {
        board = new Board(50);
        fireGenerator = new FirstFireGenerator(board);
        Thread thread = new Thread(() -> fireGenerator.Fire());

        thread.start();
    }

}
