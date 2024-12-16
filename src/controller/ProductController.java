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
        int user_no_fk = MemberController.getInstance().loginUserNo;
        ArrayList<ProductDto> result = ProductDao.getInstance().products( user_no_fk );
        return result;
    }
    //제품 등록 함수
    public boolean productAdd(String proName, int price, String board, String state, int category_no_fk){
        int user_no_fk = MemberController.getInstance().loginUserNo;
        ProductDto productDto = new ProductDto(user_no_fk, category_no_fk, proName, price, board, state);
        return ProductDao.getInstance().productAdd(productDto);
    }

    //제품삭제함수
    public boolean productDelete(int deleteNum){
        boolean result=ProductDao.getInstance().productDelete(deleteNum);
        return result;
    }
    //제품 수정함수
    public boolean productUpdate(ProductDto productDto){
        int user_no_fk = MemberController.getInstance().loginUserNo;
        boolean result=ProductDao.getInstance().productUpdate(productDto);
        return result;
    }

}