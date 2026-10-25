import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static boolean isEnd = false;
    static Tournament tournament;

    public static void main(){
       // Tournament tournament = new Tournament(10.00);

        //Team vitality = new Team("Vitality");
        //Team navi = new Team("Natus Vincere");
        //Team spirit = new Team("Spirit");
        //Team falcons = new Team("Falcons");
        //Team crouton = new Team("Croûton");

        //tournament.addTeam(vitality);
        //tournament.addTeam(navi);
        //tournament.addTeam(spirit);
        //tournament.addTeam(falcons);
        //tournament.addTeam(crouton);

        //tournament.startTournament();


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
                tournament.startTournament();
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
