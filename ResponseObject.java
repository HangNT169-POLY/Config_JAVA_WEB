package com.toandev.buoi2.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject <T> {

    private boolean isSuccess;
    private T data;
    private String message;

    private static final String DEFAULT_SUCCESS_MESSAGE = "Yêu cầu xử lý thành công.";
    private static final String DEFAULT_ERROR_MESSAGE = "Không tìm thấy dữ liệu.";

    //Constructor mặc định khi có dữ liệu:
    public ResponseObject(T obj) {
        processResponseObject(obj, DEFAULT_SUCCESS_MESSAGE);
    }

    //Constructor có thông báo tùy chỉnh:
    public ResponseObject(T obj, String message){
        processResponseObject(obj, message);
    }

    //Constructor đầy đủ 3 tham số:
    public ResponseObject(boolean isSuccess, T data, String message) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.message = message;
    }

    //Xử lý dữ liệu và thông báo:
    public void processResponseObject(T obj, String message) {
        if(obj != null) {
            this.isSuccess = true;
            this.data = obj;
            this.message = message != null ? message : DEFAULT_SUCCESS_MESSAGE;
        } else {
            this.isSuccess = false;
            this.data = null;
            this.message = message != null ? message : DEFAULT_ERROR_MESSAGE;
        }
    }

    //Phản hồi lỗi:
    public static ResponseObject error(String errorMessage) {
        return new ResponseObject(false, null, errorMessage);
    }

    //Phản hồi thành công:
    public static ResponseObject success(Object data, String message) {
        return new ResponseObject(true, data, message);
    }

}
