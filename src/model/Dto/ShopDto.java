//package model.Dto;
//
//public class ShopDto {
//
//        /*
//        브랜치 병합 할때 dto 이코드 사용해주세요 12/10
//         */
//
//        // 회원가입
//        //private int usernum;
//        private String id;
//        private String pwd;
//        private int phnum;
//        // 카테고리
//        //private int catenum;
//        private String catename;
//        // 상품
//        //private int prnum;
//        private String prname;
//        private int price;
//        private String state;
//        // 주문
//        //private int ordernum;
//        private String buyer;
//        private String seller;
//        private String content;
//
//        public ShopDto(String id, String pwd, int phnum) {
//                this.id = id;
//                this.pwd = pwd;
//                this.phnum = phnum;
//        }
//
//        public ShopDto(String id, String pwd) {
//                this.id = id;
//                this.pwd = pwd;
//        }
//
//        public ShopDto(String catename) {
//                this.catename = catename;
//        }
//
//
//
//        public String getId() {
//                return id;
//        }
//
//        public void setId(String id) {
//                this.id = id;
//        }
//
//        public String getPwd() {
//                return pwd;
//        }
//
//        public void setPwd(String pwd) {
//                this.pwd = pwd;
//        }
//
//        public int getPhnum() {
//                return phnum;
//        }
//
//        public void setPhnum(int phnum) {
//                this.phnum = phnum;
//        }
//
//        public String getCatename() {
//                return catename;
//        }
//
//        public void setCatename(String catename) {
//                this.catename = catename;
//        }
//
//        public String getPrname() {
//                return prname;
//        }
//
//        public void setPrname(String prname) {
//                this.prname = prname;
//        }
//
//        public int getPrice() {
//                return price;
//        }
//
//        public void setPrice(int price) {
//                this.price = price;
//        }
//
//        public String getState() {
//                return state;
//        }
//
//        public void setState(String state) {
//                this.state = state;
//        }
//
//        public String getBuyer() {
//                return buyer;
//        }
//
//        public void setBuyer(String buyer) {
//                this.buyer = buyer;
//        }
//
//        public String getSeller() {
//                return seller;
//        }
//
//        public void setSeller(String seller) {
//                this.seller = seller;
//        }
//
//        public String getContent() {
//                return content;
//        }
//
//        public void setContent(String content) {
//                this.content = content;
//        }
//
//        @Override
//        public String toString() {
//                return "ShopDto{" +
//                        "id='" + id + '\'' +
//                        ", pwd='" + pwd + '\'' +
//                        ", phnum=" + phnum +
//                        ", catename='" + catename + '\'' +
//                        ", prname='" + prname + '\'' +
//                        ", price=" + price +
//                        ", state='" + state + '\'' +
//                        ", buyer='" + buyer + '\'' +
//                        ", seller='" + seller + '\'' +
//                        ", content='" + content + '\'' +
//                        '}';
//        }
//}