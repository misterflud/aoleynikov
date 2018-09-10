package javaConfiguration177.configurationClasses;

import javaConfiguration177.ConfigurableMessageProvider;
import javaConfiguration177.MessageProvider;
import javaConfiguration177.MessageRenderer;
import javaConfiguration177.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by AOleynikov on 05.09.2018.
 */
@Configuration
public class AppConfig {
    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer()
    {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }

}
