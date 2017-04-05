package ru.job4j;

import org.junit.Test;

/**
 * Created by Anton on 14.03.2017.
 */
public class BotTest {
    @Test
    public void whenThen() throws Exception {
        ServerBot serverBot = new ServerBot();
        serverBot.connect();
        ClientBot clientBot = new ClientBot();
        clientBot.chatting();
    }
}
