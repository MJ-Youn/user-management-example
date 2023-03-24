package entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 Table mapping class
 * 
 * @author MJ Youn
 * @since 2023. 03. 24.
 */
public class User {

    private String id;
    private String name;
    private Date birth;
    private String address;
    private String job;

    private List<Phone> phones = new ArrayList<>();

    /**
     * (non-javadoc)
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public User() {}

    /**
     * (non-javadoc)
     * 
     * @param rs
     *        {@link ResultSet}
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    public User(ResultSet rs) throws SQLException {
        this.id = rs.getString("id");
        this.name = rs.getString("name");
        this.birth = rs.getDate("birth");
        this.address = rs.getString("address");
        this.job = rs.getString("job");
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *        the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth
     *        the birth to set
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *        the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job
     *        the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the phones
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * @param phones
     *        the phones to set
     */
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * @see Object#toString()
     * 
     * @author MJ Youn
     * @since 2023. 03. 24.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", birth=");
        builder.append(birth);
        builder.append(", address=");
        builder.append(address);
        builder.append(", job=");
        builder.append(job);
        builder.append(", phones=");
        builder.append(phones);
        builder.append("]");
        return builder.toString();
    }

}
