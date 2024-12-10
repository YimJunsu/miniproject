package view;

import controller.ShopController;
import model.Dto.ShopDto;

import java.util.Scanner;

public class ShopView {
    Scanner scan = new Scanner(System.in);

    //회원가입 싱글톤
    private static final ShopView shopView = new ShopView();

    private ShopView() {
    }

    public static ShopView getInstance() {
        return shopView;
    }

    //메인페이지 시작
    public void mainPage() {
        System.out.println("Shop 개인간 거래 프로그램");
        while (true) {
            System.out.print("[1. 회원가입]   [2. 로그인]   [3. 종료하기] : ");
            int choose = scan.nextInt();
            switch (choose){
                case 1: shopRegister();continue;
                case 2:
                    if (shopLogin()){
                        while (true) {
                            System.out.print("[1.제품보기]  [2.제품등록]  [3.로그아웃] : ");
                            choose = scan.nextInt();
                            switch (choose){
                                case 1: System.out.println("제품목록"); categoris(); continue; //현재 문제 : 카테고리가 순서대로 출력이 안됨
                                case 2: System.out.println("제품 등록중.."); continue;
                                case 3: System.out.println("로그아웃중..");
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
    public void shopRegister() {//회원가입 코드
        System.out.print("회원가입 시작\n[아이디] : ");
        String id = scan.next();
        System.out.print("[비밀번호(숫자)] : ");
        String pwd = scan.next();
        System.out.print("[휴대폰 번호(-없이작성)] : ");
        int phnum = scan.nextInt();
        int result = ShopController.getInstance().shopRegister(id, pwd, phnum);
        switch (result){
            case 1: System.out.println("아이디가 중복되었습니다"); break;
            case 2: System.out.println("연락처가 중복되었습니다"); break;
            case 3: System.out.println("아이디를 4 ~ 20자의 영문 숫자만 사용 가능합니다."); break;
            case 4: System.out.println("비밀번호는 숫자만 사용 가능합니다");break;
            case 5: System.out.println("알수없는 오류가 발생했습니다");break;
            case 6: System.out.println("회원가입 성공");
        }
    }

    public boolean shopLogin() { //로그인
        System.out.print("로그인 시작\n[아이디] : ");
        String id = scan.next();
        System.out.print("[비밀번호(숫자)] : ");
        String pwd = scan.next();

        boolean result = ShopController.getInstance().shopLogin(id, pwd);
        if (result) {
            System.out.println("[로그인 성공하였습니다.]");
            return true;
        } else {
            System.out.println("[로그인 실패하였습니다.]");
            return false;
        }
    }
    //void 카테고리 함수
    public void categoris(){
        ArrayList<ShopDto> result = ShopController.getInstance().categoris();
        System.out.println("카테고리 분류");
        for (int i = 0 ; i < result.size() ; i++) {
            System.out.println( i + 1 + " : " + result.get(i).getCatename()); //현재 문제 : 카테고리가 순서대로 출력이 안됨
        }
    }

}
