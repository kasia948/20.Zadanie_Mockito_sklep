package pl.javastart.exercise.mockito;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void shouldHaveItem() {
        //given
        Map<Item, Integer> stock = new HashMap<>();
        Item chleb = new Item("Chleb", 0, 2, true);
        stock.put(chleb, 5);
        Shop shop = new Shop(0, stock);
        //when
        boolean itemExists = shop.hasItem("Chleb");
        //then
        assertThat(itemExists, is(true));
    }

    @Test
    public void shouldHaveNotItem() {
        //given
        Map<Item, Integer> stock = new HashMap<>();
        Item chleb = new Item("Chleb", 0, 2, true);
        stock.put(chleb, 5);
        Shop shop = new Shop(0, stock);
        //when
        boolean itemExists = shop.hasItem("");
        //then
        assertThat(itemExists, is(false));
    }


    @Test
    public void shouldReturnItembyName() {
        //given
        Map<Item, Integer> stock = new HashMap<>();
        Item chleb = new Item("Chleb", 0, 2, true);
        Item papierosy = new Item("Papierosy", 18, 15, true);
        stock.put(chleb, 5);
        stock.put(papierosy,10);
        Shop shop = new Shop(0, stock);
        //when
        Item item = shop.findItemByName("Chleb");
        Item item2 = shop.findItemByName("Papierosy");
        //then
        assertThat(item.getName(), is("Chleb"));
        assertThat(item.getAgeRestriction(), is(0));
        assertThat(item.getPrice(), is(2));
        assertThat(item.isLegal(),is(true));
        assertThat(item2.getName(), is("Papierosy"));
        assertThat(item2.getAgeRestriction(), is(18));
        assertThat(item2.getPrice(), is(15));
        assertThat(item2.isLegal(),is(true));
    }

}