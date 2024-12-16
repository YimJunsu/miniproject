package model.Dto;

public class OrderDto {
    private int noCheck;
    private String idCheck;

    private int user_no_fk;

    private int cate_no;
    private String cate_name;

    private int pro_no;
    private String pro_name;
    private int price;
    private String state;
    private String time;
    private String board;

    //
    public OrderDto(int noCheck, String idCheck, int userNo, int cateNo, String prName, int prPrice, String state, String board) {
        this.noCheck = noCheck;
        this.idCheck = idCheck;
        this.user_no_fk = userNo;
        this.cate_no = cateNo;
        this.pro_name = prName;
        this.price = prPrice;
        this.state = state;
        this.board = board;
    }

    public int getNoCheck() {
        return noCheck;
    }

    public void setNoCheck(int noCheck) {
        this.noCheck = noCheck;
    }

    public String getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(String idCheck) {
        this.idCheck = idCheck;
    }

    public int getUser_no_fk() {
        return user_no_fk;
    }

    public void setUser_no_fk(int user_no_fk) {
        this.user_no_fk = user_no_fk;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
}


