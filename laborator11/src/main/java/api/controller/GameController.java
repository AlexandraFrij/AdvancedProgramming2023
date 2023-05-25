package api.controller;

import api.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.entity.Game;
import java.util.*;
@RestController
@RequestMapping("/game")
public class GameController {
    GameService gameService;
    /*public GameController(GameService gameService)
    {
        this.gameService = gameService;
    }*/
    @GetMapping(path = "/all")
    public List<Game> getAll()
    {
        return gameService.getAll();
    }
}
