package controller;

import model.Dao.MemberDao;
import model.Dto.MemberDto;

public class MemberController {
    //[강사]//
    //싱글톤
    private static final MemberController memberController = new MemberController();
    private MemberController(){}
    public static MemberController getInstance(){
        return memberController;
    }

    // 로그인 상태
    int loginUserNo = 0; // 0이면 로그인 안된 상태 , 0이 아니면 로그인된 회원번호 저장할 예정 , 로그인되면 다시 0 으로 초기화

    //회원가입 등록 제어 함수
    public int shopRegister(String id, String pwd, int phnum) {
        MemberDto shopDto = new MemberDto(id, pwd, phnum);
        // 1. 중복검사를 해주는 select dao 처리
        // 2. 문자열길이 <-- 자바처리
        // 3. 비밀번호 타입 확인 <--- 자바처리
        // -----> 위코드가 모두 통과
        // 4. 등록처리
        // 5. DB오류
        return MemberDao.getInstance().register(shopDto);
    }

    //로그인 등록 제어 함수
    public boolean shopLogin(String id, String pwd){
        MemberDto shopDto = new MemberDto(id, pwd);
        int result =  MemberDao.getInstance().login(shopDto);
        if( result > 0 ){
            loginUserNo = result;
            return true;
        }else{
            return false;
        }
    }
    //로그인 등록 제어 함수
    public void shopLogOut(){
        loginUserNo = 0;
    }
    //[강사]//


    //회원 탈퇴 함수

    public boolean userDelete(){
        return MemberDao.getInstance().userDelete(loginUserNo);
    }
}