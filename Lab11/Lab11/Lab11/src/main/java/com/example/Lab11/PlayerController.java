package com.example.Lab11;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class PlayerController {
    private List<Player> listOfUsers=new ArrayList<>();
    public PlayerController()
    {
        Player player1=new Player(1,"Maria");
        Player player2=new Player(2,"Dan");
        listOfUsers.add(player1);
        listOfUsers.add(player2);
    }
    @GetMapping("/get_users") public List<Player> getListOfUsers() {
        return listOfUsers;
    }
    @PostMapping(value ="/post_user", consumes="application/json")
    public String createPlayer(@RequestBody Player player) {
        listOfUsers.add(player);
        return "Player created successfully";
    }
    @PutMapping("/put_user_name")
    public String updatePlayer(@RequestParam int id, @RequestParam String name) {
       Player player = findById(id);
        if (player == null) {
            return "Player not found";
        }
        player.setName(name);
        return "Player's name updated successfully";
    }

    private Player findById(int id) {
        for(Player player:listOfUsers)
        {
            if(player.getId()==id)
            {
                return player;
            }
        }
        return null;
    }
    @DeleteMapping("/delete_user")
    public String deletePlayer(@RequestParam int id) {
        Player player = findById(id);
        if (player == null) {
            return "Player not found";
        }
        listOfUsers.remove(player);
        return "Player removed";
    }


}
