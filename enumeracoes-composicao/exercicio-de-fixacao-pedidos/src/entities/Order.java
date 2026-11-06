package entities;

import enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    OrderStatus status;

    List<OrderItem> items = new ArrayList<>();
    Client client;

    public Order() {
    }

    public Order(Client client, OrderStatus status) {
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: " + moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        sb.append("\nOrder status: " + status.toString());
        sb.append("\nClient: " + client.toString());
        sb.append("\nOrder items: \n");
        for (OrderItem item : items) {
            sb.append(item.toString() + "\n");
        }
        sb.append("Total price: " + String.format("%.2f", total()));
        return sb.toString();

    }

}
