package start348;

import java.util.List;

/**
 * Created by AOleynikov on 22.10.2018.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
