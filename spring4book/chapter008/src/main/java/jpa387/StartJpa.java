package jpa387;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by AOleynikov on 24.12.2018.
 */
public class StartJpa {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("app-context-annotation.xml");
        context.refresh();
        ContactService contactService = context.getBean("jpaContactService", ContactService.class);
        listContacts(contactService.findAll(), "Listing contacts without details: ");
        listContacts(contactService.findAllWithDetail(), "Listing contacts with details: ");
    }

    private static void listContacts(List<Contact> contacts, String message) {
        System.out.println("");
        System.out.println(message);
        for (Contact contact: contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
