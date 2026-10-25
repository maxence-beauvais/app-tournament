import java.util.*;

public class Team {

    private String name;
    private ArrayList<Player> players;
    private int nbPlayers;
    private int nbPlayersMax;

    public Team(String name){
        this.name = name;
        this.nbPlayers = 0;
        this.nbPlayersMax = 5;
        players = new ArrayList<>();
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public int getNbPlayersMax() {
        return nbPlayersMax;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        if(!players.contains(player)) {
            if (nbPlayers < nbPlayersMax) {
                players.add(player);
                nbPlayers++;
            }
        }
    }

    public String playersList(){
        StringBuilder res = new StringBuilder();
        if(players.isEmpty()) {
            res = new StringBuilder("no player\n");
        }
        for(int i = 0; i < players.size(); i++) {
            res.append("Player ").append(i).append(" : ").append(players.get(i).toString()).append("\n");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return "Team " + name + "\n" + playersList();
    }
}
