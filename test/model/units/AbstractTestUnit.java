package model.units;

import model.items.*;
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

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;


  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }



  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

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
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getInventory().isEmpty());
    assertEquals(getTestUnit(), getTestUnit().getLocation().getUnit());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    checkIncorrectEquippedItem(getAxe());
  }

  @Override
  @Test
  public void successfulExchange() {
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getTargetAlpaca().getNumberOfItems());
    getTargetAlpaca().addItem(getAxe());
    assertEquals(getTargetAlpaca(),getAxe().getOwner());
    getTargetAlpaca().giveItemAwayTo(getTestUnit(), getAxe());
    assertEquals(1, getTestUnit().getNumberOfItems());
    assertEquals(0, getTargetAlpaca().getNumberOfItems());
    assertEquals(getTestUnit(),getAxe().getOwner());
  }

  @Test
  @Override
  public void notGiveAwayItemNotOwned(){
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getTargetAlpaca().getNumberOfItems());
    assertNull(getAxe().getOwner());
    getTargetAlpaca().giveItemAwayTo(getTestUnit(), getAxe());
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getTargetAlpaca().getNumberOfItems());
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
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkIncorrectEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkIncorrectEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkIncorrectEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkIncorrectEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

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

  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    // out of range
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    // valid movement
    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    // move to occupied cell
    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Test
  public void receiveDamageTest(){
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    getTestUnit().receiveDamage(30);
    assertEquals(20, getTestUnit().getCurrentHitPoints());
  }

}
