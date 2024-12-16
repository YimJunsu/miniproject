package model.Dao;

import model.Dto.OrderDto;
import model.Dto.ProductDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDao extends DBDao {

    private static final OrderDao orderDao = new OrderDao();
    private OrderDao(){}
    public static OrderDao getInstance(){return orderDao;}

    //오더 리스트 출력 함수
    public ArrayList<OrderDto> orderList(){
        ArrayList<OrderDto> list = new ArrayList<>();
        try {
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String sql2 = "select * from user";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();

            while (rs.next()&&rs2.next()){
                int noCheck = rs2.getInt("user_no");
                String idCheck = rs2.getString("id");
                int userNo = rs.getInt("user_no_fk");
                int cateNo = rs.getInt("category_no_fk");
                String prName = rs.getString("product_name");
                int prPrice = rs.getInt("price");
                String state = rs.getString("role");
                String board = rs.getString("product_board");

                OrderDto orderDto = new OrderDto(noCheck, idCheck ,userNo, cateNo, prName, prPrice, state, board);
                list.add(orderDto);
            }
        }catch (SQLException e){
            e.getMessage();
        }return list;
    }
}
