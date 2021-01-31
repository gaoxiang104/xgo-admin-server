package pub.xgo.adminserver.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import pub.xgo.adminserver.model.enums.AdminStatusEnums;
import pub.xgo.adminserver.model.enums.MybatisEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@MappedTypes(value = {AdminStatusEnums.class})
public class MybatisBaseEnumTypeHandler<E extends Enum<E> & MybatisEnum> extends BaseTypeHandler<E> {
    /**
     * 枚举的class
     */
    private Class<E> type;
    /**
     * 枚举的每个子类枚
     */
    private E[] enums;

    /**
     * 一定要有默认的构造函数, 不然抛出 not found method 异常
     */
    public MybatisBaseEnumTypeHandler() {
    }

    /**
     * 设置配置文件设置的转换类以及枚举类内容, 供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public MybatisBaseEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("type argument is null.");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not an enum type.");
        }
    }

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        /*
         * BaseTypeHandler已经帮我们做了parameter的null判断
         * 数据库存储的是枚举的值, 所以我们这里使用 value ,  如果需要存储 name, 可以自定义修改
         */
        if (jdbcType == null) {
            ps.setString(i, Objects.toString(parameter.getMybatisValue()));
        } else {
            ps.setObject(i, parameter.getMybatisValue(), jdbcType.TYPE_CODE);
        }
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String i = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return getEnumStatus(i);
        }
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String i = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return getEnumStatus(i);
        }
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String i = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return getEnumStatus(i);
        }
    }

    private E getEnumStatus(String i) {
        for (E e : enums) {
            if (Objects.toString(e.getMybatisValue()).equals(i)) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + i + ",请核对"
                + type.getSimpleName());
    }
}
