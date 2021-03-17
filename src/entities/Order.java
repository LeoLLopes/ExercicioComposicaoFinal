package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus orderstatus;
	private Client client;
	
	List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus orderstatus, Client client) {
		this.moment = moment;
		this.orderstatus = orderstatus;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem it : items) {
			sum = sum + it.subtotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY: " + "\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order Status: " + orderstatus + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: " + "\n");
		for(OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: ");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
