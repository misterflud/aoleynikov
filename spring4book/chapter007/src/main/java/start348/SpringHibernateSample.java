package start348;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by AOleynikov on 22.10.2018.
 */
public class SpringHibernateSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("app-context-annotation.xml");
        context.refresh();
        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        listContacts(contactDao.findAll());
    }
    public static void listContacts(List<Contact> contacts) {
        System.out.println("List contacts without details:");

        for (Contact contact: contacts) {
            System.out.println(contact);
        }
    }
}
