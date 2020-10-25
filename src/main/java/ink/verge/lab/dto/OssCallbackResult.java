package ink.verge.lab.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Verge
 * @Date 2020/10/10 0:16
 * @Version 1.0
 */
@Data
public class OssCallbackResult {
    @ApiModelProperty("文件名称")
    private String filename;
    @ApiModelProperty("文件大小")
    private String size;
    @ApiModelProperty("文件的mimeType")
    private String mimeType;
    @ApiModelProperty("图片文件的宽")
    private String width;
    @ApiModelProperty("图片文件的高")
    private String height;
}
