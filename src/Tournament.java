import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;


public class Tournament {

    private double cashPrize;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private ArrayList<Team> winners;
    private ArrayList<Match> history;

    public Tournament(double cashPrize) {
        this.cashPrize = cashPrize;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public void displayTeam() {
        for (Team team : teams) {
            System.out.println(team.getName());
        }
    }

    public void addTeam(Team team) {
        if (!teams.contains(team)) {
            teams.add(team);
        }

    }

    public void startTournament() {
        do {
            createMatches();
            display();
            result();
            clearMatches();
        } while (winners.size() > 1);
        System.out.println("Winner : " + winners.getFirst().getName());
        displayHistory();
    }

    private void createMatches() {
        if (winners.isEmpty()) {
            Collections.shuffle(teams);
            match(teams);
        }
        else {
            match(winners);
        }
    }

    private void match(ArrayList<Team> list) {
        for (int i = 0; i < list.size(); i += 2) {
            Team team1 = list.get(i);

            Team team2 = (i + 1 < list.size()) ? list.get(i + 1) : new Team("Null");

            Match match = new Match(team1, team2);
            matches.add(match);
        }
    }

    private void display() {
        for(int i = 0; i < matches.size(); i++) {
            System.out.println("Matches " + (i+1) );
            System.out.print(matches.get(i) + "\n");
        }
    }

    private void result() {
        Random random = new Random();
        winners.clear();

        for (Match match : matches) {
            Team t2 = match.getTeam2();
            if (Objects.equals(t2.getName(), "Null"))
                match.setScore(13,0);
            else {
                int s1, s2;
                do {
                    s1 = random.nextInt(14);
                    s2 = random.nextInt(14);
                } while (s1 != 13 && s2 != 13 ||s1 == s2);
                match.setScore(s1, s2);
            }
            displayResult(match);
            winners.add(match.getWinner());
        }
    }

    private void displayResult(Match match) {
        System.out.println("Result : \n" + match.toString());
    }

    private void clearMatches(){
        history.addAll(matches);
        matches.clear();
    }

    private void displayHistory() {
        System.out.println("History : ");
        for(Match match : history) {
            System.out.println(match);
        }
    }
}
