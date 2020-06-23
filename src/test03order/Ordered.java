package test03order;

public class Ordered {
	
	private String Goods_name;
	private String Buyer;
	private String Seller;
	private Integer Num;
	private Integer ID;
	private Double Price;
	
	public Ordered() {}
	Ordered(String Goods_name,String Buyer,String Seller,Integer Num,Integer ID,Double Price){
		this.Goods_name=Goods_name;
		this.Buyer=Buyer;
		this.Seller=Seller;
		this.ID=ID;
		this.Num=Num;
		this.Price=Price;
	}
	//Goods_name
	public String getGoods_name() {
		return Goods_name;
	}
	public void setGoods_name(String Goods_name) {
		this.Goods_name = Goods_name;
	}
	//Buyer
	public String getBuyer() {
		return Buyer;
	}
	public void setBuyer(String Buyer) {
		this.Buyer = Buyer;
	}
	//Seller
	public String getSeller() {
		return Seller;
	}
	public void setSeller(String Seller) {
		this.Seller = Seller;
	}
	//ID
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//Num
	public Integer getNum() {
		return Num;
	}
	public void setNum(Integer Num) {
		this.Num = Num;
	}
	//Price
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
	}
}
