
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static boolean isEnd = false;
    static Tournament tournament;

    public static void main(){

        do {
            mainMenu();
        } while (!isEnd);

    }

    public static void mainMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Create a tournament");
        System.out.println("2. Exit");

        int reply = scanner.nextInt();
        String scan = scanner.nextLine();
        switch (reply) {
            case 1:
                createTournament();
                break;
            case 2:
                isEnd = true;
                break;
            default:
                System.err.println("Please enter a valid number");
                mainMenu();
                break;
        }
    }

    public static void createTournament() {
        System.out.println("Enter the tournament cash prize");
        double reply = scanner.nextDouble();
        String scan = scanner.nextLine();
        tournament = new Tournament(reply);
        tournamentMenu();
    }

    public static void tournamentMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Show all teams in the tournament");
        System.out.println("2. Add a team to the tournament");
        System.out.println("3. Start the tournament");
        System.out.println("4. Exit");

        int reply = scanner.nextInt();
        String scan = scanner.nextLine();
        switch (reply) {
            case 1:
                tournament.displayTeam();
                tournamentMenu();
                break;
            case 2:
                addTeam();
                break;
            case 3:
                if (tournament.getNbTeams() >= 2) {
                    tournament.startTournament();
                } else {
                    System.err.println("You cannot start a tournament with fewer than 2 teams.");
                    tournamentMenu();
                }
                break;
            case 4:
                isEnd = true;
                break;
            default:
                System.err.println("Please enter a valid number");
                mainMenu();
                break;
        }

    }

    private static void addTeam() {
        System.out.println("Enter the name of the team you want to add to the tournament");
        String nameTeam = scanner.nextLine();
        tournament.addTeam(new Team(nameTeam));
        System.out.println("The team has been added successfully");
        tournamentMenu();
    }
}
