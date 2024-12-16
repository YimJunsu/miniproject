package model.Dao;

import model.Dto.ProductDto;

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
            String sql = "select * from category order by category_no";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int cateNo = rs.getInt("category_no");
                String cateName = rs.getString("category_name");

                ProductDto productDto = new ProductDto(cateNo, cateName);
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
            String sql = "select * from product where user_no_fk = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, user_no_fk );
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int userNo = rs.getInt("user_no_fk");
                int cateNo = rs.getInt("category_no_fk");
                String prName = rs.getString("product_name");
                int prPrice = rs.getInt("price");
                String state = rs.getString("role");
                String board = rs.getString("product_board");

                ProductDto productDto = new ProductDto(userNo, cateNo, prName, prPrice, state, board);
                list.add(productDto);
            }
        }catch (SQLException e){
            e.getMessage();
        }return list;
    }

    //제품 등록 함수
    public boolean productAdd(ProductDto productDto) {
        try {
            String sql = "insert into product (product_name, price, product_board, role, category_no_fk, user_no_fk) values (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productDto.getPro_name());
            ps.setInt(2, productDto.getPrice());
            ps.setString(3, productDto.getBoard());
            ps.setString(4, productDto.getState());
            ps.setInt(5, productDto.getCate_no());
            ps.setInt(6, productDto.getUser_no_fk());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.print("[에러 : " + e.getMessage() + " ]");
            return false;
        }
    }
    //제품 수정 함수



    //제품 삭제 함수
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

    public boolean productUpdate(ProductDto productDtoUpdate){
        try {
            String sql="update product set name=?,price=?,state? where pro_num=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,productDtoUpdate.getPro_name());
            ps.setInt(2,productDtoUpdate.getPrice());
            ps.setString(3,productDtoUpdate.getState());
            ps.setInt(4,productDtoUpdate.getPro_no());
            int result= ps.executeUpdate();
            if (result==1){
                return true;
            }
        }catch (SQLException e){
            e.getMessage();
        }return false;

    }

}
