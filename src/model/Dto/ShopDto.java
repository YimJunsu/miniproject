package model.Dto;

public class ShopDto {
        // 회원가입
        private int usernum;
        private String id;
        private int pwd;
        private int phnum;
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

        public ShopDto(String id, String pwd, int phnum) {
                this.id = id;
                this.pwd = pwd;
                this.phnum = phnum;
        }

        public ShopDto(String id, String pwd) {
                this.id = id;
                this.pwd = pwd;
        }

        public ShopDto(String catename) {
                this.catename = catename;
        }

        // 상품 추가 생성자


        public ShopDto(String prname, int price, String state) {
                this.prname = prname;
                this.price = price;
                this.state = state;
        }

        //getter,setter
        public int getUsernum() {return usernum;}
        public String getId() {return id;}
        public int getPwd() {return pwd;}
        public int getPhnum() {return phnum;}
        public void setId(String id) {this.id = id;}
        public void setPwd(int pwd) {this.pwd = pwd;}
        public void setUsernum(int usernum) {this.usernum = usernum;}
        public void setPhnum(int phnum) {this.phnum = phnum;}


        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getPwd() {
                return pwd;
        }

        public void setPwd(String pwd) {
                this.pwd = pwd;
        }

        public int getPhnum() {
                return phnum;
        }

        public void setPhnum(int phnum) {
                this.phnum = phnum;
        }

        public String getCatename() {
                return catename;
        }

        public void setCatename(String catename) {
                this.catename = catename;
        }

        public String getPrname() {
                return prname;
        }

        public void setPrname(String prname) {
                this.prname = prname;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getBuyer() {
                return buyer;
        }

        public void setBuyer(String buyer) {
                this.buyer = buyer;
        }

        public String getSeller() {
                return seller;
        }

        public void setSeller(String seller) {
                this.seller = seller;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        @Override
        public String toString() {
                return "ShopDto{" +
                        "id='" + id + '\'' +
                        ", pwd='" + pwd + '\'' +
                        ", phnum=" + phnum +
                        ", catename='" + catename + '\'' +
                        ", prname='" + prname + '\'' +
                        ", price=" + price +
                        ", state='" + state + '\'' +
                        ", buyer='" + buyer + '\'' +
                        ", seller='" + seller + '\'' +
                        ", content='" + content + '\'' +
                        '}';
        }
}