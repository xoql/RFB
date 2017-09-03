package com.javalec.tea_pjt.model.shop.dto;

import java.util.Date;

public class OrdersDTO {
	
	private int order_id;
	private String userid;
	private int product_id;
	private int amount;
	private int order_total;
	private Date order_date;
	private int ordered_total;
	private String address;
	private int free;
	
	
	private String product_name;
	private int price;
	private int count;
	private int money;
	
	
	
	
	
	
	
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOrdered_total() {
		return ordered_total;
	}
	public void setOrdered_total(int ordered_total) {
		this.ordered_total = ordered_total;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrder_total() {
		return order_total;
	}
	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "OrdersDTO [order_id=" + order_id + ", userid=" + userid + ", product_id=" + product_id + ", amount="
				+ amount + ", order_total=" + order_total + ", order_date=" + order_date + ", ordered_total="
				+ ordered_total + ", address=" + address + ", free=" + free + ", product_name=" + product_name
				+ ", price=" + price + ", count=" + count + "]";
	}
	
	


	

	
	
	

}
