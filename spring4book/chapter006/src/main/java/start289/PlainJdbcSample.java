package start289;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by AOleynikov on 03.10.2018.
 */
public class PlainJdbcSample {
    private static ContactDao contactDao = new PlainContactDao();
    public static void main(String[] args) {
        System.out.println("Listing initial contact data:");
        listAllContacts();

        System.out.println("Insert new contact");
        Contact contact = new Contact();
        contact.setFirstName("Nikita");
        contact.setLastName("Babakin7");
        contact.setBirthDate(new Date(new GregorianCalendar(1990, 10, 1).getTime().getTime()));
        contactDao.insert(contact);
        System.out.println("After adding new contact:");

        listAllContacts();
        System.out.println("Delete contact");
        contactDao.delete(contact.getId());
        System.out.println("After deleting new contact:");
        listAllContacts();

        contactDao.delete(new Long(7));
    }

    private static void listAllContacts() {
        List<Contact> contacts = contactDao.findAll();

        for (Contact contact: contacts) {
            System.out.println(contact);
        }
    }
}
