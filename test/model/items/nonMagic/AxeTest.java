package model.items.nonMagic;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Fighter;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class AxeTest extends AbstractWeaponTest {

  private Axe testAxe;
  private Axe wrongAxe;
  private Fighter testFighter;

  @Override
  public void setTestItem() {
    testAxe = new Axe(getExpectedName(), getExpectedPower(), getExpectedMinRange(), getExpectedMaxRange());
  }

  protected String getExpectedName(){return "Common axe";}

  protected int getExpectedPower() {return 10;}

  protected int getExpectedMinRange(){return 1;}

  protected int getExpectedMaxRange(){return 2;}

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongAxe = new Axe("Wrong axe", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    testFighter = new Fighter(getUnitHP(), getUnitMovement(), getField().getCell(2,2));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongAxe;
  }

  @Override
  public INonMagical getTestItem() {
    return testAxe;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testFighter;
  }

  @Override
  public void equipTestUnit(){
    equipUnit(testFighter, testAxe);
  }

  @Override
  @Test
  public void beingEquippedByFighter() {
    checkCorrectEquippedItemTest(getFighter(),getTestItem());
  }

  @Override
  public void attackEquippedTargetUnitsTest(){
    super.attackEquippedTargetUnitsTest();
    normalDamageTest(fighter);
    strongDamageTest(hero);
    weakDamageTest(swordMaster);
    strongDamageTest(lightSorcerer);
  }

  @Override
  public void attackUnEquippedTargetUnitsTest(){
    super.attackUnEquippedTargetUnitsTest();
    strongDamageTest(lightSorcerer);
  }

}