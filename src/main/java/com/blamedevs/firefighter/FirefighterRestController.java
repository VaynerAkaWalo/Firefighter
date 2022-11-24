package com.blamedevs.firefighter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirefighterRestController {

    @Autowired
    GameService gameService;


    @GetMapping("/firefighter/board")
    public boolean[][] getBoard() {
        return gameService.board.getBoard();
    }

    @GetMapping("/firefighter/reset")
    public void resetBoard() {gameService.board.resetBoard();}

    @GetMapping("/firefighter/extinguish")
    public void extinguish(@RequestParam() int x, @RequestParam() int y) {gameService.board.extinguish(new Position(x, y));}

    @GetMapping("/firefighter/boardSize")
    public int getSize() {
        return gameService.board.getSize();
    }
}
