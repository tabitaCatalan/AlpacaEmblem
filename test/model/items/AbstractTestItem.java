package model.items;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.AbstractModelTest;
import model.units.Archer;
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
    setTestItem();
    setWrongRangeItem();
    setTestUnit();
    setTargetUnits();
    setWeapons();
  }


  /**
   * Sets up a correctly implemented item that's going to be tested
   */
  public abstract void setTestItem();

  /**
   * Sets up an item with wrong ranges setted.
   */
  public abstract void setWrongRangeItem();

  /**
   * Sets the unit that will be equipped with the test item
   */
  public abstract void setTestUnit();

  /**
   * Checks that the tested item cannot have ranges outside of certain bounds.
   */
  @Test
  public void incorrectRangeTest() {
    assertTrue(getWrongTestItem().getMinRange() >= 0);
    assertTrue(getWrongTestItem().getMaxRange() >= getWrongTestItem().getMinRange());
  }

  public abstract IEquipableItem getWrongTestItem();

  /**
   * Tests that the constructor for the tested item works properly
   */
  @Test
  public void constructorTest() {
    assertEquals(getExpectedName(), getTestItem().getName());
    assertEquals(getExpectedBasePower(), getTestItem().getPower());
    assertEquals(getExpectedMinRange(), getTestItem().getMinRange());
    assertEquals(getExpectedMaxRange(), getTestItem().getMaxRange());
  }

  /**
   * @return the expected name of the item
   */
  public String getExpectedName() {
    return expectedName;
  }

  /**
   * @return the item being tested
   */
  public abstract IEquipableItem getTestItem();

  /**
   * @return the expected power of the Item
   */
  public int getExpectedBasePower() {
    return expectedPower;
  }

  /**
   * @return the expected minimum range of the item
   */
  public int getExpectedMinRange() {
    return expectedMinRange;
  }

  /**
   * @return the expected maximum range of the item
   */
  public int getExpectedMaxRange() {
    return expectedMaxRange;
  }

  /**
   * Checks that the Item can be correctly equipped to a unit
   */
  @Test
  public void equippedToTest() {
    assertNull(getTestItem().getOwner());
    IUnit unit = getTestUnit();
    getTestUnit().addItem(getTestItem());
    getTestItem().equipTo(unit);
    assertEquals(unit, getTestItem().getOwner());
  }

  @Test
  public void hasOwnerTest(){
    assertFalse(getTestItem().hasOwner());
    getTestItem().setOwner(getTestUnit());
    assertTrue(getTestItem().hasOwner());
  }

  @Test
  public void addItemSetsOwnerItem(){
    assertFalse(getTestItem().hasOwner());
    getTestUnit().addItem(getTestItem());
    assertTrue(getTestItem().hasOwner());
    assertEquals(getTestUnit(), getTestItem().getOwner());
  }

  @Test
  public void beingEquippedByAlpaca() {
    checkIncorrectEquippedItem(getAlpaca(),getTestItem());
  }

  @Test
  public void beingEquippedByArcher() {
    checkIncorrectEquippedItem(getArcher(),getTestItem());
  }

  @Test
  public void beingEquippedByCleric() {
    checkIncorrectEquippedItem(getCleric(),getTestItem());
  }

  @Test
  public void beingEquippedByFighter() {
    checkIncorrectEquippedItem(getFighter(),getTestItem());
  }

  @Test
  public void beingEquippedByHero() {
    checkIncorrectEquippedItem(getHero(),getTestItem());
  }

  @Test
  public void beingEquippedBySorcerer() {
    checkIncorrectEquippedItem(getSpectralSorcerer(),getTestItem());
  }

  @Test
  public void beingEquippedBySwordMaster() {
    checkIncorrectEquippedItem(getSwordMaster(),getTestItem());
  }


  /**
   * Checks item acts correctly when acting (attacking, healing) on targetUnit
   *
  public abstract void actOnTest(IUnit targetUnit);*/

  /*@Test
  void actOnTargetUnitTest(){
    actOnTest();
  }*/
}
