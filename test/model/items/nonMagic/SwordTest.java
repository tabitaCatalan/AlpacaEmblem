package model.items.nonMagic;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;
import org.junit.jupiter.api.Test;

/**
 * Test set for swords
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordTest extends AbstractWeaponTest {

  private Sword testSword;
  private Sword wrongSword;
  private SwordMaster testSwordMaster;

  @Override
  public void setTestItem() {
    testSword = new Sword(getExpectedName(), getExpectedPower(), getExpectedMinRange(), getExpectedMaxRange());
  }

  protected String getExpectedName(){return  "Common Sword";}

  protected int getExpectedPower() {return 10;}

  protected int getExpectedMinRange(){return 1;}

  protected int getExpectedMaxRange(){return 2;}
  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSword = new Sword("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    testSwordMaster = new SwordMaster(getUnitHP(), getUnitMovement(), getField().getCell(2,2));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSword;
  }

  /**
   * @return the item being tested
   */
  @Override
  public INonMagical getTestItem() {
    return testSword;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return testSwordMaster;
  }

  @Override
  public void equipTestUnit(){
    equipUnit(testSwordMaster, testSword);
  }

  @Override
  @Test
  public void beingEquippedBySwordMaster() {
    checkCorrectEquippedItemTest(getSwordMaster(),getTestItem());
  }

  @Override
  public void attackEquippedTargetUnitsTest(){
    super.attackEquippedTargetUnitsTest();
    strongDamageTest(fighter);
    weakDamageTest(hero);
    normalDamageTest(swordMaster);
    strongDamageTest(lightSorcerer);
  }

  @Override
  public void attackUnEquippedTargetUnitsTest(){
    super.attackUnEquippedTargetUnitsTest();
    strongDamageTest(lightSorcerer);
  }
}
