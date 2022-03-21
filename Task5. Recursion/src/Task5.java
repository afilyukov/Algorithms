import java.util.ArrayList;
import java.util.List;

public class Task5 {

    static int[] cost = new int[] {548, 154, 367, 451, 117};
    static int[] weight = new int[] {7, 5, 9, 1, 20};
    static int backpackVolume = 25;

    public static void main(String[] args) {
        //task1
        System.out.println("Возведение в степень рекурсией 2^-2: "  + recursionPower(2, -2));
        //task2
        //System.out.print("Ì: ");
        //System.out.println(backpack(cost.length - 1, backpackVolume));
        List<Item> items = new ArrayList<>();

        items.add(new Item("Чайник", 1, 600));
        items.add(new Item("Гантеля", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Телевизор", 7, 45000));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Гвозди", 1, 50000));

        Backpack bp = new Backpack(15);
        bp.makeSets(items);

        if(bp.getItems() == null)
        {
            System.out.println("Нет решения!");
        }
        else
        {
            System.out.println(bp.toString());
            System.out.println(bp.getBestPrice());
        }
    }

    static double recursionPower(int i, int n) {
        if (n == 1) {
            return i;
        }
        if (n == 0) {
            return 1;
        }
        if (n>0) { return recursionPower(i, n - 1) * i;}
        else {return 1 / (i* recursionPower(i, -n-1));}
    }

    private static int backpack(int i, int _backpackVolume) {
        if (i < 0) {
            return 0;
        }
        if (weight[i] > _backpackVolume) {
            return backpack(i-1, _backpackVolume);
        } else {
            return Math.max(backpack(i-1, _backpackVolume), backpack(i-1, _backpackVolume - weight[i]) + cost[i]);
        }
    }


}
