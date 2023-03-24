package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

/**
 * 사용자 관련 DB 연동 모듈
 * 
 * @author MJ Youn
 * @since 2023. 03. 24.
 */
public class UserRepository {

    /** DB drive 경로 */
    private final String DB_DRIVE_PATH = "org.mariadb.jdbc.Driver";

    /** DB 접속정보 */
    private final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/user";
    private final String DB_USER_ID = "admin";
    private final String DB_USER_PASSWORD = "admin";

    /**
     * 새로운 사용자 등록
     * 
     * @param user
     *        사용자 정보
     * @return 등록 결과
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public Boolean insert(User user) {
        Boolean result = false;

        try {
            Class.forName(DB_DRIVE_PATH);
        } catch (ClassNotFoundException e) {
            System.err.printf("DB Drive 설정하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER_ID, DB_USER_PASSWORD);
                PreparedStatement userInsertPstmt = con.prepareStatement(Query.USER_INSERT);) {
            userInsertPstmt.setString(1, user.getId());
            userInsertPstmt.setString(2, user.getName());
            userInsertPstmt.setDate(3, user.getBirth());
            userInsertPstmt.setString(4, user.getAddress());
            userInsertPstmt.setString(5, user.getJob());

            result = true;
        } catch (SQLException e) {
            System.err.printf("사용자 정보를 등록하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 사용자 수정
     * 
     * @param user
     *        사용자 정보
     * @return 수정 결과
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public Boolean update(User user) {
        Boolean result = false;

        try {
            Class.forName(DB_DRIVE_PATH);
        } catch (ClassNotFoundException e) {
            System.err.printf("DB Drive 설정하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER_ID, DB_USER_PASSWORD);
                PreparedStatement userUpdatePstmt = con.prepareStatement(Query.USER_UPDATE);) {
            userUpdatePstmt.setString(1, user.getName());
            userUpdatePstmt.setDate(2, user.getBirth());
            userUpdatePstmt.setString(3, user.getAddress());
            userUpdatePstmt.setString(4, user.getJob());
            userUpdatePstmt.setString(5, user.getId());

            result = true;
        } catch (SQLException e) {
            System.err.printf("사용자 정보를 수정하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 모든 사용자 정보 조회
     * 
     * @return 사용자 목록
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public List<User> findAll() {
        List<User> result = null;

        try {
            Class.forName(DB_DRIVE_PATH);
        } catch (ClassNotFoundException e) {
            System.err.printf("DB Drive 설정하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER_ID, DB_USER_PASSWORD);
                PreparedStatement userSelectPstmt = con.prepareStatement(Query.USER_SELECT_ALL);
                ResultSet rs = userSelectPstmt.executeQuery();) {
            result = new ArrayList<>();

            while (rs.next()) {
                User user = new User(rs);
                result.add(user);
            }
        } catch (SQLException e) {
            System.err.printf("사용자 정보를 조회하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 사용자 정보 삭제
     * 
     * @param userId
     *        사용자 아이디
     * @return 삭제 결과
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public Boolean delete(String userId) {
        Boolean result = false;

        try {
            Class.forName(DB_DRIVE_PATH);
        } catch (ClassNotFoundException e) {
            System.err.printf("DB Drive 설정하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER_ID, DB_USER_PASSWORD);
                PreparedStatement userDeletePstmt = con.prepareStatement(Query.USER_DELETE);) {
            userDeletePstmt.setString(1, userId);
            userDeletePstmt.executeQuery();

            result = true;
        } catch (SQLException e) {
            System.err.printf("사용자 정보를 삭제하는데 실패했습니다. [msg: %s]\n", e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

}
