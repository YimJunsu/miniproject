package model.Dto;

public class MemberDto {
    private static int user_no;
    private String user_id;
    private String user_pwd;
    private int phnum;

    public MemberDto(String user_id, String user_pwd, int phnum) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.phnum = phnum;
    }

    public MemberDto(String user_id, String user_pwd) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
    }


    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_name) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public int getPhnum() {
        return phnum;
    }

    public void setPhnum(int phnum) {
        this.phnum = phnum;
    }
}
