package jpa387;

import java.util.List;

/**
 * Created by AOleynikov on 23.12.2018.
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Long id);
    void delete(Long id);
}
