package com.example.Lab11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private List<Game> listOfGames=new ArrayList<>();
    public GameController()
    {
        Game game=new Game(1,"game1");
        listOfGames.add(game);
    }
    @GetMapping("/get_games") public List<Game> getListOfUsers() {
        return listOfGames;
    }
}
