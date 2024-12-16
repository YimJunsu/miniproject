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

    private ProductDao() {
    }

    public static ProductDao getInstance() {
        return productDao;
    }

    //카테고리 함수
    public ArrayList<ProductDto> categories() {
        ArrayList<ProductDto> list = new ArrayList<>();
        try {
            String sql = "select * from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cateName = rs.getString("category_name");

                ProductDto productDto = new ProductDto(0, cateName);
                list.add(productDto);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return list;
    }
    //[강사]//

    //제품등록함수
    public boolean productAdd(ProductDto productDtoAdd) {
        try {

            String sql = "select * from product (cate_no,pro_name,price,state,board) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productDtoAdd.getCate_no());
            ps.setString(2, productDtoAdd.getPro_name());
            ps.setInt(3, productDtoAdd.getPrice());
            ps.setString(4, productDtoAdd.getState());
            ps.setString(5, productDtoAdd.getBoard());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.getMessage();
        }
        return false;

    }

    //제품 삭제함수
    public boolean productDelete(int deleteNum){
        try {
            String sql="delete from product where pro_no=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,deleteNum);
            int result=ps.executeUpdate();
            if(result==1){
                return true;
            }
        }catch (SQLException e){
            e.getMessage();
        }return false;
    }
}
