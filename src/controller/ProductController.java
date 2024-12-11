package controller;

import model.Dao.MemberDao;
import model.Dao.ProductDao;
import model.Dto.MemberDto;
import model.Dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    //[강사]//
    //싱글톤
    private static final ProductController productController = new ProductController();
    private ProductController(){}
    public static ProductController getInstance(){
        return productController;
    }

    //카테고리 보기 제어 함수
    public ArrayList<ProductDto> categoris(){
        ArrayList<ProductDto> result = ProductDao.getInstance().categories();
        return result;
    }
    //제품 출력 함수
    public ArrayList<ProductDto> products(){


        int user_no_fk = MemberController.getInstance().loginUserNo; // 로그인도니 회원번호.
        ArrayList<ProductDto> result = ProductDao.getInstance().products( user_no_fk );
        return result;
    }
    //제품 등록 함수
}