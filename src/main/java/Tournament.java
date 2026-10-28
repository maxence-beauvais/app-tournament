
import java.util.*;
import java.io.*;


public class Tournament {

    static Scanner scanner = new Scanner(System.in);


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
        exportHistoryToFile();
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
        winners.clear();

        for (Match match : matches) {
            Team t2 = match.getTeam2();
            if (Objects.equals(t2.getName(), "Null"))
                match.setScore(13,0);
            else {
                int s1, s2;
                do {
                    s1 = askScore(match.getTeam1());
                    s2 = askScore(match.getTeam2());
                    if (s1 == s2)
                        System.err.println("Two teams cannot have the same score.");
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

    private void exportHistoryToFile() {
        try {
            FileWriter fileWriter = new FileWriter("tournament_result.txt");
            for (Match match : history) {
                fileWriter.write(match.toString() + "\n");
            }
            fileWriter.write("Winner : " + winners.getFirst().getName());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int getNbTeams() {
        return teams.size();
    }

    private int askScore(Team team) {
        while (true) {
            try {
                System.out.println("Enter the result for " + team.getName());
                int score = scanner.nextInt();
                scanner.nextLine();
                return score;
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

}
