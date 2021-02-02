package pub.xgo.adminserver.model.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 8670797411639881172L;

    /**
     * ID
     */
    @NotNull(message = "ID是空的")
    private Long id;
    /**
     * name
     */
    @NotNull(message = "Name是空的")
    @Size(min = 2, max = 20, message = "Name字符长度需要在2～20之间")
    private String name;
    /**
     * email
     */
    @NotNull(message = "Email是空的")
    @Email(message = "Email格式错误")
    private String email;

}
