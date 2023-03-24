package repository;

/**
 * (non-javadoc)
 * 
 * @author MJ Youn
 * @since 2023. 03. 24.
 */
public class Query {

    /** 단일 사용자 조회 쿼리 */
    public static final String USER_SELECT = "SELECT * FROM user WHERE id = ?";
    /** 모든 사용자 목록 조회 */
    public static final String USER_SELECT_ALL = "SELECT * FROM user ORDER BY name ASC";
    /** 사용자 등록 쿼리 */
    public static final String USER_INSERT = "INSERT INTO user(id, name, birth, address, job) VALUES(?, ?, ?, ?, ?)";
    /** 사용자 삭제 쿼리 */
    public static final String USER_DELETE = "DELETE FROM user WHERE id = ?";
    /** 사용자 수정 쿼리 */
    public static final String USER_UPDATE = "UPDATE user SET name = ?, birth = ?, address = ?, job = ? WHERE id = ?";

}
