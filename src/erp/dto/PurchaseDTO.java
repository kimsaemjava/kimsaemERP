package erp.dto;

public class PurchaseDTO {
	private String purchase_id;
	private String purchase_day;
	private String request_id;
	private String request_dept;
	private String state;
	private String type;
	public PurchaseDTO(){
		
	}
	public PurchaseDTO(String purchase_id, String purchase_day,
			String request_id, String request_dept, String state, String type) {
		super();
		this.purchase_id = purchase_id;
		this.purchase_day = purchase_day;
		this.request_id = request_id;
		this.request_dept = request_dept;
		this.state = state;
		this.type = type;
	}
	public String getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getPurchase_day() {
		return purchase_day;
	}
	public void setPurchase_day(String purchase_day) {
		this.purchase_day = purchase_day;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getRequest_dept() {
		return request_dept;
	}
	public void setRequest_dept(String request_dept) {
		this.request_dept = request_dept;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PurchaseDTO [purchase_id=" + purchase_id + ", purchase_day="
				+ purchase_day + ", request_id=" + request_id
				+ ", request_dept=" + request_dept + ", state=" + state
				+ ", type=" + type + "]";
	}
	
}
