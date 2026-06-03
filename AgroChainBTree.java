import java.util.TreeSet;

public class AgroChainBTree {

    public static void main(String[] args) {

        TreeSet<Integer> products = new TreeSet<>();

        // Product IDs
        products.add(105);
        products.add(120);
        products.add(95);
        products.add(110);
        products.add(130);

        System.out.println("AGROCHAIN PRODUCT MANAGEMENT");
        System.out.println("----------------------------");

        System.out.println("Stored Product IDs:");
        System.out.println(products);

        int searchId = 110;

        if(products.contains(searchId))
            System.out.println("Product ID " + searchId + " Found");
        else
            System.out.println("Product Not Found");
    }
}