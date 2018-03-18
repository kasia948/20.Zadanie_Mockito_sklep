package pl.javastart.exercise.mockito;

import java.util.Map;

public class Shop {
    private MusicPlayer musicPlayer;
    private int money;
    private Map<Item, Integer> stock;

    public Shop(int money, Map<Item, Integer> stock) {
        this.money = money;
        this.stock = stock;
    }


    void playCashSound() {
        musicPlayer.playSound("play");
        /* zakładamy, że ta metoda odtwarza dźwięk https://www.youtube.com/watch?v=Wj_OmtqVLxY, nie musimy jej implementować,
        sprawdzamy tylko czy została uruchomiona */
    }

    public int getStock1(){
        Item item1= new Item ("Piwo", 18, 5, true);
        stock.put(item1, 10);
        return stock.get(item1);
    }

    public boolean hasItem(String itemName) {
        for (Item item : stock.keySet()) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;        // TODO dodaj kod sprawdzający czy sklep ma w asortymencie przedmot o danej nazwie
    }


    public Item findItemByName(String itemName) {
        for (Item item: stock.keySet()){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        // TODO dodaj kod wyszukujący przedmiot po jego nazwie
        return null;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }


    public int setStock1(){
        Item item1= new Item ("Piwo", 18, 5, true);
        stock.put(item1, 10);
        return stock.get(item1);
    }

    public void setStock(Map<Item, Integer> stock) {
        this.stock = stock;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }
}
