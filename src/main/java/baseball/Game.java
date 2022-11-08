package baseball;

import baseball.view.InputView;

import static baseball.constants.Message.STRIKE_MESSAGE;

public class Game {

  private Player player;
  private Computer computer;

  public void setAnswer() {
    this.computer = new Computer();
    computer.setAnswer();
  }

  public void setGuess(String input) {
    this.player = new Player();
    player.setNumbers(input);
  }

  public String getHint(Player player, Computer computer) {
    Hint hint = new Hint(player, computer);
    return hint.getHint();
  }

  public void printHint(String hint) {
    System.out.println(hint);
  }

  public void guessNumber() {
    do {
      setGuess(InputView.getUserNumber());
      printHint(getHint(player, computer));
    } while (!is3Strike(getHint(player, computer)));
  }

  public boolean is3Strike(String hint) {
    return hint.equals(3+STRIKE_MESSAGE);
  }

}
