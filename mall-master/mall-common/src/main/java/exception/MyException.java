package exception;

public class MyException extends RuntimeException{
    //错误编码
    private int code;
    //错误内容
    private String msg;

    public MyException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
