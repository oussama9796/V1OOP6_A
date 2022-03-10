package Practicum6A;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames;

    public Persoon(String naam, double budget) {
        this.naam = naam;
        this.budget = budget;
        this.mijnGames = new ArrayList<>();
    }

    public double getBudget() {
        return budget;
    }


    public boolean koop(Game g) {
        if (budget >= g.huidigeWaarde() && !mijnGames.contains(g)) {
            mijnGames.add(g);
            budget -= g.huidigeWaarde();
            return true;
        }

        return false;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (!mijnGames.contains(g))
            return false;
        boolean kopen = koper.koop(g);
        if (kopen) {
            budget += g.huidigeWaarde();
            mijnGames.remove(g);
            return true;
        }
        return false;
    }

    public Game zoekGameOpNaam(String naam) {
        for (Game game : mijnGames)
            if (naam.equals(game.getNaam()))
                return game;
        return null;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> games) {
        ArrayList<Game> bepaalGamesNietInBezit = new ArrayList<>();
        for (Game game : games) {
            if(!mijnGames.contains(game))
                bepaalGamesNietInBezit.add(game);
        }
        return bepaalGamesNietInBezit;
    }

    @Override
    public String toString() {
        String str = String.format("%s heeft een budget van €%.2f en bezit de volgende games:", naam, budget);
        for (Game game : mijnGames) {
            str += "\n" + game.toString();
        }
        return str;
    }
}
