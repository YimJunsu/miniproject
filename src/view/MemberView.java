package view;

import controller.MemberController;
import controller.ProductController;
import model.Dto.MemberDto;

import java.util.Scanner;

public class MemberView {

    // [강사] MemberView 싱글톤
    private static final MemberView memberView = new MemberView();
    private MemberView() { }
    public static MemberView getInstance() {
        return memberView;
    }
    // [강사] 입력 객체
    Scanner scan = new Scanner(System.in);


    //회원가입 함수
    public void shopRegister() {//회원가입 코드
        System.out.print("회원가입 시작\n[아이디] : ");
        String id = scan.next();
        System.out.print("[비밀번호(숫자)] : ");
        String pwd = scan.next();
        System.out.print("[휴대폰 번호(-없이)] : ");
        int phnum = scan.nextInt();
        //[강사]//
        int result = MemberController.getInstance().shopRegister(id, pwd, phnum);
        switch (result){
            case 1: System.out.println("아이디가 중복되었습니다"); break;
            case 2: System.out.println("연락처가 중복되었습니다"); break;
            case 3: System.out.println("아이디를 4 ~ 20자의 영문 숫자만 사용 가능합니다."); break;
            case 4: System.out.println("비밀번호는 숫자만 사용 가능합니다");break;
            case 5: System.out.println("알수없는 오류가 발생했습니다");break;
            case 6: System.out.println("회원가입 성공");
        }
    }
    //로그인 함수
    public boolean shopLogin() {
        System.out.print("로그인 시작\n[아이디] : ");
        String id = scan.next();
        System.out.print("[비밀번호(숫자)] : ");
        String pwd = scan.next();
        //[강사]//
        boolean result = MemberController.getInstance().shopLogin(id, pwd);
        if (result) {
            System.out.println("[로그인 성공하였습니다.]");
            return true;
        } else {
            System.out.println("[로그인 실패하였습니다.]");
            return false;
        }
    }
    //회원정보 삭제
    public boolean userDelete(){
        System.out.println("[회원탈퇴 서비스입니다.]");
        boolean result = MemberController.getInstance().userDelete();
        if(result){
            System.out.println("[회원탈퇴가 되었습니다.]");
            System.out.println("[이용해주셔서 감사합니다.]");
            return true;
        } else {
            System.out.println("[회원탈퇴가 되지않았습니다.");
            return false;
        }
    }
    public boolean userUpdate(){
        scan.nextLine();
        System.out.println("[회원정보수정 서비스입니다.");
        System.out.print("[수정할 비밀번호] : "); String user_pwd = scan.nextLine();
        System.out.print("[수정할 전화번호] : "); int phnum = scan.nextInt();

        MemberDto memberDto = new MemberDto(user_pwd, phnum);
        boolean result = MemberController.getInstance().userUpdate(memberDto);
        if (result) {
            System.out.println("[회원정보수정이 완료되었습니다.]");
            return true;
        } else {
            System.out.println("[회원정보수정이 되지 않았습니다.]");
            return false;
        }
    }
}