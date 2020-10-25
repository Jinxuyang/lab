package ink.verge.lab.response;

/**
 * @Author Verge
 * @Date 2020/10/9 0:25
 * @Version 1.0
 */
public enum ResultType implements IErrorType {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败");

    private long code;
    private String message;

    ResultType(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
