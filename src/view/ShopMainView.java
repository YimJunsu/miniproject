package view;

import controller.MemberController;
import controller.OrderController;
import controller.ProductController;
import model.Dto.MemberDto;

import java.util.Scanner;

public class ShopMainView {

    // [강사] ShopMainView 싱글톤
    private static final ShopMainView mainView = new ShopMainView();
    private ShopMainView() { }
    public static ShopMainView getInstance() {
        return mainView;
    }
    // [강사] 입력 객체
    Scanner scan = new Scanner(System.in);

    public void mainPage() {
        boolean deleted = false;
        System.out.println("Shop 개인간 거래 프로그램");
        System.out.print("[1. 판매자]  [2. 구매자] : ");
        int main = scan.nextInt();
        while (main==1) {
        while (true) {  // *첫번째 메뉴*
            System.out.print("[1. 회원가입]   [2. 로그인]   [3. 종료하기] : ");
            int choose = scan.nextInt();
            switch (choose){
                case 1:
                    // [강사] 메인뷰 에서 회원뷰에 있는 회원가입 함수 호출
                    MemberView.getInstance().shopRegister();
                    continue;
                case 2:   // *두번째 메뉴*
                    // [강사] 메인뷰 에서 회원뷰에 있는 로그인 함수  호출
                    if ( MemberView.getInstance().shopLogin()) {
                        while (true) {
                            if (deleted){
                                deleted = false;
                                break;
                            }
                            System.out.print("[1. 제품 관리]  [2. 회원 정보 관리]  [3. 로그아웃] : ");
                            choose = scan.nextInt();
                            switch (choose) {
                                case 1: // **제품관리 선택**
                                    while (true) {
                                        System.out.print("[1. 제품 내역]  [2. 제품 등록, 수정, 삭제]  [3. 뒤로가기] : ");
                                        choose = scan.nextInt();
                                        switch (choose) {
                                            case 1:
                                                System.out.println("[             제품목록             ");
                                                ProductView.getInstance().products();
                                                continue;
                                            case 2:
                                                System.out.print("[1. 제품 등록]  [2. 제품 수정]  [3. 삭제]  [4. 뒤로가기] : ");
                                                choose = scan.nextInt();
                                                switch (choose) {
                                                    case 1:
                                                        ProductView.getInstance().productAdd();
                                                        continue;
                                                    case 2:
                                                        ProductView.getInstance().productUpdate();
                                                        continue;
                                                    case 3:
                                                        ProductView.getInstance().productDelete();
                                                        continue;
                                                    case 4:
                                                        break;
                                                }
                                            case 3:
                                        }break;
                                    }
                                case 2: //** 회원정보 관리 선택**
                                    while (true) {
                                        System.out.println("[회원 정보 관리 시스템 입니다.]");
                                        System.out.println("[1. 회원 정보 수정]   [2. 회원 탈퇴]  [3. 뒤로가기] : ");
                                        choose = scan.nextInt();
                                        switch (choose){
                                            case 1:
                                                System.out.println("[회원 정보 수정 서비스입니다.]");
                                                MemberView.getInstance().userUpdate();
                                                break;
                                            case 2:
                                                System.out.println("[회원 탈퇴 서비스입니다.]");
                                                MemberView.getInstance().userDelete();
                                                break;
                                            case 3:
                                                break;

                                        } break;

                                    }
                                    System.out.println("--- ---");
                                    break;
                                case 3: //** 로그아웃 **
                                    System.out.println("로그아웃중..");
                                    //[강사]//
                                    MemberController.getInstance().shopLogOut();
                            }
                            if (choose == 3){
                                break;
                            }
                        }
                    }continue;
                case 3: System.out.println("종료중..");
            }
            if (choose==3){
                break;
            }
        }
        while (main==2){
            OrderView.getInstance().orderList();
            System.out.print("구매하실 제품 선택(번호) : "); int choose = scan.nextInt();;
            System.out.println("구매되었습니다");
            break;
        }
    }

}
