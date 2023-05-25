package api.service;

import api.entity.Player;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PlayerService {
    private List<Player> players;
    public PlayerService()
    {
        players = new ArrayList<>();
        Player player1 = new Player(1, "John", "black");
        Player player2 = new Player(2, "Maria", "white");
        Player player3 = new Player(3, "Julia", "black");
        Player player4 = new Player(4, "Claude", "white");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }
    public List<Player> getAll()
    {
        return players;
    }
    public void updateNameById(int id, String name)
    {
        for(Player player: players)
        {
            if(player.getId() == id)
            {
                player.setName(name);
                break;
            }
        }
    }
    public void deletePlayer( int id)
    {
        for(Player player: players)
        {
            if(player.getId() == id)
            {
                players.remove(player);
                break;
            }
        }
    }
    public void addPlayer(Player player)
    {
        players.add(player);
    }
}
