package model.items;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.AbstractModelTest;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Defines some common methods for all the items tests
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestItem extends AbstractModelTest {

  // Parameters constructor testItem
  protected String expectedName;
  protected int expectedPower;
  protected short expectedMinRange;
  protected short expectedMaxRange;

  // Parameters constructor testUnit
  protected int unitHP = 10;
  protected int unitMovement = 5;

  /**
   * Sets up the items to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTestItem();
    setWrongRangeItem();
    setTargetUnits();
    setWeapons();
  }


  /**
   * Sets up a correctly implemented item that's going to be tested
   */
  @Override
  public abstract void setTestItem();

  /**
   * Sets up an item with wrong ranges setted.
   */
  public abstract void setWrongRangeItem();

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Checks that the tested item cannot have ranges outside of certain bounds.
   */
  @Test
  protected void incorrectRangeTest() {
    assertTrue(getWrongTestItem().getMinRange() >= 0);
    assertTrue(getWrongTestItem().getMaxRange() >= getWrongTestItem().getMinRange());
  }

  protected abstract IEquipableItem getWrongTestItem();

  /**
   * Tests that the constructor for the tested item works properly
   */
  @Test
  protected void constructorTest() {
    assertEquals(getExpectedName(), getTestItem().getName());
    assertEquals(getExpectedBasePower(), getTestItem().getPower());
    assertEquals(getExpectedMinRange(), getTestItem().getMinRange());
    assertEquals(getExpectedMaxRange(), getTestItem().getMaxRange());
  }

  /**
   * @return the expected name of the item
   */
  protected String getExpectedName() {
    return expectedName;
  }

  /**
   * @return the item being tested
   */
  @Override
  public abstract IEquipableItem getTestItem();

  /**
   * @return the expected power of the Item
   */
  protected int getExpectedBasePower() {
    return expectedPower;
  }

  /**
   * @return the expected minimum range of the item
   */
  protected int getExpectedMinRange() {
    return expectedMinRange;
  }

  /**
   * @return the expected maximum range of the item
   */
  protected int getExpectedMaxRange() {
    return expectedMaxRange;
  }

  /**
   * Checks that the Item can be correctly equipped to a unit
   */
  @Test
  protected void equippedToTest() {
    assertNull(getTestItem().getOwner());
    IUnit unit = getTestUnit();
    getTestUnit().addItem(getTestItem());
    getTestItem().equipTo(unit);
    assertEquals(unit, getTestItem().getOwner());
  }

  @Test
  protected void hasOwnerTest(){
    assertFalse(getTestItem().hasOwner());
    getTestItem().setOwner(getTestUnit());
    assertTrue(getTestItem().hasOwner());
  }

  @Test
  protected void addItemSetsOwnerItem(){
    assertFalse(getTestItem().hasOwner());
    getTestUnit().addItem(getTestItem());
    assertTrue(getTestItem().hasOwner());
    assertEquals(getTestUnit(), getTestItem().getOwner());
  }

  @Test
  protected void beingEquippedByAlpaca() {
    checkIncorrectEquippedItemTest(getAlpaca(),getTestItem());
  }

  @Test
  protected void beingEquippedByArcher() {
    checkIncorrectEquippedItemTest(getArcher(),getTestItem());
  }

  @Test
  protected void beingEquippedByCleric() {
    checkIncorrectEquippedItemTest(getCleric(),getTestItem());
  }

  @Test
  protected void beingEquippedByFighter() {
    checkIncorrectEquippedItemTest(getFighter(),getTestItem());
  }

  @Test
  protected void beingEquippedByHero() {
    checkIncorrectEquippedItemTest(getHero(),getTestItem());
  }

  @Test
  protected void beingEquippedBySorcerer() {
    checkIncorrectEquippedItemTest(getSpectralSorcerer(),getTestItem());
  }

  @Test
  protected void beingEquippedBySwordMaster() {
    checkIncorrectEquippedItemTest(getSwordMaster(),getTestItem());
  }

  /**
   * Item attack all target units when they are equipped, and checks damage is correct.
   * */
  protected abstract void attackEquippedTargetUnitsTest();

  /**
   * Default: attack all targetUnits. LightSorcerer it's treated differently because it's is not in range for all units.
   * */
  void attackUnEquippedTargetUnitsTest(){
    strongDamageTest(alpaca);
    strongDamageTest(archer);
    strongDamageTest(cleric);
    strongDamageTest(fighter);
    strongDamageTest(hero);
    strongDamageTest(swordMaster);
    strongDamageTest(darknessSorcerer);
    strongDamageTest(spectralSorcerer);
    strongDamageTest(lightSorcerer);
  }

  /**
   * Checks item act correctly on all targetUnits when they are equipped.
   * Default: attack units (it could heal also)
   * */
  @Test
  protected void actOnEquippedTargetUnitsTest(){
    equipTargetUnits();
    equipTestUnit();
    attackEquippedTargetUnitsTest();
  }

  /**
   * Checks item act correctly on all targetUnits when they aren't equipped.
   * Default: attack units (it could heal also)
   * */
  @Test
  protected void actOnUnEquippedTargetUnitsTest(){
    equipTestUnit();
    attackUnEquippedTargetUnitsTest();
  }


  protected void receiveBowAttackTest(){
    equipTestUnit();
    getTestItem().receiveBowAttack(bow);
    assertEquals(unitHP - targetPower,getTestUnit().getCurrentHitPoints());
  }

}
