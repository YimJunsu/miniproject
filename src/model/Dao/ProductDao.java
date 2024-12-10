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

    //카테고리 함수
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
    //[강사]//
}
