package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {

  private List<Tactician> tacticians;
  private int maxRound;
  private int actualRound;
  private int indexActualPlayer;

  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
    createTacticians(numberOfPlayers);
  }

  /**
   * Creates as many Tacticians as number of players
   *
   * @param numberOfPlayers
   *     the number of players for this game
   */
  private void createTacticians(int numberOfPlayers){
    tacticians = new ArrayList <Tactician>();
    for(int i = 0; i < numberOfPlayers; i++){
      tacticians.add(new Tactician("Player " + i));
    }
  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticians() {
    return tacticians;
  } // o copy of tacticians?

  /**
   * @return number of players
   * */
  public int numberOfPlayers(){
    return tacticians.size();
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return null;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return null;
  }

  private void actualizeTurnAndRound(){
    if(indexActualPlayer < numberOfPlayers()){
      indexActualPlayer++;
    }
    else if(actualRound < maxRound){
      shufflePlayers();
      indexActualPlayer = 0;
      actualRound++;
    }
    // terminar juego
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return 0;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return maxRound;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {

  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {

  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {
    maxRound = maxTurns;
    actualRound = 1;
    indexActualPlayer = 0;
  }

  /**
   * Game ends
   * */
  public void endGame(){
  }

  /**
   * @return tha first tactician of this round
   * */
  private Tactician getFirstPlayerOfRound(){
    return tacticians.get(0);
  }

  /**
   * reorders players at the beginning of a new round
   * */
  private void shufflePlayers(){
    Tactician lastPlayer = tacticians.get(tacticians.size()-1);
    do {
      Collections.shuffle(tacticians);
    }
    while (getFirstPlayerOfRound().equals(lastPlayer));
  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {

  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    return null;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return null;
  }

  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {

  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return null;
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {

  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {

  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {

  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {

  }
}
