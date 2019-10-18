package model;

import model.items.IEquipableItem;
import model.items.Staff;
import model.items.magic.DarknessBook;
import model.items.magic.LightBook;
import model.items.magic.SpectralBook;
import model.items.nonMagic.Axe;
import model.items.nonMagic.Bow;
import model.items.nonMagic.Spear;
import model.items.nonMagic.Sword;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;

/**
 * Factory of items. It can create all the weapons of the game.
 *
 * @author Tabita Catalán Muñoz
 * @since 2.0
 */
public class ItemFactory {

    String AXE_KEY = "axe";
    String BOW_KEY = "bow";
    String STAFF_KEY = "staff";
    String SWORD_KEY = "sword";
    String SPEAR_KEY = "spear";
    String DARK_KEY = "darknessBook";
    String LIGHT_KEY = "lightBook";
    String SPECTRAL_KEY = "spectralBook";

    private JSONObject jItems;

    public ItemFactory(){
        parsing();
    }

    public void parsing() {
        // parsing file "recipes.json"
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("src/model/recipes.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // typecasting obj to JSONObject
        jItems = (JSONObject) obj;
    }

    /**
     * Dada una llave (el nombre de un item), devuelve un JSONObject con los atributos de ese item
     * @return JSONObject con atributos del item (name, power, minRange, maxRange)
     * */
    private JSONObject getJsonItem(String keyItem){
         return (JSONObject) jItems.get(keyItem);
    }

    private String getNameItemFromJSON(JSONObject jsonItem){
        return (String) jsonItem.get("name");
    }

    private int getPowerItemFromJSON(JSONObject jsonItem){
        return Integer.parseInt(String.valueOf(jsonItem.get("power")));
    }

    private int getMinRangeItemFromJSON(JSONObject jsonItem){
        return Integer.parseInt(String.valueOf(jsonItem.get("minRange")));
    }

    private int getMaxRangeItemFromJSON(JSONObject jsonItem){
        return Integer.parseInt(String.valueOf(jsonItem.get("maxRange")));
    }


    private IEquipableItem createItem(String itemKey){
        JSONObject jsonBow = getJsonItem(itemKey);
        String name = getNameItemFromJSON(jsonBow);
        int power = getPowerItemFromJSON(jsonBow);
        int minRange = getMinRangeItemFromJSON(jsonBow);
        int maxRange = getMaxRangeItemFromJSON(jsonBow);
        IEquipableItem item;
        switch (itemKey){
            case "axe":
                item = new Axe(name, power, minRange, maxRange);
                break;
            case "bow":
                item = new Bow(name, power, minRange, maxRange);
                break;
            case "spear":
                item = new Spear(name, power, minRange, maxRange);
                break;
            case "staff":
                item = new Staff(name, power, minRange, maxRange);
                break;
            case "sword":
                item = new Sword(name, power, minRange, maxRange);
                break;
            case "darknessBook":
                item = new DarknessBook(name, power, minRange, maxRange);
                break;
            case "lightBook":
                item = new LightBook(name, power, minRange, maxRange);
                break;
            case "spectralBook":
                item = new SpectralBook(name, power, minRange, maxRange);
                break;
            default:
                item = null;
        }
        return item;
    }

    /**
     * @return a common axe
     * */
    public IEquipableItem createAxe() {
        return createItem(AXE_KEY);
    }

    /**
     * @return a common bow
     * */
    public IEquipableItem createBow() {
        return createItem(BOW_KEY);
    }

    /**
     * @return a common spear
     * */
    public IEquipableItem createSpear() {
        return createItem(SPEAR_KEY);
    }

    /**
     * @return a common sword
     * */
    public IEquipableItem createSword() {
        return createItem(SWORD_KEY);
    }

    /**
     * @return a common staff
     * */
    public IEquipableItem createStaff() {
        return createItem(STAFF_KEY);
    }

    /**
     * @return a common darkness book
     * */
    public IEquipableItem createDarknessBook() {
        return createItem(DARK_KEY);
    }

    /**
     * @return a common light book
     * */
    public IEquipableItem createLightBook() {
        return createItem(LIGHT_KEY);
    }

    /**
     * @return a common spectral book
     * */
    public IEquipableItem createSpectralBook() {
        return createItem(SPECTRAL_KEY);
    }
}
