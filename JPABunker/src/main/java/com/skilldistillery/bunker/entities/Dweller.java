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
@Table(name = "dweller")
public class Dweller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String role;
    

    @ManyToOne
    @JoinColumn(name = "vault_id", nullable = false)
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Vault getVault() {
		return vault;
	}


	public void setVault(Vault vault) {
		this.vault = vault;
	}


	@Override
	public String toString() {
		return "Dweller [id=" + id + ", name=" + name + ", age=" + age + ", role=" + role + ", vault=" + vault + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, role, vault);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dweller other = (Dweller) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role) && Objects.equals(vault, other.vault);
	}
    
    
}
