package api.service;

import api.entity.Game;
import api.entity.Player;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class GameService {
    private List<Game> games;
    private List<Player> players;
    private PlayerService playerService;
 public GameService()
    {
        games = new ArrayList<>();
    }
    public List<Game> getAll()
    {
        players = playerService.getAll();
        for(int i = 0; i < players.size(); i += 2)
        {
            Game game = new Game(i, players.get(i), players.get(i+1));
            games.add(game);
        }
        return games;
    }

}
