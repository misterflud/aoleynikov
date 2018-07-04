package Message69;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main (String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("Message69/SpringConfiguration/config2.xml");
        ctx.refresh();
        MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
//        System.out.println(messageProvider.getMessage());
        MessageRenderer messageRenderer = ctx.getBean ( "messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
