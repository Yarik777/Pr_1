package pr1;
import lombok.AllArgsConstructor;
import lombok.Data;
public @AllArgsConstructor @Data class Product{
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;
}