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
	private int inventory_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private int user_id;
	
	private LocalDateTime timestamp;
	
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return Objects.hash(id, inventory_id, notes, timestamp, user_id);
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
		return id == other.id && inventory_id == other.inventory_id && Objects.equals(notes, other.notes)
				&& Objects.equals(timestamp, other.timestamp) && user_id == other.user_id;
	}

	@Override
	public String toString() {
		return "InventoryLog [id=" + id + ", inventory_id=" + inventory_id + ", user_id=" + user_id + ", timestamp="
				+ timestamp + ", notes=" + notes + "]";
	}
	
	

}
