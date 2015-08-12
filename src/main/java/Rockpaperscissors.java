import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;


public class Rockpaperscissors {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->{
      HashMap model = new HashMap();

      model.put("template", "templates/playrockpaperscissors.vtl");
      return new ModelAndView(model, layout);

    }, new VelocityTemplateEngine());

    get("/play", (request, response) -> {
      HashMap model = new HashMap();

      String choice = request.queryParams("choice");
      if (choice.equals("computer")) {
        model.put("template", "templates/playervscomputer.vtl");
      } else {
        model.put("template", "templates/playervsplayer.vtl");
      }

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results_computer", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/results_computer.vtl");

      String player = request.queryParams("player");
      model.put("player", player);
      String computer = computerOutput();
      model.put("computer", computer);
      Boolean inputCheck = true;
      if (checkInput(player).equals("no")){
        inputCheck = false;
      } else {
        Boolean output = checkWinner(player, computer);
        model.put("output", output);
      }
      model.put("inputCheck", inputCheck);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results_player", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/results_player.vtl");

      String player1 = request.queryParams("player1");
      model.put("player1", player1);
      String player2 = request.queryParams("player2");
      model.put("player2", player2);
      Boolean inputCheck = true;
      if (checkInput(player1).equals("no") || checkInput(player2).equals("no")){
        inputCheck = false;
      } else {
        Boolean output = checkWinner(player1, player2);
        model.put("output", output);
      }
      model.put("inputCheck", inputCheck);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


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
      return "no";
    }
  }

  // public static Boolean checkWinnerVsComputer(String player) {
  //   player = checkInput(player);
  //
  //
  //   if ((player.equals("rock") && computer.equals(0)) ||
  //       (player.equals("scissors") && computer.equals(1)) ||
  //       (player.equals("paper") && computer.equals(2))) {
  //         System.out.println("Player said "+ player + ". Computer said "+computer+".");
  //         return true;
  //   } else {
  //     System.out.println("Player said "+ player + ". Computer said "+computer+".");
  //         return false;
  //   }
  //
  // }

  public static String computerOutput() {
    Random randomGen = new Random();
    Integer computer = randomGen.nextInt(3);

    //0 = scissors
    //1 = paper
    //2 = rock
    String computerString;
    if (computer.equals(0)) {
      computerString = "scissors";
    } else if (computer.equals(1)) {
      computerString = "paper";
    } else {
      computerString = "rock";
    }

    return computerString;
  }
}
