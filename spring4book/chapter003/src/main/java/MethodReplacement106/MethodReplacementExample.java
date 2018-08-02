package MethodReplacement106;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    public static void main(String[] atgs) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("SpringConfiguration/config4.xml");
        ctx.refresh();
        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);

    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int x = 0; x < 10000; x++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();

        System.out.println("10000 invocation took: " + stopWatch.getTotalTimeMillis());
    }
}
