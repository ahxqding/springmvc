package cn.itcast.exception;

/**
 * 自定义异常类
 */
public class SystemException extends Exception {

    // 用于存储提示信息的
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SystemException(String message) {
        this.message = message;
    }
}
