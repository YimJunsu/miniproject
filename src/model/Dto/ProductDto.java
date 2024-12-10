package model.Dto;

public class ProductDto {
    private int cate_no;
    private String cate_name;

    private int pro_no;
    private String pro_name;
    private int price;
    private String state;

    //카테고리 출력 생성자
    public ProductDto(int cate_no, String cate_name) {
        this.cate_no = cate_no;
        this.cate_name = cate_name;
    }

    //제품 등록 생성자
    public ProductDto(int cate_no, String pro_name, int price, String state) {
        this.cate_no = cate_no;
        this.pro_name = pro_name;
        this.price = price;
        this.state = state;
    }
    //제품 출력 생성자

    public ProductDto(int cate_no, int pro_no, String pro_name, int price, String state) {
        this.cate_no = cate_no;
        this.pro_no = pro_no;
        this.pro_name = pro_name;
        this.price = price;
        this.state = state;
    }
    //제품 수정 생성자

    public ProductDto(String pro_name, int price, String state, int pro_no, int cate_no) {
        this.pro_name = pro_name;
        this.price = price;
        this.state = state;
        this.pro_no = pro_no;
        this.cate_no = cate_no;
    }
    //제품 삭제 생성자
    public ProductDto(int pro_no) {
        this.pro_no = pro_no;
    }

    public int getCate_no() {
        return cate_no;
    }

    public void setCate_no(int cate_no) {
        this.cate_no = cate_no;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public int getPro_no() {
        return pro_no;
    }

    public void setPro_no(int pro_no) {
        this.pro_no = pro_no;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
