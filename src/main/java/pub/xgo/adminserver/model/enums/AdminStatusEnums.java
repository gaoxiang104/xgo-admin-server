package pub.xgo.adminserver.model.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 管理员状态
 */
public enum AdminStatusEnums implements MybatisEnum<AdminStatusEnums, Integer> {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用"),
    ;

    /**
     * key
     */
    private int key;
    /**
     * value
     */
    private String value;

    AdminStatusEnums(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Integer getMybatisValue() {
        return this.getKey();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"key\":")
                .append(key);
        sb.append(",\"value\":\"")
                .append(value).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
