import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        Seller seller = new Seller("Vasya", 20, 5);           // создание покупателя
        Consumer consumer = new Consumer("Tanya", 20, 3);     // создание продавца
        ArrayList<Item> items = new ArrayList<>();     // список товаров
        ArrayList<Item> wishList = new ArrayList<>();   // список желаний покупателя


        // создание списка товара
        items.add(0, new Item("milk", 55, Category.Food));
        items.add(1, new Item("bread", 35, Category.Food));
        items.add(2, new Item("juice", 105, Category.Water));
        items.add(3, new Item("soap", 105, Category.Hygiene));
        items.add(4, new Item("shampoo", 125, Category.Hygiene));


        // формирование списка товара на складе у продавца
        seller.setItems(items);
        System.out.println("Наличие товара на складе:  " + seller.getItems().toString());


        // запрос от покупателя цены на товар
        System.out.println("стоимость запрашиваемого товара  " + items.get(4) + ":  " + consumer.costOfItem(items.get(4)));


        // создание списка покупок покупателем
        wishList.add(0, new Item("bread", 35, Category.Food));
        wishList.add(1, new Item("juice", 105, Category.Water));
        wishList.add(2, new Item("shampoo", 105, Category.Hygiene));
        wishList.add(3, new Item("butter", 200, Category.Food));
        System.out.println("список желаемых покупок покупателя:  " + (wishList));


        // запрос о наличии товара на складе
        System.out.println("Запрос о наличии товара");
        consumer.isItemsInStorage(seller, wishList);


        // создание корзины покупок
        wishList.remove(3);                         // удаление из списка желаний отсутствующей на складе позиции
        consumer.setBusket(wishList);                       // формирование корзины покупателя
        System.out.println("Корзина покупателя" + consumer.getBusket());


        // запрос общей стоимости товара:
        System.out.println("Всего к оплате:  " + consumer.totalCost(consumer.getBusket()));


        // проверка платежеоспособности покупателя
        consumer.areYouPoor(consumer, seller);


        //  вывод лояльности продавца
        consumer.loyalIndexConsumer(consumer);
        seller.loyalIndexSeller(seller);


    }
}
