package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pno")
	private int Pno;
	@Column(name = "product_name")
	private String productname;
	@Column(name = "product_prize")
	private int productprize;
	@Column(name = "product_quantity")
	private int productquqntity;

	public Product() {
	}

	public Product(int pno, String productname, int productprize, int productquqntity) {
		super();
		Pno = pno;
		this.productname = productname;
		this.productprize = productprize;
		this.productquqntity = productquqntity;
	}

	public Product(String productname, int productprize, int productquqntity) {
		this.productname = productname;
		this.productprize = productprize;
		this.productquqntity = productquqntity;
	}

	public int getPno() {
		return Pno;
	}

	public void setPno(int Pno) {
		this.Pno = Pno;
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public int getproductprize() {
		return productprize;
	}

	public void setproductprize(int productprize) {
		this.productprize = productprize;
	}

	public int getproductquqntity() {
		return productquqntity;
	}

	public void setproductquqntity(int productquqntity) {
		this.productquqntity = productquqntity;
	}

	@Override
	public String toString() {
		return "Product [Pno=" + Pno + ", productname=" + productname + ", productprize=" + productprize
				+ ", productquqntity=" + productquqntity + "]";
	}
}
