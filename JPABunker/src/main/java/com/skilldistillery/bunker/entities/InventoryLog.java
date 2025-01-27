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
@Table(name = "inventory_log")
public class InventoryLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private LocalDateTime timestamp;
	private String notes;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, inventory, notes, timestamp, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryLog other = (InventoryLog) obj;
		return id == other.id && Objects.equals(inventory, other.inventory) && Objects.equals(notes, other.notes)
				&& Objects.equals(timestamp, other.timestamp) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "InventoryLog [id=" + id + ", inventory=" + inventory + ", user=" + user + ", timestamp=" + timestamp
				+ ", notes=" + notes + "]";
	}

}