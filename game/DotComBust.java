package JAVAlaba.game;
import java.util.*;
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;
     private void setUpGame() {
         DotCom one = new DotCom();
         one.setName("Pets.com");
         DotCom two = new DotCom();
         two.setName("eToys.com");
         DotCom three = new DotCom();
         three.setName("Go2.com");
         dotComsList.add(one);
         dotComsList.add(two);
         dotComsList.add(three);

         System.out.println("¬аша цель потопить 3 сайта");
         System.out.println("Pets.com, eToys.com, Go2.com");
         System.out.println("ѕопытайтесь потопить их за минимальное колличество ходов");
         for(DotCom dotComToSet : dotComsList) {
             ArrayList<String> newLocation = helper.placeDotCom(3);
             dotComToSet.setLocationCells(newLocation);
         }
     }
     private void startPlaying() {
         while (!dotComsList.isEmpty()) {
             String userGuess = helper.getUserInput("—делай ход");
             checkUserGuess(userGuess);
         }
         finishGame();

     }
     private void checkUserGuess(String userGuess) {
         numOfGuesses++;
         String result = "ћимо";
         for (DotCom dotComToTest : dotComsList) {
             result = dotComToTest.checkYourself(userGuess);
             if (result.equals("ѕопал")) {
                 break;
             }
             if (result.equals("ѕотопил")) {
                 dotComsList.remove(dotComToTest);
                 break;
             }
         }
         System.out.println(result);
     }


     private void finishGame() {
         System.out.println("¬се сайты ушли ко дну ваши акции ничего не сто€т:)");
         if (numOfGuesses <= 18) {
             System.out.println("Ёто зан€ло у вас всего" + numOfGuesses + "попыток");
             System.out.println("вы успели быбратьс€ до того как ваши вложени€ утонули");
         } else {
             System.out.println("Ёто зан€ло  у вас довольно много времени" + numOfGuesses + "попыток");
             System.out.println("рыбы вод€т хороводы вокруг ваших вложений");
         }
     }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
