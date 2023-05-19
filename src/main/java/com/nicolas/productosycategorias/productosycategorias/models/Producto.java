package com.nicolas.productosycategorias.productosycategorias.models;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

// ...
@Entity
@Table(name="products")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo name no debe estar vacio")
    private String name;
    @NotBlank(message = "Campo description no debe estar vacio")
    private String description;
    
    private double price;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "productoscategorias", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Categoria> categories;
    
    public Producto() {
        
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Categoria> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Categoria> categories) {
        this.categories = categories;
    }

    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    // ...
    // getters y setters removidos para resumir
    // ...
}


