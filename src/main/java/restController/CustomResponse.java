package restController;

/**
 * Created by Harriet on 10/15/2019.
 */
public class CustomResponse {
    private Object Data;
    private String message;
    private boolean status;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "Data=" + Data +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
