package view;

import controller.ProductController;
import model.Dto.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {

    // [강사] MemberView 싱글톤
    private static final ProductView productView = new ProductView();
    private ProductView() { }
    public static ProductView getInstance() {
        return productView;
    }
    // [강사] 입력 객체
    Scanner scan = new Scanner(System.in);

    //void 카테고리 함수
    public void categoris(){
        ArrayList<ProductDto> result = ProductController.getInstance().categoris();
        for (int i = 0 ; i < result.size() ; i++) {
            System.out.println( i + 1 + " : " + result.get(i).getCate_name()); //현재 문제 : 카테고리가 순서대로 출력이 안됨
        }
    }
    //제품 출력 함수
    public void products(){
        ArrayList<ProductDto> result = ProductController.getInstance().products();
        for (int i = 0 ; i < result.size() ; i++) {
            System.out.print("[ ");
            String catename = "";
            System.out.print(result.get(i).getCate_name());
            System.out.print("[ ");
        }
    }

    //제품 등록 함수

    //제품 수정함수
    public void productUpdate(){
        System.out.print("수정 제품번호 입력:"); int pro_no=scan.nextInt();
        System.out.print("수정 제품명 입력:"); String pro_name=scan.next();
        System.out.print("수정 제품가격 입력:");int price=scan.nextInt();
        System.out.print("수정 제품상태 입력"); String state=scan.next();
        ProductDto productDtoUpdate=new ProductDto(pro_no,pro_name,price,state);
        boolean result=ProductController.getInstance().productUpdate(productDtoUpdate);
        if (result) {
            System.out.println("제품수정 성공");

        } else {
            System.out.println("제품수정 실패");

        }

    }


}