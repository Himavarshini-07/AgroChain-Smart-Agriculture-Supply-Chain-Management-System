import java.util.*;

class Product {
    int id;
    String name;
    int quantity;

    Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}

public class AgroChainSorting {

    static void merge(Product arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Product L[] = new Product[n1];
        Product R[] = new Product[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].quantity <= R[j].quantity)
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    static void mergeSort(Product arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        Product products[] = {
                new Product(101, "Rice", 500),
                new Product(102, "Wheat", 300),
                new Product(103, "Corn", 700),
                new Product(104, "Millet", 200),
                new Product(105, "Sugarcane", 600)
        };

        mergeSort(products, 0, products.length - 1);

        System.out.println("Products Sorted by Quantity:");

        for (Product p : products) {
            System.out.println(
                    p.id + " " +
                    p.name + " " +
                    p.quantity);
        }
    }
}