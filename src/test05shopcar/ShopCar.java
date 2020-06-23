package test05shopcar;

public class ShopCar {
	private int goods_id;
	private String goods_name;
	private int goods_num;
	private double price;
	private String buyer;
	private String seller;
	
	public ShopCar() {}
	
	ShopCar(int goods_id, String goods_name, int goods_num, double price, String buyer,String seller)
	{
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_num = goods_num;
		this.price = price;
		this.buyer = buyer;
		this.seller = seller;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
}
