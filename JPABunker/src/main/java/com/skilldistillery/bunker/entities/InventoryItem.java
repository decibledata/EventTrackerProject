package com.skilldistillery.bunker.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

	private String name;
	private int quantity;
	private String unit;
	private LocalDateTime expiration;
	private LocalDateTime addedAt;

	@ManyToMany
	@JoinTable(name = "item_has_category", joinColumns = @JoinColumn(name = "inventory_item_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public LocalDateTime getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDateTime expiration) {
		this.expiration = expiration;
	}

	public LocalDateTime getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addedAt, categories, expiration, id, inventory, name, quantity, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItem other = (InventoryItem) obj;
		return Objects.equals(addedAt, other.addedAt) && Objects.equals(categories, other.categories)
				&& Objects.equals(expiration, other.expiration) && id == other.id
				&& Objects.equals(inventory, other.inventory) && Objects.equals(name, other.name)
				&& quantity == other.quantity && Objects.equals(unit, other.unit);
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", inventory=" + inventory + ", name=" + name + ", quantity=" + quantity
				+ ", unit=" + unit + ", expiration=" + expiration + ", addedAt=" + addedAt + ", categories="
				+ categories + "]";
	}

}
