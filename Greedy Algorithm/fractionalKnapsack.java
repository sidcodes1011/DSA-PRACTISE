
import java.util.Vector;
public class fractionalKnapsack {    
    public static void main(String[] args) {   
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};  
        int capacity = 50;
        double result = fractionalKnapsackOp (val,wt,capacity);
        System.out.println("Total cost ::: " + result);
    }
    public static double fractionalKnapsackOp(int[] val, int[] wt, int capacity) {

        Vector<Vector<Double>> items = new Vector<>();
        for (int i = 0; i < val.length; i++) {
            Vector<Double> pair = new Vector<>();
            pair.add((double) val[i]);                 
            pair.add((double) wt[i]);                  
            pair.add((double) val[i] / wt[i]);       
            items.add(pair);
        }
        items.sort((a, b) -> {
        return Double.compare(b.get(2), a.get(2));
        });  
        System.out.println("knapsack vector ::: " + items);

        double totalCost = 0.0;
        for (int i = 0; i < items.size(); i++) {
            double value = items.get(i).get(0);
            double weight = items.get(i).get(1);
            if (capacity >= weight) {
                totalCost +=  value;
                capacity -=   weight;
            } else {
                totalCost += capacity * (value / weight);
                break;
            }
        }
            totalCost = Math.round(totalCost * 1000000.0) / 1000000.0;
        return totalCost;
    }
}