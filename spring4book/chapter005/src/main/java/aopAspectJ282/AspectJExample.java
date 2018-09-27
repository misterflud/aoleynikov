package aopAspectJ282;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by AOleynikov on 26.09.2018.
 */
public class AspectJExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("aopAspectJContext282.xml");
        MessageWriter writer = (MessageWriter) context.getBean("dd");
        writer.writeMessage();
//        MessageWriter messageWriter = new MessageWriter();
//        messageWriter.writeMessage();
//        messageWriter.foo();
    }
}
