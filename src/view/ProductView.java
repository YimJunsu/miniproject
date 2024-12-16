
package view;

import controller.ProductController;
import model.Dto.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {

    // [강사] MemberView 싱글톤
    private static final ProductView productView = new ProductView();

    private ProductView() {
    }

    public static ProductView getInstance() {
        return productView;
    }

    // [강사] 입력 객체
    Scanner scan = new Scanner(System.in);

    //void 카테고리 함수
    public void categoris() {
        ArrayList<ProductDto> result = ProductController.getInstance().categoris();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getCate_no() + " : " + result.get(i).getCate_name()); //현재 문제 : 카테고리가 순서대로 출력이 안됨
        }
    }

    //제품 출력 함수
    public void products() {
        ArrayList<ProductDto> result_cate = ProductController.getInstance().categoris();
        ArrayList<ProductDto> result_pro = ProductController.getInstance().products();
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < result_pro.size(); i++) {
            if (result_pro.get(0)!=null){
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
                int j = i+1;
                System.out.println("[ 등록된 제품" + j + " ]");
                System.out.print("[ 카테고리명 : "); System.out.print(proName); System.out.println(" ]");
                System.out.print("[ 제품명 : "); System.out.print(result_pro.get(i).getPro_name()); System.out.println(" ]");
                System.out.print("[ 가격 : "); System.out.print(result_pro.get(i).getPrice()); System.out.println(" ]");
                System.out.print("[ 상태 : "); System.out.print(result_pro.get(i).getState()); System.out.println(" ]");
                System.out.print("[ 상세내용 : "); System.out.print(result_pro.get(i).getBoard()); System.out.println(" ]");
                System.out.println("----------------------------------------------------------------");
            } else {
                System.out.println("등록된 제품이 없습니다.");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }

    //제품 등록 함수
    public void  productAdd(){
        categoris();
        System.out.print("[카테고리 선택(번호)] : "); int cate_no = scan.nextInt();
        scan.nextLine();
        System.out.print("[제품명 입력] : "); String pro_name = scan.nextLine();
        System.out.print("[제품가격 입력] : "); int price = scan.nextInt();
        System.out.print("[1. 판매중]  [2. 판매완료]  : "); int state = scan.nextInt();
        String role = "";
        if (state == 1){
            role = "판매중";
        } else if (state == 2) {
            role = "판매완료";
        }
        scan.nextLine();
        System.out.print("[제품 설명 입력(200글자)] : "); String board=scan.nextLine();
        //String proName, int price, String board, String state, int category_no_fk
        boolean result = ProductController.getInstance().productAdd(pro_name, price, role, board, cate_no);
        if (result){
            System.out.println("제품등록 성공");
        }else {
            System.out.println("제품등록 실패");
        }
    }

    //제품 삭제함수
    public void productDelete() {
        System.out.print("삭제할 제품번호 입력:");
        int deleteNum = scan.nextInt();
        boolean result = ProductController.getInstance().productDelete(deleteNum);
        if (result) {
            System.out.println("제품삭제 성공");
        } else {
            System.out.println("제품삭제 실패");
        }
    }

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
