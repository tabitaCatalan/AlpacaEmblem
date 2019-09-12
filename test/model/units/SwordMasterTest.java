package model.units;

import model.items.IEquipableItem;
import model.items.nonMagic.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster testSwordMaster;
  private Sword testSword;

  @Override
  public void setTestUnit() {
    testSwordMaster = new SwordMaster(50, 2, field.getCell(2, 2));
  }

  @Override
  public IUnit getTestUnit() {
    return testSwordMaster;
  }

  @Override
  public void setTestItem(){
    testSword = new Sword("Test Sword", 10, 1, 2);
  }

  @Override
  public IEquipableItem getTestItem() {
    return testSword;
  }

  @Test
  @Override
  public void equipSwordTest() {
    checkCorrectEquippedItemTest(testSwordMaster, sword);
  }


  @Override
  public void equipTestUnit(){
    getTestUnit().addItem(testSword);
    getTestUnit().equipItem(testSword);
  }

  @Override
  public void attackEquippedUnitsTest(){
    normalDamageTest(archer);
    normalDamageTest(cleric);
    strongDamageTest(fighter);
    weakDamageTest(hero);
    normalDamageTest(swordMaster);
  }

  @Test
  @Override
  public void isInRangeTest(){
    super.isInRangeTest();
    assertTrue(getTestUnit().isInRange(lightSorcerer));
  }

}