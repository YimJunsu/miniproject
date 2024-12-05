package controller;

import model.Dao.ShopDao;
import model.Dto.ShopDto;

public class ShopController {

    //싱글톤
    private static ShopController shopController = new ShopController();
    private ShopController(){}
    public static ShopController getInstance(){
        return shopController;
    }

    //회원가입 등록 제어 함수
    public boolean shopRegister(String id, int pwd, int phnum) {
        ShopDto shopDto = new ShopDto(id, pwd, phnum);
        return ShopDao.getInstance().register(shopDto);
    }

    public boolean shopLogin(String id, int pwd){

        return true;
    }
}
