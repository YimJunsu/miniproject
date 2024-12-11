package view;

import controller.MemberController;

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
        System.out.println("Shop 개인간 거래 프로그램");
        while (true) {
            System.out.print("[1. 회원가입]   [2. 로그인]   [3. 종료하기] : ");
            int choose = scan.nextInt();
            switch (choose){
                case 1:
                    // [강사] 메인뷰 에서 회원뷰에 있는 회원가입 함수 호출
                    MemberView.getInstance().shopRegister();
                    continue;
                case 2:
                    // [강사] 메인뷰 에서 회원뷰에 있는 로그인 함수  호출
                    if ( MemberView.getInstance().shopLogin()) {
                        while (true) {
                            System.out.print("[1. 등록된 제품 관리]  [2. 제품 등록]  [3. 로그아웃] : ");
                            choose = scan.nextInt();
                            switch (choose){
                                case 1:
                                    while (true){
                                        System.out.println("[등록된 제품]"); ProductView.getInstance().products();
                                        System.out.print("[1. 제품 수정] [2. 제품 삭제] [3. 뒤로가기] : "); choose = scan.nextInt();
                                        switch (choose){
                                            case 1: continue;
                                            case 2: continue;
                                            case 3: break;
                                            default: System.out.println("잘못 입력하셨습니다."); continue;
                                        }
                                        break;
                                    }
                                    continue; //현재 문제 : 카테고리가 순서대로 출력이 안됨
                                case 2: System.out.println("제품 등록중.."); continue;
                                case 3:
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
    }

}
