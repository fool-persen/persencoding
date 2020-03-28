package cn.px.pressure.test;

public class ResultBody {
    /**
     * http状态码（200，404，500）
     */
    private int code = 200;
    /**
     * 接口响应状态（true【成功】，false【失败-对应errorInfo错误信息】）
     */
    private Boolean success = true;
    /**
     * 自定义错误码
     */
    private Integer errorCode;
    /**
     * 错误说明
     */
    private String errorMsg;
    /**
     * 数据
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "code=" + code +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
