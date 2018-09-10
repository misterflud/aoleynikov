package javaConfiguration177;

/**
 * Created by AOleynikov on 05.09.2018.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
