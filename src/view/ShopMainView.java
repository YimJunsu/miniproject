package view;

public class ShopMainView {

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

}
