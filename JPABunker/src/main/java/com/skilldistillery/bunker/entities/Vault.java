package com.skilldistillery.bunker.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vault")
public class Vault {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String location;


	private String status;

	@OneToOne(mappedBy = "vault", cascade = CascadeType.ALL)
	private Overseer overseer;

	@OneToMany(mappedBy = "vault", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Dweller> dwellers = new ArrayList<>();

	@OneToMany(mappedBy = "vault", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InventoryItem> inventory = new ArrayList<>();

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Overseer getOverseer() {
		return overseer;
	}

	public void setOverseer(Overseer overseer) {
		this.overseer = overseer;
	}

	public List<Dweller> getDwellers() {
		return dwellers;
	}

	public void setDwellers(List<Dweller> dwellers) {
		this.dwellers = dwellers;
	}

	public List<InventoryItem> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryItem> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Vault [id=" + id + ", name=" + name + ", location=" + location + ", status=" + status + ", overseer="
				+ overseer + ", dwellers=" + dwellers + ", inventory=" + inventory + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dwellers, id, inventory, location, name, overseer, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vault other = (Vault) obj;
		return Objects.equals(dwellers, other.dwellers) && Objects.equals(id, other.id)
				&& Objects.equals(inventory, other.inventory) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(overseer, other.overseer)
				&& Objects.equals(status, other.status);
	}
	
	

}
