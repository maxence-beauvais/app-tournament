public class Match
{
    private Team team1, team2;
    private int scoreTeam1, scoreTeam2;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.scoreTeam1 = 0;
        this.scoreTeam2 = 0;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public Team getWinner(){
        if (scoreTeam1 > scoreTeam2)
            return team1;
        else
            return team2;
    }

    public Team getLooser(){
        if (scoreTeam1 < scoreTeam2)
            return team1;
        else
            return team2;
    }

    public void setScore(int scoreTeam1, int scoreTeam2 ) {
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    @Override
    public String toString() {
        return team1.getName() + " vs " + team2.getName() + " : " + scoreTeam1 + " - " + scoreTeam2;
    }
}
