package model.combat;

import model.items.*;
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
     * testUnit uses it's item on targetUnit
     * @param expectedLife: targetUnit's HP expected after the use of the item
     * @param targetUnit: object unit of the attack
     */
    public void useItemOnUnitTest(int expectedLife, IUnit targetUnit){
        assertTrue(getTestUnit().isInRange(targetUnit));
        getTestUnit().useEquippedItemOn(targetUnit);
        assertEquals(expectedLife, targetUnit.getCurrentHitPoints());
    }

    /**
     * testUnit uses it's item to attack targetUnit
     */
    public void attackUnitsTest(){
        useItemOnUnitTest(40, alpaca);
        useItemOnUnitTest(40, archer);
        useItemOnUnitTest(40, cleric);
        useItemOnUnitTest(40, fighter);
        useItemOnUnitTest(40, hero);
        useItemOnUnitTest(40, swordMaster);
    }

    /**
     * testUnit uses it's item to heal targetUnit
     */
    public void healUnitsTest(){
        useItemOnUnitTest(60, alpaca);
        useItemOnUnitTest(60, archer);
        useItemOnUnitTest(60, cleric);
        useItemOnUnitTest(60, fighter);
        useItemOnUnitTest(60, hero);
        useItemOnUnitTest(60, swordMaster);
    }

    @Test
    abstract void useItemOnAllTargetUnitsTest();

    @Test
    public void distanceTest(){
        assertEquals(2, getTestUnit().distanceTo(alpaca));
        assertEquals(2, getTestUnit().distanceTo(archer));
        assertEquals(2, getTestUnit().distanceTo(cleric));
        assertEquals(2, getTestUnit().distanceTo(fighter));
        assertEquals(2, getTestUnit().distanceTo(hero));
        assertEquals(2, getTestUnit().distanceTo(swordMaster));
    }

    @Test
    public void isInRangeTest(){
        assertTrue(getTestUnit().isInRange(alpaca));
    }
}
