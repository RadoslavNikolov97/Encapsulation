package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public void addPlayer(Player player){
      players.add(player);
    }
    public void removePlayer(String name){
        players.removeIf(player -> player.getName().equals(name));
    }
    public double getRating(String name){
        if (this.getName().equals(name)){
        double rating = 0;
        for (Player player :
                players) {
            rating += player.overallSkillLevel();
        }
        rating = rating / players.size();

        return Math.round(rating);
        }
        throw new IllegalArgumentException(String.format("Team %s does not exist.%n",name));
    }
}

