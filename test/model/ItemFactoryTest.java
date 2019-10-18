package model;

import model.items.IEquipableItem;
import model.items.nonMagic.Axe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests the class ItemFactory
 * @author Tabita Catalán Muñoz
 * @since v2.0
 */

public class ItemFactoryTest {

    private ItemFactory factory;

    @BeforeEach
    public void setUp() {
        setUpFactory();
    }

    protected void setUpFactory(){
        factory = new ItemFactory();
    }

    @Test
    protected void testItemsCreation(){
        testAxeCreation("Battle Axe", 10, 1,2);
        testBowCreation("Long Bow", 10, 2, 3);
        testSpearCreation("Spear", 10, 1, 2);
        testStaffCreation("Staff", 10, 1, 2);
        testSwordCreation("Sword", 10, 1, 2);
        testDarknessBookCreation("Darkness Book", 10, 1, 2);
        testLightBookCreation("Light Book", 10, 1, 2);
        testSpectralBookCreation("Spectral Book", 10, 1, 2);
    }

    private void testCreationOfAnItem(IEquipableItem anItem, String name, int power, int minRange, int maxRange){
        assertEquals(name, anItem.getName());
        assertEquals(power, anItem.getPower());
        assertEquals(minRange, anItem.getMinRange());
        assertEquals(maxRange, anItem.getMaxRange());
    }

    private void testAxeCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createAxe();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testBowCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createBow();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testSpearCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createSpear();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testSwordCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createSword();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testStaffCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createStaff();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testDarknessBookCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createDarknessBook();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testLightBookCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createLightBook();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

    private void testSpectralBookCreation(String name, int power, int minRange, int maxRange) {
        IEquipableItem anAxe = factory.createSpectralBook();
        testCreationOfAnItem(anAxe, name, power, minRange, maxRange);
    }

}
