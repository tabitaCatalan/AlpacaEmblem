package model.units;

import model.AbstractModelTest;
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
public abstract class AbstractTestUnit extends AbstractModelTest {

  // SETTINGS
  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTestItem();
    setTargetUnits();
    setWeapons();
  }


  // CONSTRUCTOR TEST
  /**
   * Checks that the constructor works properly.
   */
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

  // INVENTORY TESTS

  @Test
  public void addItemTest(){
    assertTrue(getTestUnit().getInventory().isEmpty());
    getTestUnit().addItem(getAxe());
    assertEquals(1, getTestUnit().getInventory().size());
  }

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
  public void checkIncorrectEquippedItem(IEquipableItem item) {
    assertTrue(getTestUnit().getEquippedItem().isNullItem());
    getTestUnit().addItem(item);
    getTestUnit().equipItem(item);
    assertTrue(getTestUnit().getEquippedItem().isNullItem());
  }

  @Test
  public void equipAxeTest() {
    checkIncorrectEquippedItem(getAxe());
  }

  @Test
  public void equipSwordTest() {
    checkIncorrectEquippedItem(getSword());
  }

  @Test
  public void equipSpearTest() {
    checkIncorrectEquippedItem(getSpear());
  }

  @Test
  public void equipStaffTest() {
    checkIncorrectEquippedItem(getStaff());
  }

  @Test
  public void equipBowTest() {
    checkIncorrectEquippedItem(getBow());
  }

  @Test
  public void equipSpectralBookTest() {
    checkIncorrectEquippedItem(getSpectralBookBook());
  }

  @Test
  public void equipDarknessBookTest() {
    checkIncorrectEquippedItem(getDarknessBook());
  }

  @Test
  public void equipLightBookTest() {
    checkIncorrectEquippedItem(getLightBook());
  }


  // EXCHANGES TESTS
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
