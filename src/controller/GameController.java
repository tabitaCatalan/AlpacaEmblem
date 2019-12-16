package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import model.Tactician;
import model.factories.items.*;
import model.factories.units.*;
import model.items.IEquipableItem;
import model.items.Staff;
import model.items.magic.DarknessBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.map.Field;
import model.map.MapFactory;
import model.units.*;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController implements PropertyChangeListener {

  private List<Tactician> tacticians;
  private int maxRound;
  private int actualRound;
  private int indexActualPlayer;
  private Field gameMap;

  // items factories
  private AxeFactory axefactory;
  private BowFactory bowFactory;
  private DarknessBookFactory darknessBookFactory;
  private LightBookFactory lightBookFactory;
  private SpearFactory spearFactory;
  private SpectralBookFactory spectralBookFactory;
  private StaffFactory staffFactory;
  private SwordFactory swordFactory;

  // units factories
  private AlpacaFactory alpacaFactory;
  private ArcherFactory archerFactory;
  private ClericFactory clericFactory;
  private FighterFactory fighterFactory;
  private HeroFactory heroFactory;
  private SorcererFactory sorcererFactory;
  private SwordMasterFactory swordMasterFactory;

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
    observeTacticians();
    createGameMap(mapSize);
    createFactories();
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

  /** Adds itself as observer of every tactician
   * */
  public void observeTacticians(){
    for (Tactician tactician: tacticians){
      tactician.addPropertyChangeListener(this);
    }
  }

  /**
   * @return number of players
   * */
  public int numberOfPlayers(){
    return tacticians.size();
  }

  /**
   * Creates the map of the game
   * */
  public void createGameMap(int size){
    MapFactory mapFactory = new MapFactory();
    gameMap = mapFactory.createAllConnectedMap(size);
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return gameMap;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return tacticians.get(indexActualPlayer);
  }

  private void actualizeTurnAndRoundAndShuffle(){
    if(indexActualPlayer < numberOfPlayers() - 1){
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
    return actualRound;
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
    actualizeTurnAndRoundAndShuffle();
  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tacticianName
   *     the player to be removed
   */
  public void removeTactician(String tacticianName) {
      Tactician tactician = getTacticianByName(tacticianName);
      if (tactician != null) {
          tactician.removeAllUnits();
          tacticians.remove(tactician);
      }
  }

  /**
   * obtain the Tactician whose name is given, or null if it does not exists.
   * @param tacticianName name of the wanted Tactician
   * */
    private Tactician getTacticianByName(String tacticianName) {
        for(Tactician tactician: tacticians){
            if(tactician.getName().equals(tacticianName)) return tactician;
        }
        return null;
    }

    /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {
    maxRound = maxTurns;
    actualRound = 1;
    indexActualPlayer = new Random().nextInt(numberOfPlayers());
    shufflePlayers();
  }

  /**
   * Game ends
   * */
  public void endGame(){
  }

  /**
   * @return the first tactician of this round
   * */
  private Tactician getFirstPlayerOfRound(){
    return tacticians.get(0);
  }

  /**
   * Reorders players, to be used at the beginning of a new round. Last player can't be the first one in the new round.
   * It's necessary to have more than two players
   * */
  private void shufflePlayers(){
    String lastPlayerName = tacticians.get(tacticians.size()-1).getName();
    do {
      Collections.shuffle(tacticians);
    }
    while (getFirstPlayerOfRound().getName().equals(lastPlayerName));
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
    return getTurnOwner().getSelectedUnit();
  }

  /**
   * Returns a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   *
   * @return unit in Location (x,y) (if there's an unit there)
   */
  private IUnit getUnitIn(int x, int y) {
    return gameMap.getCell(x,y).getUnit();
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
    IUnit unitInCell = getUnitIn(x,y);
    getTurnOwner().setSelectedUnit(unitInCell);
  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    if (getSelectedUnit()!= null) {
      return getSelectedUnit().getInventory();
    }
    else return null;
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
    IEquipableItem item = getItems().get(index);
    getSelectedUnit().equipItem(item); // solo si el item está en inventario
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
    IUnit targetUnit = getUnitIn(x,y);
    getSelectedUnit().useEquippedItemOn(targetUnit); // tal vez esto debería hacerlo tactician...
  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {
    IEquipableItem item = getItems().get(index);
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


  /**
   * To manage notification from Tactician
   * */
  @Override
  public void propertyChange(PropertyChangeEvent evt) {}


  // ITEMS AND UNITS CREATION
  /** It creates all factories to be used by controller to create items and units
   * */
  private void createFactories() {
    axefactory = new AxeFactory();
    bowFactory = new BowFactory();
    darknessBookFactory = new DarknessBookFactory();
    lightBookFactory = new LightBookFactory();
    spearFactory = new SpearFactory();
    spectralBookFactory = new SpectralBookFactory();
    staffFactory = new StaffFactory();
    swordFactory = new SwordFactory();

    // units factories
    alpacaFactory = new AlpacaFactory();
    archerFactory = new ArcherFactory();
    clericFactory = new ClericFactory();
    fighterFactory = new FighterFactory();
    heroFactory = new HeroFactory();
    sorcererFactory = new SorcererFactory();
    swordMasterFactory = new SwordMasterFactory();
  }
  /**
   * Creates a common Axe
   * */
  public Axe createAxe(){
    return axefactory.createItem();
  }

  /**
   * Creates a common Bow
   * */
  public Bow creatBow(){
    return bowFactory.createItem();
  }

  /**
   * Creates a Darkness Book
   * */
  public DarknessBook creatDarknessBook(){
    return darknessBookFactory.createItem();
  }

  /**
   * Creates a common Light Book
   * */
  public LightBook creatLightBook(){
    return lightBookFactory.createItem();
  }

  /**
   * Creates a common Spear
   * */
  public Spear createSpear(){
    return spearFactory.createItem();
  }

  /**
   * Creates a common Spectral Book
   * */
  public SpectralBook createSpectralBook(){
    return spectralBookFactory.createItem();
  }

  /**
   * Creates a common Staff
   */
  public Staff createStaff(){
    return staffFactory.createItem();
  }

  /**
   * Creates a common Sword
   * */
  public Sword createSword(){
    return swordFactory.createItem();
  }

  // units
  /**
   * Creates an Alpaca in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public Alpaca createAlpaca(int x, int y){
    return alpacaFactory.createUnit(getGameMap().getCell(x,y));
  }

  /**
   * Creates an Archer in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public Archer createArcher(int x, int y){
    return archerFactory.createUnit(getGameMap().getCell(x,y));
  }

  /**
   * Creates a Cleric in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public Cleric createCleric(int x, int y){
    return clericFactory.createUnit(getGameMap().getCell(x,y));
  }

  /**
   * Creates a Fighter in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public Fighter createFighter(int x, int y){
    return fighterFactory.createUnit(getGameMap().getCell(x,y));
  }

  /**
   * Creates a Hero in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public Hero createHero(int x, int y){
    return heroFactory.createUnit(getGameMap().getCell(x,y));
  }

  /**
   * Creates a Sorcerer in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public Sorcerer createSorcerer(int x, int y){
    return sorcererFactory.createUnit(getGameMap().getCell(x,y));
  }

  /**
   * Creates a SwordMaster in position (x, y)
   * @param x: row of the map
   * @param y: column of the map
   * */
  public SwordMaster createSwordMaster(int x, int y){
    return swordMasterFactory.createUnit(getGameMap().getCell(x,y));
  }



}
