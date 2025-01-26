package com.skilldistillery.bunker.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prepper_order")
public class PrepperOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private InventoryLog inventory;
	
	private LocalDateTime orderDate;
	
	private int quantity;
	
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public InventoryLog getInventory() {
		return inventory;
	}

	public void setInventory(InventoryLog inventory) {
		this.inventory = inventory;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, inventory, orderDate, quantity, status, supplier);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrepperOrder other = (PrepperOrder) obj;
		return id == other.id && Objects.equals(inventory, other.inventory)
				&& Objects.equals(orderDate, other.orderDate) && quantity == other.quantity
				&& Objects.equals(status, other.status) && Objects.equals(supplier, other.supplier);
	}

	@Override
	public String toString() {
		return "PrepperOrder [id=" + id + ", supplier=" + supplier + ", inventory=" + inventory + ", orderDate="
				+ orderDate + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
	
}
