package com.example.globalexception.exception;

public class MineException extends RuntimeException {
    private static final long serialVersion = -1104674993657790702L;

    //生成序列异常
    public static final MineException DB_GET_SEQ_NEXT_VALUE_ERROR = new MineException(10040007, "序列生成超时");

    //具体异常码
    protected int code;

    //异常信息
    protected String msg;

    public MineException(String message) {
        super(message);
    }

    public MineException(int i, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public MineException(String message, Throwable cause) {
        super(message, cause);
    }

    public MineException(Throwable cause) {
        super(cause);
    }

    public MineException newInstance(String msgFormat, Object... args) {
        return new MineException(this.code, msgFormat, args);
    }


}
