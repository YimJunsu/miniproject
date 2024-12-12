package model.Dao;

import model.Dto.ShopDto;

import java.sql.*;
import java.util.ArrayList;

public class ShopDao {
    private Connection conn;

    private static final ShopDao shopDao = new ShopDao();

    private ShopDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root", "1234");
            System.out.println("[ ShopDB Connection OK ]");
        }catch ( ClassNotFoundException e ){
            e.getMessage(); System.out.println("[ ShopDB Connection fail ]");
            // 실패이유 : 1. 프로젝트내 JDBC 라이브러리 등록 2. 오타(클래스경로,DB서버경로) 체크 3. MYSQL 워크벤치에서 DB 존재 체크
        }catch( SQLException e ){
            e.getMessage(); System.out.println("[ ShopDB Connection fail ]");
        }
    }

    public static ShopDao getInstance(){
        return shopDao;
    }

    public int register(ShopDto shopDto) {
        try {
            String sql = "insert into user (id, pwd, phone_no) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            try {
                ps.setString(1, shopDto.getId());
                int password = Integer.parseInt(shopDto.getPwd());
                ps.setInt(2, password);
                ps.setInt(3, shopDto.getPhnum());
                ps.executeUpdate();
            } catch (NumberFormatException e){
                System.err.println("Error : " + e.getMessage());
                return 4; //비밀번호 타입 오류
            }
            return 6;
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062){
                if (errorMessage.contains("id")){
                    System.err.println("Error : " + errorMessage);
                    return 1; //아이디 중복
                } else if (errorMessage.contains("phone_no")) {
                    System.err.println("Error : " + errorMessage);
                    return 2; //연락처 중복
                }
            } else if (e.getSQLState().equals("22001")) {
                System.err.println("Error : " + errorMessage);
                return 3; //id길이 초과
            } else {
                System.err.println("Error" + errorMessage);
            }
            return 5;  //기타 오류
        }
    }

    public boolean login(ShopDto shopDto) {
        String sql = "select * from user where id = ? and pwd = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, shopDto.getId());
            int password = Integer.parseInt(shopDto.getPwd());
            ps.setInt(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                System.out.println("[아이디 또는 비밀번호가 잘못되었습니다]");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    //카테고리 함수
    public ArrayList<ShopDto> categories(){
        ArrayList<ShopDto> list = new ArrayList<>();
        try {
            String sql = "select * from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String cateName = rs.getString("category_name");

                ShopDto shopDto = new ShopDto(cateName);
                list.add(shopDto);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }return list;
    }

    //상품추가 함수
    public boolean productAdd(ShopDto productAddDto) {
        String sql = "insert into product(prname,price,state)values(?,?,?)";
    }
}