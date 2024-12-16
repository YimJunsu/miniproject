package view;

import controller.MemberController;
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
                            System.out.print("[1.제품 관련]  [2.회원 관련]  [3.로그아웃] : ");
                            choose = scan.nextInt();
                            switch (choose) {
                                case 1:
                                    while (true) {
                                        System.out.print("[1.제품보기]  [2.제품등록] : ");
                                        choose = scan.nextInt();
                                        switch (choose) {
                                            case 1:
                                                System.out.println("제품목록");
                                                // [강사] 메인뷰 에서 제품뷰에 있는 카테고리 출력 함수  호출
                                                ProductView.getInstance().categoris();
                                                continue; //현재 문제 : 카테고리가 순서대로 출력이 안됨
                                            case 2:
                                                System.out.println("제품 등록중..");
                                                continue;
                                        }
                                    }
                                case 2:
                                    System.out.println("[1. 회원탈퇴] , [2. 정보수정] : ");
                                    int choose2 = scan.nextInt();
                                    switch (choose2) {
                                        case 1:
                                            System.out.print("[회원탈퇴서비스 입니다.]");
                                            System.out.print("정말로 탈퇴하시겠습니까? (예(1)/아니오(2)) : ");
                                            int result = scan.nextInt();
                                            if (result == 1) {
                                                System.out.println("회원 탈퇴가 진행됩니다.");
                                                MemberView.getInstance().userDelete();
                                            } else if (result == 2) {
                                                System.out.println("회원 탈퇴가 취소되었습니다., 이전창으로..");
                                            } else {
                                                System.out.println(" 잘못된 선택입니다. ");
                                            } break;
                                        case 2:
                                            System.out.println("[회원정보 수정입니다.]");
                                            MemberView.getInstance().userUpdate();
                                            continue;
                                    }
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