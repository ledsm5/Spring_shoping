package Model;


public class GoodsDTO {
	String ctgr;
	Long prodNum;
	String prodName;
	Long prodPrice;
	String prodCapacity;
	String prodSupplyer;
	Long prodDelFee;
	String recommand;
	String prodDetail;
	String prodImage;
	String employeeId;
	
	
	
	StartEndPageDTO startEndPageDTO;
	
	public StartEndPageDTO getStartEndPageDTO() {
		return startEndPageDTO;
	}
	public void setStartEndPageDTO(StartEndPageDTO startEndPageDTO) {
		this.startEndPageDTO = startEndPageDTO;
	}
	
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCtgr() {
		return ctgr;
	}
	public void setCtgr(String ctgr) {
		this.ctgr = ctgr;
	}

	public Long getProdNum() {
		return prodNum;
	}
	public void setProdNum(Long prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Long getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdCapacity() {
		return prodCapacity;
	}
	public void setProdCapacity(String prodCapacity) {
		this.prodCapacity = prodCapacity;
	}
	public String getProdSupplyer() {
		return prodSupplyer;
	}
	public void setProdSupplyer(String prodSupplyer) {
		this.prodSupplyer = prodSupplyer;
	}
	public Long getProdDelFee() {
		return prodDelFee;
	}
	public void setProdDelFee(Long prodDelFee) {
		this.prodDelFee = prodDelFee;
	}
	public String getRecommand() {
		return recommand;
	}
	public void setRecommand(String recommand) {
		this.recommand = recommand;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	
}
