import java.util.Scanner;

import service.UserManagement;

/**
 * main 함수
 *
 * @author MJ Youn
 * @since 2023. 03. 24.
 */
public class App {

    /** 사용자가 입력 가능한 옵션 종류 */
    private static final String[] OPTIONS = { "추가", "수정", "삭제", "조회", "종료" };

    /**
     * (non-javadoc)
     * 
     * @param args
     *        실행 parameter
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement userMgmt = new UserManagement(scanner);

        Integer option = null;

        do {
            printOptions();
            option = scanner.nextInt();

            // option
            switch (option) {
            case 1: // 추가
                printOption(option);
                userMgmt.insert();
                break;
            case 2: // 수정
                printOption(option);
                userMgmt.update();
                break;
            case 3: // 삭제 
                printOption(option);
                userMgmt.delete();
                break;
            case 4: // 조회
                printOption(option);
                userMgmt.selectAll();
                break;
            case 5: // 종료
                printOption(option);
                System.out.println("[ 5번 종료합니다. ]");
                break;
            default: // 예외
            }
        } while (option == null && option != 5);

        scanner.close();
    }

    /**
     * 옵션 출력
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    private static void printOptions() {
        StringBuffer sb = new StringBuffer();

        sb.append("[ ");

        for (int i = 0; i < OPTIONS.length; i++) {
            sb.append(i + 1) //
                    .append(". ") //
                    .append(OPTIONS[i]);

            if (i != OPTIONS.length - 1) {
                sb.append(", ");
            }
        }

        sb.append(" ]");

        System.out.println(sb.toString());
    }

    /**
     * 단일 옵션 출력
     * 
     * @param option
     *        옵션 정보
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    private static void printOption(int option) {
        StringBuffer sb = new StringBuffer() //
                .append("[ ") //
                .append(OPTIONS[option - 1]) //
                .append(" ]");

        System.out.println(sb.toString());
    }

}
