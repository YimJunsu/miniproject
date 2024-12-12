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
        ArrayList<ProductDto> result_cate = ProductController.getInstance().categoris();
        ArrayList<ProductDto> result_pro = ProductController.getInstance().products();
        for (int i = 0 ; i < result_pro.size() ; i++) {
            String proName = "";
            if (result_cate.get(0).getCate_no() == result_pro.get(i).getCate_no()){
                proName = result_cate.get(0).getCate_name();
            }else if (result_cate.get(1).getCate_no() == result_pro.get(i).getCate_no()){
                proName = result_cate.get(1).getCate_name();
            }else if (result_cate.get(2).getCate_no() == result_pro.get(i).getCate_no()){
                proName = result_cate.get(2).getCate_name();
            }else if (result_cate.get(3).getCate_no() == result_pro.get(i).getCate_no()){
                proName = result_cate.get(3).getCate_name();
            }
            System.out.println("등록된 제품" + i+1);
            System.out.print("[ 카테고리명 : "); System.out.print(proName); System.out.println(" ]");
            System.out.print("[ 제품명 : "); System.out.print(result_pro.get(i).getPro_name()); System.out.println(" ]");
            System.out.print("[ 가격 : "); System.out.print(result_pro.get(i).getPrice()); System.out.println(" ]");
            System.out.print("[ 상태 : "); System.out.print(result_pro.get(i).getState()); System.out.println(" ]");
            System.out.print("[ 상세내용 : "); System.out.print(result_pro.get(i).getBoard()); System.out.println(" ]");
            System.out.println("------------------------------------------------------");
            System.out.println("");
        }
    }

    //제품 등록 함수

}
