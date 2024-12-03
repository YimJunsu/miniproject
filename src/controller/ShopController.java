package controller;

public class ShopController {

    private static ShopController shopController = new ShopController();
    private ShopController(){}
    public static ShopController getInstance(){
        return shopController;
    }

    public boolean shopRegister(String id, int pwd, int phnum) {
        return true;
    }
    public boolean shopLogin(String id, int pwd){
        return true;
    }
}
