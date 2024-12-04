package model.Dao;  // 우현서 코드 작성중

import model.Dto.ShopDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopDao {
    private Connection conn;
    private ShopDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root", "1234");
            System.out.println("[ ShopDB Connection OK ]");
        }catch ( ClassNotFoundException e ){
            e.getMessage(); System.out.println("[ BoardDB Connection fail ]");
            // 실패이유 : 1. 프로젝트내 JDBC 라이브러리 등록 2. 오타(클래스경로,DB서버경로) 체크 3. MYSQL 워크벤치에서 DB 존재 체크
        }catch( SQLException e ){
            e.getMessage(); System.out.println("[ BoardDB Connection fail ]");
        }
    }

    public boolean register(ShopDto shopDto) {
        try {
            String sql = "insert into user (id, pwd, phone_no) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ShopDto.getId());
            ps.setInt(2, ShopDto.getPwd());
            ps.setInt(3, ShopDto.getPhnum());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("[회원가입 실패]");
        }
        return false;
    }
    
}
