package pub.xgo.adminserver.model.vo;


import java.io.Serializable;

public class AdminVo implements Serializable {

    private static final long serialVersionUID = -4937648861458294969L;

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
