package pr1;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        History orderHistory = new History();
        List<Product> productList = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        Category electronics = new Category(1,"Electronics");
        Category smartphones = new Category(2,"Smartphones");
        Category accessories = new Category(3,"Accessories");
        categoryList.add(electronics);
        categoryList.add(smartphones);
        categoryList.add(accessories);
        Product product1 = new Product(1,"Laptop",19999.99,"Higher end laptop for work and gaming",electronics);
        Product product2 = new Product(2,"Smartphone",12999.50,"Smartphone with a big screen...",smartphones);
        Product product3 = new Product(3,"Headphones",2499.00,"Wireless headphones with muffling",accessories);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - View Item List");
            System.out.println("2 - Add Item to Cart");
            System.out.println("3 - View Cart");
            System.out.println("4 - Clear Cart");
            System.out.println("5 - Search Item/Category");
            System.out.println("6 - View Order History");
            System.out.println("7 - Place Order");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);

                    break;
                case 2:
                    System.out.println("Enter ID of item to add to the cart:");
                    int id = scanner.nextInt();

                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Item with selected ID could not be found.");

                    break;
                case 3:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("The cart is empty!");
                    } else {
                        System.out.println(cart);
                    }
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("The cart is already empty!");
                    } else {
                        cart.clear();
                        System.out.println("Cart emptied.");
                    }
                    break;
                case 5:
                    scanner.nextLine(); //stupid fix
                    System.out.println("Input search: ");
                    String search = scanner.nextLine();
                    String result = "Found ";
                    boolean flag = false;

                    for(Category c : categoryList ){
                        if(search.toLowerCase().equals(c.getName().toLowerCase())){
                            result += "Category: " + c.getName();
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        for(Product p : productList ){
                            if(search.toLowerCase().equals(p.getName().toLowerCase())){
                                result += "Product: " + p.getName();
                                flag = true;
                                break;
                            }
                        }
                    }

                    if(flag == true){
                        System.out.println(result);
                    }
                    else{
                        System.out.println("No category or item could be found with the search '" + search + "'");
                    }
                    break;
                case 6:
                    System.out.println(orderHistory.toString());
                    break;
                case 7:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("The cart is empty. Please add items before placing an order.");
                    } else {
                        Order order = new Order(cart);
                        System.out.println("Order placed!");
                        System.out.println(order);
                        orderHistory.addToHistory(order);
                        cart.clear();
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using our store!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown option. Please try again.");

                    break;
            }
        }
    }
}