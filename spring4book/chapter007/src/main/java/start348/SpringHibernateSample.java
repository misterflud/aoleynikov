package start348;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
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
        contactDao.save(getNewContact());
        listContactsWithDetails(contactDao.findAll());
        contactDao.save(updateContact(contactDao.findById(4)));
        //        listContacts(contactDao.findAll());
//        contactById(contactDao.findById(1));
//        contactDao.save(getNewContact());
        listContactsWithDetails(contactDao.findAll());
        contactDao.delete(contactDao.findById(4));
        listContactsWithDetails(contactDao.findAll());

    }
    public static void listContacts(List<Contact> contacts) {
        System.out.println("List contacts without details:");

        for (Contact contact: contacts) {
            System.out.println(contact);
        }
    }

    private static void listContactsWithDetails(List<Contact> contacts) {
        System.out.println("List contacts with details:");

        for (Contact contact: contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                contact.getContactTelDetails().forEach(conDet -> {
                    if (conDet != null) {
                        System.out.println(conDet);
                    }});
            }
            if (contact.getHobbies() != null) {
                contact.getHobbies().forEach(hobby -> {
                    if (hobby != null) {
                        System.out.println(hobby);
                    }});
            }
        }
    }

    private static void contactById(Contact contact) {
        System.out.println("Contact with details:");
        System.out.println(contact);
    }

    private static Contact getNewContact() {
        Contact contact = new Contact();
        contact.setBirthDate(new Date());
        contact.setFirstName("Anton");
        contact.setLastName("OOOOOOOOOOOOO");

        ContactTelDetail contactTelDetail1 = new ContactTelDetail();
        contactTelDetail1.setTelNumber("12311113323");
        contactTelDetail1.setTelType("Home");

        ContactTelDetail contactTelDetail2 = new ContactTelDetail();
        contactTelDetail2.setTelNumber("123112313");
        contactTelDetail2.setTelType("Work");
        contact.addContactTelDetail(contactTelDetail1);
        contact.addContactTelDetail(contactTelDetail2);
        return contact;
    }

    private static Contact updateContact(Contact contact) {
        contact.setLastName("Oleynikov");
        return contact;
    }

}
