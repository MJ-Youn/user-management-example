package service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import entity.User;
import repository.UserRepository;

/**
 * 사용자 관리
 * 
 * @author MJ Youn
 * @since 2023. 03. 24.
 */
public class UserManagement {

    private Scanner scanner = null;

    /** DB 접속을 위한 repository */
    private UserRepository userRepo = null;

    /**
     * (non-javadoc)
     * 
     * @param scanner
     *        사용자에게 입력받는 스캐너
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public UserManagement(Scanner scanner) {
        this.scanner = scanner;
        this.userRepo = new UserRepository();
    }

    /**
     * 새로운 사용자 등록
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public void insert() {
        User user = this.enterUserInfo();

        boolean insertResult = this.userRepo.insert(user);

        if (insertResult) {
            System.out.printf("[ 사용자 등록 성공: %s]\n", user.getId());
        } else {
            System.err.println("[ 사용자 등록 실패 ]");
        }
    }

    /**
     * 사용자 정보 수정
     * 
     * @author MJ youn
     * @since 2023. 03. 24.
     */
    public void update() {
        User user = this.enterUserInfo();

        boolean updateResult = this.userRepo.update(user);

        if (updateResult) {
            System.out.printf("[ 사용자 수정 성공: %s]\n", user.getId());
        } else {
            System.err.println("[ 사용자 수정 실패 ]");
        }
    }

    /**
     * 사용자 정보 삭제
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public void delete() {
        String userId = this.scanner.nextLine();

        boolean deleteResult = this.userRepo.delete(userId);

        if (deleteResult) {
            System.out.printf("[ 사용자 삭제 성공: %s]\n", userId);
        } else {
            System.err.println("[ 사용자 삭제 실패 ]");
        }
    }

    /**
     * 사용자 목록 조회
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public void selectAll() {
        List<User> users = this.userRepo.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 사용자 정보를 입력받는 함수
     * 
     * @return 입력받은 사용자 정보
     * 
     * @author MJ youn
     * @since 2023. 03. 24.
     */
    private User enterUserInfo() {
        User user = new User();
        System.out.print("아이디: ");
        user.setId(this.scanner.nextLine());
        System.out.print("이름: ");
        user.setName(this.scanner.nextLine());

        /** 생년월일 입력 */
        Date date = null;
        boolean validatedDate = false;
        do {
            final String dateFormat = "yyyy-MM-dd";

            System.out.print("생년월일: ");
            String dateString = this.scanner.nextLine();

            try {
                if (dateString.trim().length() == 0) {
                    // 사용자가 아무런 입력을 하지 않았을 경우. null로 입력하기 위한 부분
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
                    date = new Date(formatter.parse(dateString).getTime());
                }
                validatedDate = true;
            } catch (ParseException pe) {
                System.err.printf("생년월일은 '%s' 형태로 입력해주세요.\n", dateFormat);
            }
        } while (!validatedDate); // 유효한 생년월일이 아닐 경우 계속 입력을 받는다.

        user.setBirth(date);

        System.out.print("주소: ");
        user.setAddress(this.scanner.nextLine());

        // 주소가 입력이 안되어 있을 경우, null 설정
        if (user.getAddress().trim().length() == 0) {
            user.setAddress(null);
        }

        System.out.print("직업");
        user.setJob(this.scanner.nextLine());

        // 직업이 입력이 안되어 있을 경우, null 설정
        if (user.getJob().trim().length() == 0) {
            user.setJob(null);
        }

        return user;
    }

}
