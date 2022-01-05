package footballTeamGenerator;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Team team = null;
        Player player = null;

        String command = sc.nextLine();
        while (!command.equals("END")) {
            try {


                String[] tokens = command.split(";");
                String action = tokens[0];
                String name = tokens[1];
                switch (action) {
                    case "Team":
                        team = new Team(name);
                        break;
                    case "Add":
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        if (team.getName().equals(name)) {
                            team.addPlayer(player);
                        } else {
                            System.out.printf("Team %s does not exist%n", name);
                        }
                        break;
                    case "Remove":
                        name = tokens[1];
                        playerName = tokens[2];
                        if (team.getName().equals(name)) {
                            if (player.getName().equals(playerName)) {
                                team.removePlayer(playerName);
                            } else {
                                System.out.printf("Player %s is not in %s team.%n", playerName, name);
                            }
                        }
                        break;
                    case "Rating":
                        name = tokens[1];
                        if (team.getName().equals(name)) {
                            System.out.printf("%s - %.0f", name, team.getRating(name));
                        }
                        break;
                }
                command = sc.nextLine();
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                command = sc.nextLine();
            }
        }
    }
}
