package pr1;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
public @Data class History {
    private List<Order> orders;
    public History() {
        this.orders = new ArrayList<>();
    }

    public void addToHistory(Order order) {
        orders.add(order);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order history:\n");
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }
}