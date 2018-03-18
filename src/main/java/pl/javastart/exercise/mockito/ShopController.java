package pl.javastart.exercise.mockito;

public class ShopController {
    private Shop shop;

    public ShopController(ShopRepository shopRepository) {
        shop = shopRepository.findShop();

    }

    public void sellItem(Human human, String itemName) {

        if (shop.hasItem(itemName)) {
            Item item = shop.findItemByName(itemName);
            if (item.getAgeRestriction() > human.getAge()) {
                throw new TooYoungException();
            }else if (!item.isLegal()&&human.getJob().equals("Policjant")){
                System.out.println("Przykro nam, nie mamy takiego produktu");
            }else if(item.getPrice()>human.getMoney()){
                System.out.println("Przkro nam, nie ma pan wystarczającej ilości pieniędzy");
            }else {
                shop.playCashSound();
                human.setMoney(human.getMoney()-item.getPrice());
                shop.setMoney(shop.getMoney()+item.getPrice());
//                shop.setStock1(itemName,  shop.getStock1()-1);
            }

        } else {

            // TODO sklep nie ma danego przedmiotu, wyrzuć wyjątek OutOfStockException
        }

    }

}
