package model.Dao;

import model.Dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao extends DBDao {
    private static final MemberDao memberDao = new MemberDao();

    private MemberDao() {
    }

    public static MemberDao getInstance() {
        return memberDao;
    }

    public int register(MemberDto memberDto) {
        try {
            String sql = "insert into user (id, pwd, phone_no) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            try {
                ps.setString(1, memberDto.getUser_id());
                int password = Integer.parseInt(memberDto.getUser_pwd());
                ps.setInt(2, password);
                ps.setInt(3, memberDto.getPhnum());
                ps.executeUpdate();
            } catch (NumberFormatException e) {
                System.err.println("Error : " + e.getMessage());
                return 4; //비밀번호 타입 오류
            }
            return 6;
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
                if (errorMessage.contains("id")) {
                    System.err.println("Error : " + errorMessage);
                    return 1; //아이디 중복
                } else if (errorMessage.contains("phone_no")) {
                    System.err.println("Error : " + errorMessage);
                    return 2; //연락처 중복
                }
            } else if (e.getSQLState().equals("22001")) {
                System.err.println("Error : " + errorMessage);
                return 3; //id길이 초과
            } else {
                System.err.println("Error" + errorMessage);
            }
            return 5;  //기타 오류
        }
    }

    public int login(MemberDto memberDto) {
        String sql = "select * from user where id = ? and pwd = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberDto.getUser_id());
            int password = Integer.parseInt(memberDto.getUser_pwd());
            ps.setInt(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_no"); // 로그인 성공시 성공한 회원번호 반환 ,
            } else {
                System.out.println("[아이디 또는 비밀번호가 잘못되었습니다]");
                return 0;  // 로그인 실패시 0 반환 ,
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return 0; // 로그인 실패시 0 반환 ,
        }
    }
    //로그인 한 상태에서 탈퇴가 진행되도록, 탈퇴할때는 회원번호만 받게
    public boolean userDelete( int loginUserNo ) {
        try {
            String sql = "delete from user where user_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginUserNo);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean userUpdate(MemberDto memberDto){
        try {
            String sql = "update user set pwd = ?, phone_no = ? where user_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getUser_pwd());
            ps.setInt(2, memberDto.getPhnum());
            ps.setInt(3, memberDto.getUser_no());
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        }catch (SQLException e){
            e.getMessage();
            System.err.println("[회원정보 수정 오류 발생]");
        } return false;
    }
}