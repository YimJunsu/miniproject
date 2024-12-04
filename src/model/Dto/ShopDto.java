package model.Dto;

public class ShopDto {
        // 회원가입
        private int usernum;
        private static String id;
        private static int pwd;
        private static int phnum;
        // 카테고리
        private int catenum;
        private String catename;
        // 상품
        private int prnum;
        private String prname;
        private int price;
        private String state;
        // 주문
        private int ordernum;
        private String buyer;
        private String seller;
        private String content;

        // 회원가입 생성자
        public ShopDto(String id, int pwd, int phnum) {
            this.usernum = usernum; this.id = id; this.pwd = pwd; this.phnum = phnum;
        }

        //getter,setter
        public int getUsernum() {return usernum;}
        public static String getId() {return id;}
        public static int getPwd() {return pwd;}
        public static int getPhnum() {return phnum;}
        public void setId(String id) {this.id = id;}
        public void setPwd(int pwd) {this.pwd = pwd;}
        public void setUsernum(int usernum) {this.usernum = usernum;}
        public void setPhnum(int phnum) {this.phnum = phnum;}

        @Override
        public String toString() {
            return "shopDto{" +
                    "usernum=" + usernum +
                    ", id='" + id + '\'' +
                    ", pwd='" + pwd + '\'' +
                    ", phnum=" + phnum +
                    '}';
        }
    }
