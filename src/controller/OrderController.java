package controller;

import model.Dao.OrderDao;
import model.Dto.OrderDto;

import java.util.ArrayList;

public class OrderController {
    private static final OrderController ordercontroller = new OrderController();
    private OrderController(){};
    public static OrderController getInstance(){return ordercontroller;}

    //오더 제품 목록
    public ArrayList<OrderDto> orderList(){
        ArrayList<OrderDto> result = OrderDao.getInstance().orderList();
        return result;
    }
    //오더 쪽지



}
