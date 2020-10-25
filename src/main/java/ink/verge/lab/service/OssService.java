package ink.verge.lab.service;

import ink.verge.lab.dto.OssCallbackResult;
import ink.verge.lab.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Verge
 * @Date 2020/10/10 0:17
 * @Version 1.0
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
