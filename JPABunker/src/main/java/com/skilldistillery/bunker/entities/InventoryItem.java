package com.skilldistillery.bunker.entities;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String category;

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "vault_id")
	@JsonIgnore
	private Vault vault;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Vault getVault() {
		return vault;
	}

	public void setVault(Vault vault) {
		this.vault = vault;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", name=" + name + ", category=" + category + ", quantity=" + quantity
				+ ", vault=" + vault + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, quantity, vault);
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
		return category == other.category && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& quantity == other.quantity && Objects.equals(vault, other.vault);
	}

}
