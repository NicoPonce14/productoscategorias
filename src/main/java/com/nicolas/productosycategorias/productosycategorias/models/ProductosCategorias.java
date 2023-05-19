package com.nicolas.productosycategorias.productosycategorias.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

// ...
@Entity
@Table(name="productoscategorias")
public class ProductosCategorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Producto product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Categoria category;
    
    public ProductosCategorias() {
        
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Producto getProduct() {
        return this.product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Categoria getCategory() {
        return this.category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
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

