package com.skilldistillery.bunker.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String name;
	private String description;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "inventory")
	@JsonIgnoreProperties({"inventory"})
	List<InventoryItem> inventoryItems;

	public List<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<InventoryLog> inventoryLogs;
	
	public Inventory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<InventoryLog> getInventoryLogs() {
		return inventoryLogs;
	}

	public void setInventoryLogs(List<InventoryLog> inventoryLogs) {
		this.inventoryLogs = inventoryLogs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, description, id, inventoryLogs, name, updatedAt, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(inventoryLogs, other.inventoryLogs)
				&& Objects.equals(name, other.name) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", user=" + user + ", name=" + name + ", description=" + description
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", inventoryLogs=" + inventoryLogs + "]";
	}


}
