package base;

import java.io.Serializable;

public class GlobalResponse<T> implements Serializable {
    private static final long serialVersionUID = -2511953664876840665L;
    private String code;
    private String message;
    private T data;
    public GlobalResponse() {

    }
    public GlobalResponse(String code) {
        this.code = code;
    }
    public GlobalResponse(String code,String msg) {
        this.code = code;
        this.message = msg;
    }
    public GlobalResponse(String code,String msg,T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
