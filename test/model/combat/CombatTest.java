package model.combat;

import model.items.*;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import model.map.Field;
import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class CombatTest {

    protected Field field;
    protected Alpaca alpaca;
    protected Archer archer;
    protected Cleric cleric;
    protected Fighter fighter;
    protected Hero hero;
    protected SwordMaster swordMaster;
    protected Axe axe;
    protected Bow bow;
    protected Spear spear;
    protected Staff staff;
    protected Sword sword;

    /**
     * Sets up field, units and weapons to be tested
     */
    @BeforeEach
    public void setUp() {
        setField();
        setTestUnit();
        setTargetUnits();
        setWeapons();
        equipTestUnit();
    }

    /**
     * Equip item to TestUnit
     * */
    protected abstract void equipTestUnit();

    /**
     * Test unit has been correctly equipped
     * */
    @Test
    protected void isEquippedTest(){
        assertTrue(getTestUnit().hasEquippedItem());
    }

    /**
     * Sets up the unit to be tested
     */
    abstract void setTestUnit();

    /**
     * @return the unit to be tested
     */
    abstract IUnit getTestUnit();

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
     * Set up the game field
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
    public void setWeapons() {
        this.axe = new Axe("Axe", 10, 1, 2);
        this.sword = new Sword("Sword", 10, 1, 2);
        this.spear = new Spear("Spear", 10, 1, 2);
        this.staff = new Staff("Staff", 10, 1, 2);
        this.bow = new Bow("Bow", 10, 2, 3);
    }

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
        assertTrue(getTestUnit().isInRange(targetUnit));
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
        attackUnEquippedUnitsTest();
    }

    /**
     * equip target units and checks that all units receives the correct amount of damage after being attacked while equipped with their item.
     */
    @Test
    void equipTargetsAndUseItemOnEquippedTargetUnitsTest() {
        equipTargetUnits();
        attackEquippedUnitsTest();
    }

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
        assertTrue(getTestUnit().isInRange(alpaca));
        assertTrue(getTestUnit().isInRange(archer));
        assertTrue(getTestUnit().isInRange(cleric));
        assertTrue(getTestUnit().isInRange(fighter));
        assertTrue(getTestUnit().isInRange(hero));
        assertTrue(getTestUnit().isInRange(swordMaster));
    }
}
