package model.units;

import model.AbstractModelTest;
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

  /**
   * */
  @Test
  public void isDeadTest(){
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    getTestUnit().receiveDamage(49);
    assertTrue(getTestUnit().isAlive());
    assertEquals(1, getTestUnit().getCurrentHitPoints());
    getTestUnit().receiveDamage(1);
    assertFalse(getTestUnit().isAlive());
    assertEquals(0, getTestUnit().getCurrentHitPoints());
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
   * Check test unit has been correctly equipped
   * */
  @Test
  protected void isTestUnitEquippedTest(){
      equipTestUnit();
      assertTrue(getTestUnit().hasEquippedItem());
  }

  @Test
  public void equipAxeTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getAxe());
  }

  @Test
  public void equipSwordTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getSword());
  }

  @Test
  public void equipSpearTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getSpear());
  }

  @Test
  public void equipStaffTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getStaff());
  }

  @Test
  public void equipBowTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getBow());
  }

  @Test
  public void equipSpectralBookTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getSpectralBook());
  }

  @Test
  public void equipDarknessBookTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getDarknessBook());
  }

  @Test
  public void equipLightBookTest() {
    checkIncorrectEquippedItemTest(getTestUnit(), getLightBook());
  }


  // EXCHANGES TESTS
  @Test
  public void successfulExchange() {
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getLightSorcerer().getNumberOfItems());
    getLightSorcerer().addItem(getAxe());
    assertEquals(getLightSorcerer(),getAxe().getOwner());
    getLightSorcerer().giveItemAwayTo(getTestUnit(), getAxe());
    assertEquals(1, getTestUnit().getNumberOfItems());
    assertEquals(0, getLightSorcerer().getNumberOfItems());
    assertEquals(getTestUnit(),getAxe().getOwner());
  }

  @Test
  public void notInRangeFailedExchange() {
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(0, getDarknessSorcerer().getNumberOfItems());
    getDarknessSorcerer().addItem(getAxe());
    assertEquals(getDarknessSorcerer(),getAxe().getOwner());
    getDarknessSorcerer().giveItemAwayTo(getTestUnit(), getAxe());
    assertEquals(0, getTestUnit().getNumberOfItems());
    assertEquals(1, getDarknessSorcerer().getNumberOfItems());
    assertEquals(getDarknessSorcerer(),getAxe().getOwner());
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
     * function that checks that all units receives strong damage after being attacked while unequipped.
     */
    public void attackUnEquippedUnitsTest(){
        strongDamageTest(alpaca);
        strongDamageTest(archer);
        strongDamageTest(cleric);
        strongDamageTest(fighter);
        strongDamageTest(hero);
        strongDamageTest(swordMaster);
        strongDamageTest(darknessSorcerer);
        strongDamageTest(lightSorcerer);
        strongDamageTest(spectralSorcerer);
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
      assertEquals(2, getTestUnit().distanceTo(spectralSorcerer));
      assertEquals(2, getTestUnit().distanceTo(darknessSorcerer));
      assertEquals(1, getTestUnit().distanceTo(lightSorcerer));
    }

    /**
     *checks that all units are in range (or not)
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
      assertTrue(getTestUnit().isInRange(darknessSorcerer));
      assertTrue(getTestUnit().isInRange(spectralSorcerer));
    }

    /**
     * Verifies than an dead unit cant return attack
     * */
    @Test
  public void deadUnitDoesNotCounterAttackTest(){
      equipTestUnit();
      equipTargetUnits();
      assertEquals(50, getTestUnit().getCurrentHitPoints());
      assertEquals(targetHP, getDarknessSorcerer().getCurrentHitPoints());
      getDarknessSorcerer().receiveDamage(targetHP-1);
      getTestUnit().useEquippedItemOn(getDarknessSorcerer());
      assertFalse(getDarknessSorcerer().isAlive());
      assertEquals(50, getTestUnit().getCurrentHitPoints());
    }

    @Test
  public void targetUnitCounterAttack(){

    }



}
