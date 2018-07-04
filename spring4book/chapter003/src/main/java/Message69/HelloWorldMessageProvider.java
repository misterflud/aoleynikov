package Message69;

public class HelloWorldMessageProvider implements MessageProvider {
    String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMassage(String s) {
        this.message = s;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
