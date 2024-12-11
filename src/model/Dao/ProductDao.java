package model.Dao;

import model.Dto.ProductDto;
import view.MemberView;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao extends DBDao {
    // [강사] MemberView 싱글톤
    private static final ProductDao productDao = new ProductDao();
    private ProductDao() { }
    public static ProductDao getInstance() {
        return productDao;
    }

    //카테고리 출력 함수
    public ArrayList<ProductDto> categories(){
        ArrayList<ProductDto> list = new ArrayList<>();
        try {
            String sql = "select * from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String cateName = rs.getString("category_name");

                ProductDto productDto = new ProductDto( 0 , cateName);
                list.add(productDto);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }return list;
    }
    // 제품 출력 함수
    public ArrayList<ProductDto> products( int user_no_fk ){
        ArrayList<ProductDto> list = new ArrayList<>();
        try {
            String sql1 = "select * from product where user_no_fk = ?";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt( 1 , user_no_fk );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int userNo = rs.getInt("user_no_fk");
                int cateNo = rs.getInt("category_no_fk");
                String prName = rs.getString("product_name");
                int prPrice = rs.getInt("price");
                String state = rs.getString("role");

                ProductDto productDto = new ProductDto(userNo, cateNo, prName, prPrice, state);
                list.add(productDto);
            }
        }catch (SQLException e){
            e.getMessage();
        }return list;
    }

    //제품 등록 함수
    //멤버 회원가입 참고
    public boolean proRegister(ProductDto productDto){
        return true;
    }

    //제품 수정 함수



    //제품 삭제 함수

}
