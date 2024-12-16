package view;

import controller.OrderController;
import controller.ProductController;
import model.Dto.OrderDto;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView {
    private static final OrderView orderviwe = new OrderView();

    private OrderView(){}

    public static OrderView getInstance(){return orderviwe;}

    Scanner scan = new Scanner(System.in);

    public void orderList(){
        ArrayList<OrderDto> list = OrderController.getInstance().orderList();
        System.out.println("판매 제품 목록");
        for (int i=0;i<list.size();i++){
            String name = "판매자아이디 초기화전";
            if (list.get(i).getNoCheck() == list.get(i).getUser_no_fk()){
                name = list.get(i).getIdCheck();
            }
            int j =1;
            System.out.println("[ " + j + " ] ");
            System.out.print("[ 닉네임 : "); System.out.print(name); System.out.println(" ]");
            System.out.print("[ 제품명 : "); System.out.print(list.get(i).getPro_name()); System.out.println(" ]");
            System.out.print("[ 가격 : "); System.out.print(list.get(i).getPrice()); System.out.println(" ]");
            System.out.print("[ 상태 : "); System.out.print(list.get(i).getState()); System.out.println(" ]");
            System.out.print("[ 상세내용 : "); System.out.print(list.get(i).getBoard()); System.out.println(" ]");
            System.out.println("----------------------------------------------------------------");
            j++;
        }
    }
}
