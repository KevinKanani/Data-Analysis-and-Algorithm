import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;
    double ratio;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class KnapsackGreedy {

    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item a) -> a.ratio).reversed());

        double totalValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Take the whole item
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Take a fraction of the item
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.ratio * remainingCapacity;
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int knapsackCapacity = 50;

        double maxValue = getMaxValue(items, knapsackCapacity);
        System.out.println("Maximum value achievable: " + maxValue);
    }
}

