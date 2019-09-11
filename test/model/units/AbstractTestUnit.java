package model.units;

import model.items.*;
import model.items.magic.DarknessBook;
import model.items.magic.IMagicBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  // target units
  protected Alpaca alpaca;
  protected Archer archer;
  protected Cleric cleric;
  protected Fighter fighter;
  protected Hero hero;
  protected SwordMaster swordMaster;
  protected Sorcerer darknessSorcerer;
  protected Sorcerer lightSorcerer;
  protected Sorcerer spectralSorcerer;


  // test items
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected IMagicBook spectralBook;
  protected IMagicBook darknessBook;
  protected IMagicBook lightBook;



  // SETTINGS
  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetUnits();
    setWeapons();
  }

  /**
   * Set up the game field
   */
  public void setField() {
    this.field = new Field();
    this.field.addCells(true,
            new Location(0, 0), new Location(0, 1), new Location(0, 2), new Location(0, 3), new Location(0, 4),
            new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(1, 3), new Location(1, 4),
            new Location(2, 0), new Location(2, 1), new Location(2, 2) , new Location(2, 3), new Location(2, 4),
            new Location(3, 0), new Location(3, 1), new Location(3, 2), new Location(3, 3), new Location(3, 4),
            new Location(4, 0), new Location(4, 1), new Location(4, 2), new Location(4, 3), new Location(4, 4));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Set up the target units
   */
  public void setTargetUnits(){
    alpaca = new Alpaca(50, 2, field.getCell(0, 2));
    archer = new Archer(50, 2, field.getCell(3, 3));
    cleric = new Cleric(50, 2, field.getCell(2, 4));
    fighter = new Fighter(50, 2, field.getCell(2, 0));
    hero = new Hero(50, 2, field.getCell(1, 3));
    swordMaster = new SwordMaster(50, 2, field.getCell(3,1));
  }

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.spectralBook = new SpectralBook("Book of Souls", 10, 1, 2);
    this.darknessBook = new DarknessBook("Necronomicon", 10, 1, 2);
    this.lightBook = new LightBook("Light Book", 10, 1, 2);
  }


  // CONSTRUCTOR TEST
  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(2, 2), getTestUnit().getLocation());
    assertTrue(getTestUnit().getInventory().isEmpty());
    assertEquals(getTestUnit(), getTestUnit().getLocation().getUnit());
    assertFalse(getTestUnit().hasEquippedItem());
    assertTrue(getTestUnit().getEquippedItem().isNullItem());
  }

  // GETTERS

  // Getter field
  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  // Getters units

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getAlpaca() {
    return alpaca;
  }


  // Getters items
  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  /**
   * @return the test magic book of type Spectral
   */
  @Override
  public IMagicBook getSpectralBookBook() {
    return spectralBook;
  }

  /**
   * @return the test magic book of type Darkness
   */
  @Override
  public IMagicBook getDarknessBook() {
    return darknessBook;
  }

  /**
   * @return the test magic book of type Light
   */
  @Override
  public IMagicBook getLightBook() {
    return lightBook;
  }

  // INVENTORY TESTS

  @Override
  @Test
  public void addItemTest(){
    assertTrue(getTestUnit().getInventory().isEmpty());
    getTestUnit().addItem(getAxe());
    assertEquals(1, getTestUnit().getInventory().size());
  }

  @Override
  @Test
  public void addItemMoreThanMaxTest(){
    assertTrue(getTestUnit().hasSpaceInInventory());
    getTestUnit().addItem(getAxe());
    getTestUnit().addItem(getBow());
    getTestUnit().addItem(getSpear());
    assertFalse(getTestUnit().hasSpaceInInventory());
    assertEquals(3, getTestUnit().getNumberOfItems());
    getTestUnit().addItem(getSword());
    assertEquals(3, getTestUnit().getNumberOfItems());
  }

  // EQUIP ITEMS TESTS

  /**
   * add item to unit's inventory and tries to equip the item
   * @param unit: unit who'll receive the item
   * @param item: item to be equipped
   */
  public void equipUnit(IUnit unit, IEquipableItem item){
    unit.addItem(item);
    unit.equipItem(item);
  }

  /**
   * Equip item to TestUnit
   * */
  protected abstract void equipTestUnit();

  /**
   * Check test unit has been correctly equipped
   * */
  @Test
  protected void isEquippedTest(){
      equipTestUnit();
      assertTrue(getTestUnit().hasEquippedItem());
  }

  /**
   * Tries to equip an correct weapon to a Unit and verifies that it was equipped. Item has to be added to inventory first.
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkCorrectEquippedItem(IUnit unit, IEquipableItem item) {
    assertTrue(unit.getEquippedItem().isNullItem());
    item.equipTo(unit);
    assertTrue(unit.getEquippedItem().isNullItem());
    unit.addItem(item);
    unit.equipItem(item);
    assertEquals(item, unit.getEquippedItem());
  }

  /**
   * Tries to equip an incorrect weapon to a Unit and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkIncorrectEquippedItem(IEquipableItem item) {
    assertTrue(getTestUnit().getEquippedItem().isNullItem());
    getTestUnit().equipItem(item);
    assertTrue(getTestUnit().getEquippedItem().isNullItem());
  }

  @Override
  @Test
  public void equipAxeTest() {
    checkIncorrectEquippedItem(getAxe());
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkIncorrectEquippedItem(getSword());
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkIncorrectEquippedItem(getSpear());
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkIncorrectEquippedItem(getStaff());
  }

  @Override
  @Test
  public void equipBowTest() {
    checkIncorrectEquippedItem(getBow());
  }

  @Override
  @Test
  public void equipSpectralBookTest() {
    checkIncorrectEquippedItem(getSpectralBookBook());
  }

  @Override
  @Test
  public void equipDarknessBookTest() {
    checkIncorrectEquippedItem(getDarknessBook());
  }

  @Override
  @Test
  public void equipLightBookTest() {
    checkIncorrectEquippedItem(getLightBook());
  }


  // EXCHANGES TESTS
  @Override
  @Test
  public void successfulExchange() {
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getAlpaca().getNumberOfItems());
    getAlpaca().addItem(getAxe());
    assertEquals(getAlpaca(),getAxe().getOwner());
    getAlpaca().giveItemAwayTo(getTestUnit(), getAxe());
    assertEquals(1, getTestUnit().getNumberOfItems());
    assertEquals(0, getAlpaca().getNumberOfItems());
    assertEquals(getTestUnit(),getAxe().getOwner());
  }

  @Test
  @Override
  public void notGiveAwayItemNotOwned(){
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getAlpaca().getNumberOfItems());
    assertNull(getAxe().getOwner());
    getAlpaca().giveItemAwayTo(getTestUnit(), getAxe());
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getAlpaca().getNumberOfItems());
  }

  // MOVEMENT TESTS

  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    // out of range
    getTestUnit().moveTo(getField().getCell(0, 0));
    assertEquals(new Location(2, 2), getTestUnit().getLocation());

    // valid movement
    getTestUnit().moveTo(getField().getCell(1, 2));
    assertEquals(new Location(1, 2), getTestUnit().getLocation());

    // fail moving to occupied cell
    assertEquals(new Location(0,2), getAlpaca().getLocation());
    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(1, 2), getTestUnit().getLocation());
  }

  // HIT POINTS CONTROL (DAMAGE AND HEALING)

  @Test
  public void receiveDamageTest(){
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    getTestUnit().receiveDamage(30);
    assertEquals(20, getTestUnit().getCurrentHitPoints());
  }

  // ATTACKS AND COUNTERATTACKS
    /**
     * equip all target units
     */
    public void equipTargetUnits(){
        equipUnit(archer, bow);
        equipUnit(cleric, staff);
        equipUnit(fighter, axe);
        equipUnit(hero, spear);
        equipUnit(swordMaster, sword);
    }

    /**
     * check currentHP of testUnit, after using the equipped item on targetUnit
     * @param expectedLife: targetUnit's HP expected after the use of the item
     * @param targetUnit: unit that receives the action
     */
    public void useItemOnUnitTest(int expectedLife, IUnit targetUnit){
        //assertTrue(getTestUnit().isInRange(targetUnit));
        getTestUnit().useEquippedItemOn(targetUnit);
        assertEquals(expectedLife, targetUnit.getCurrentHitPoints());
    }

    /**
     * check that targetUnit received strong damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    public void strongDamageTest(IUnit targetUnit){
        useItemOnUnitTest(35, targetUnit);
    }

    /**
     * check that targetUnit received normal damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    public void normalDamageTest(IUnit targetUnit){
        useItemOnUnitTest(40, targetUnit);
    }

    /**
     * check that targetUnit received weak damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    public void weakDamageTest(IUnit targetUnit){
        useItemOnUnitTest(50, targetUnit);
    }

    /**
     * check that targetUnit didn't receive damage after the use of an object
     * @param targetUnit: unit who'll receive the item's effect
     */
    public void zeroDamageTest(IUnit targetUnit){
        useItemOnUnitTest(50, targetUnit);
    }

    /**
     * function that checks that all units receives strong damage after being attacked while unequipped.
     */
    public void attackUnEquippedUnitsTest(){
        strongDamageTest(alpaca);
        strongDamageTest(archer);
        strongDamageTest(cleric);
        strongDamageTest(fighter);
        strongDamageTest(hero);
        strongDamageTest(swordMaster);
    }

    /**
     * function that checks that all units receives the correct amount of damage after being attacked while equipped with their item.
     */
    public abstract void attackEquippedUnitsTest();

    /**
     * checks that all units receives strong damage after being attacked while unequipped.
     */
    @Test
    void useItemOnUnEquippedTargetUnitsTest() {
        equipTestUnit();
        attackUnEquippedUnitsTest();
    }

    /**
     * equip target units and checks that all units receives the correct amount of damage after being attacked while equipped with their item.
     */
    @Test
    void equipTargetsAndUseItemOnEquippedTargetUnitsTest() {
        equipTestUnit();
        equipTargetUnits();
        attackEquippedUnitsTest();
    }

    // RANGES AND DISTANCES

    /**
     *checks that distance to target units is correct
     */
    @Test
    public void distanceTest(){
        assertEquals(2, getTestUnit().distanceTo(alpaca));
        assertEquals(2, getTestUnit().distanceTo(archer));
        assertEquals(2, getTestUnit().distanceTo(cleric));
        assertEquals(2, getTestUnit().distanceTo(fighter));
        assertEquals(2, getTestUnit().distanceTo(hero));
        assertEquals(2, getTestUnit().distanceTo(swordMaster));
    }

    /**
     *checks that all units are in range
     */
    @Test
    public void isInRangeTest(){
        equipTestUnit();
        assertTrue(getTestUnit().isInRange(alpaca));
        assertTrue(getTestUnit().isInRange(archer));
        assertTrue(getTestUnit().isInRange(cleric));
        assertTrue(getTestUnit().isInRange(fighter));
        assertTrue(getTestUnit().isInRange(hero));
        assertTrue(getTestUnit().isInRange(swordMaster));
    }
}
