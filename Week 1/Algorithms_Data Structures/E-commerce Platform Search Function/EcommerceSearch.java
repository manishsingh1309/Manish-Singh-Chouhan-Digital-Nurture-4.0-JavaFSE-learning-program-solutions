import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ProductInfo {
    private int productCode;
    private String productName;
    private String category;

    public ProductInfo(int productCode, String productName, String category) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String toString() {
        return "[" + productCode + " | " + productName + " | " + category + "]";
    }
}

class ProductSearch {

    // Linear Search
    public static ProductInfo linearSearch(ProductInfo[] items, String keyword) {
        for (ProductInfo item : items) {
            if (item.getProductName().equalsIgnoreCase(keyword)) {
                return item;
            }
        }
        return null;
    }

    // Binary Search
    public static ProductInfo binarySearch(ProductInfo[] items, String keyword) {
        int start = 0, end = items.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int compare = keyword.compareToIgnoreCase(items[mid].getProductName());

            if (compare == 0) {
                return items[mid];
            } else if (compare < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    // Sort items alphabetically
    public static void sortProducts(ProductInfo[] items) {
        Arrays.sort(items, Comparator.comparing(p -> p.getProductName().toLowerCase()));
    }
}

// Main class to run the application
public class EcommerceSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductInfo[] catalog = {
            new ProductInfo(101, "Tablet", "Electronics"),
            new ProductInfo(102, "Book", "Stationery"),
            new ProductInfo(103, "Shoes", "Footwear"),
            new ProductInfo(104, "Watch", "Accessories"),
            new ProductInfo(105, "Camera", "Electronics")
        };

        System.out.print("Enter product name to search: ");
        String searchKey = sc.nextLine();

        // Linear Search
        System.out.println("\n🔍 Performing Linear Search...");
        ProductInfo linearResult = ProductSearch.linearSearch(catalog, searchKey);
        System.out.println(linearResult != null ? "Found: " + linearResult : "Product not found.");

        // Sort before Binary Search
        ProductSearch.sortProducts(catalog);

        // Binary Search
        System.out.println("\n📊 Performing Binary Search...");
        ProductInfo binaryResult = ProductSearch.binarySearch(catalog, searchKey);
        System.out.println(binaryResult != null ? "Found: " + binaryResult : "Product not found.");

        sc.close();
    }
}
