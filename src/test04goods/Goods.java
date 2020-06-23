package test04goods;

public class Goods {
	private String Goods_name;
	private String Seller;
	private String Links;
	private String Image;
	private Integer ID;//…Ã∆∑∫≈
	private Double Price;
	
	public Goods() {}
	
	Goods(String Goods_name,String Seller,String Links,String Image,Integer ID,Double Price){
		this.Goods_name=Goods_name;
		this.Seller=Seller;
		this.Links=Links;
		this.Image=Image;
		this.ID=ID;
		this.Price=Price;
	}
	//Goods_name
	public String getGoods_name() {
		return Goods_name;
	}
	public void setGoods_name(String Goods_name) {
		this.Goods_name = Goods_name;
	}
	//Seller
	public String getSeller() {
		return Seller;
	}
	public void setSeller(String Seller) {
		this.Seller = Seller;
	}
	//Links
	public String getLinks() {
		return Links;
	}
	public void setLinks(String Links) {
		this.Links = Links;
	}
	//Image
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}
	//ID
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//Price
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double Price) {
		this.Price = Price;
	}
	
}