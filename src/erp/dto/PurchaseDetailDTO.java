package erp.dto;

public class PurchaseDetailDTO {
	private String purchase_id;
	private String detail_num;
	private String prd_code;
	private String prd_name;
	private String standard;
	private int  count;
	private int  price;
	private int  supplyvalue;
	private int  vat;
	private int totalprice;
	private String clientcode;
	public PurchaseDetailDTO(){
		
	}
	public PurchaseDetailDTO(String purchase_id, String detail_num,
			String prd_code, String prd_name, String standard, int count,
			int price, int supplyvalue, int vat, int totalprice,
			String clientcode) {
		super();
		this.purchase_id = purchase_id;
		this.detail_num = detail_num;
		this.prd_code = prd_code;
		this.prd_name = prd_name;
		this.standard = standard;
		this.count = count;
		this.price = price;
		this.supplyvalue = supplyvalue;
		this.vat = vat;
		this.totalprice = totalprice;
		this.clientcode = clientcode;
	}
	public String getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getDetail_num() {
		return detail_num;
	}
	public void setDetail_num(String detail_num) {
		this.detail_num = detail_num;
	}
	public String getPrd_code() {
		return prd_code;
	}
	public void setPrd_code(String prd_code) {
		this.prd_code = prd_code;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
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
	public int getSupplyvalue() {
		return supplyvalue;
	}
	public void setSupplyvalue(int supplyvalue) {
		this.supplyvalue = supplyvalue;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getClientcode() {
		return clientcode;
	}
	public void setClientcode(String clientcode) {
		this.clientcode = clientcode;
	}
	@Override
	public String toString() {
		return "PurchaseDetailDTO [purchase_id=" + purchase_id
				+ ", detail_num=" + detail_num + ", prd_code=" + prd_code
				+ ", prd_name=" + prd_name + ", standard=" + standard
				+ ", count=" + count + ", price=" + price + ", supplyvalue="
				+ supplyvalue + ", vat=" + vat + ", totalprice=" + totalprice
				+ ", clientcode=" + clientcode + "]";
	}
	
}
