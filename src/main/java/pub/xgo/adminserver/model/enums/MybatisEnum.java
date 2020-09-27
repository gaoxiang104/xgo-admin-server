package pub.xgo.adminserver.model.enums;

public interface MybatisEnum<E extends Enum<?>, T> {
    T getMybatisValue();
}
