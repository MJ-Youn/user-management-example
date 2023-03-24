package entity;

/**
 * 전화 번호 저장 class
 * 
 * @author MJ Youn
 * @since 2023. 03. 24.
 */
public class Phone {

    private String number;

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     *        the number to set
     */
    public void setNumber(String number) {
        this.number = number;
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
        builder.append("Phone [number=");
        builder.append(number);
        builder.append("]");
        return builder.toString();
    }

}
