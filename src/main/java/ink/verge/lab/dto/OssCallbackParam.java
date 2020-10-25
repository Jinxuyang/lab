package ink.verge.lab.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Verge
 * @Date 2020/10/10 0:15
 * @Version 1.0
 */
@Data
public class OssCallbackParam {
    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;
    @ApiModelProperty("回调是传入request中的参数")
    private String callbackBody;
    @ApiModelProperty("回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;
}
