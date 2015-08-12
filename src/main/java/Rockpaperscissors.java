import java.util.Random;


public class Rockpaperscissors {
  public static void main(String[] args) {}

  public static Boolean checkWinner(String player1, String player2) {
    //Does player1 win?
    player1 = checkInput(player1);
    player2 = checkInput(player2);

    if ((player1.equals("rock") && player2.equals("scissors")) ||
        (player1.equals("scissors") && player2.equals("paper")) ||
        (player1.equals("paper") && player2.equals("rock"))) {
          return true;
    } else {
          return false;
    }
  }

  public static String checkInput(String player){
    System.out.println(player);
    player = player.toLowerCase();
    System.out.println(player);
    if (player.equals("rock") || player.equals("scissors") || player.equals("paper")){
      return player;
      }
    else {
      System.out.println("Bad input.  Please enter rock, scissors, or paper.");
      return "no";
    }
  }

  public static Boolean checkWinnerVsComputer(String player) {
    player = checkInput(player);
    Random randomGen = new Random();
    Integer computer = randomGen.nextInt(3);

    //0 = scissors
    //1 = paper
    //2 = rock

    if ((player.equals("rock") && computer.equals(0)) ||
        (player.equals("scissors") && computer.equals(1)) ||
        (player.equals("paper") && computer.equals(2))) {
          System.out.println("Player said "+ player + ". Computer said "+computer+".");
          return true;
    } else {
      System.out.println("Player said "+ player + ". Computer said "+computer+".");
          return false;
    }

  }
}
