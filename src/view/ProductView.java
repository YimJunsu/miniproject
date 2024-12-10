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
        System.out.println("카테고리 분류");
        for (int i = 0 ; i < result.size() ; i++) {
            System.out.println( i + 1 + " : " + result.get(i).getCate_name()); //현재 문제 : 카테고리가 순서대로 출력이 안됨
        }

    }
    //[강사]//

}
