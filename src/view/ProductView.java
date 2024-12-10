package view;

import controller.ShopController;

import java.util.ArrayList;

public class ProductView {

    //void 카테고리 함수
    public void categoris(){
        ArrayList<ShopDto> result = ShopController.getInstance().categoris();
        System.out.println("카테고리 분류");
        for (int i = 0 ; i < result.size() ; i++) {
            System.out.println( i + 1 + " : " + result.get(i).getCatename()); //현재 문제 : 카테고리가 순서대로 출력이 안됨
        }
    }

}
