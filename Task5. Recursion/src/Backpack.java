import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Item> backpackItems = null;
    private int maxW;

    public int getBestPrice() {
        return bestPrice;
    }

    private int bestPrice;

    public Backpack(int maxWeight)
    {
        maxW = maxWeight;
    }

    public int calcWeigth(List<Item> items)
    {
        int summW = 0;

        for(Item i : items)
        {
            summW += i.getWeigth();
        }

        return summW;
    }

    public int calcPrice(List<Item> items)
    {
        int sumPrice = 0;
        for (Item i : items)
        {
            sumPrice += i.getPrice();
        }
        return sumPrice;
    }

    private void checkSet(List<Item> items)
    {
        if (backpackItems == null)
        {
            if (calcWeigth(items) <= maxW)
            {
                backpackItems = items;
                bestPrice = calcPrice(items);
            }
        }
        else
        {
            if(calcWeigth(items) <= maxW && calcPrice(items) > bestPrice )
            {
                backpackItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    public void makeSets(List<Item> items)
    {
        if (items.size() > 0) checkSet(items);
        
        for (int i = 0; i < items.size() ; i++)
        {
            ArrayList<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeSets(newSet);
        }

    }

    public List<Item> getItems()
    {
        return backpackItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Backpack items { ");
        for (Item i : backpackItems) {
            sb.append(i.getName() + ", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
