package controller;

import model.Dao.ShopDao;
import model.Dto.ShopDto;

public class ShopController {

    //싱글톤
    private static final ShopController shopController = new ShopController();
    private ShopController(){}
    public static ShopController getInstance(){
        return shopController;
    }

    //회원가입 등록 제어 함수
    public boolean shopRegister(String id, int pwd, int phnum) {
        ShopDto shopDto = new ShopDto(id, pwd, phnum);
        return ShopDao.getInstance().register(shopDto);
    }

    //로그인 등록 제어 함수
    public boolean shopLogin(String id, int pwd){
        ShopDto shopDto = new ShopDto(id, pwd);
        return ShopDao.getInstance().login(shopDto);
    }

    //카테고리 보가 제어 함수
}
