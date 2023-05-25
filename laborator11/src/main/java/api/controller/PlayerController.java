package api.controller;

import api.entity.Player;
import api.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Player")
public class PlayerController {
    private PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService)
    {
        this.playerService = playerService;
    }
    @GetMapping("/all")
    @Operation(tags = {"Player"})
    public List<Player> getAll()
    {
        return playerService.getAll();
    }
    @PostMapping(path = "/add")
    @Operation(tags = {"Player"})
    public void addPlayer(@RequestBody Player player)
    {
        playerService.addPlayer(player);
    }
    @DeleteMapping(path = "/delete")
    @Operation(tags = {"Player"})
    public void deletePlayer(@RequestBody int id)
    {
        playerService.deletePlayer(id);
    }
    @PutMapping(path = "/update")
    @Operation(tags = {"Player"})
    public void updateNameById(@RequestBody String name, @PathVariable int id )
    {
        playerService.updateNameById(id, name);
    }
}
