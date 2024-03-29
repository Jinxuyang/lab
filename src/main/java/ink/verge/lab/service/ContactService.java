package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Contact;
import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.mbg.model.Introduction;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:38
 * @Version 1.0
 */
public interface ContactService {
    int insertContact(Contact contact);
    int deleteContact(int id);
    int updateContact(Contact contact);
    List<Contact> getAllContact();
    Contact getContactById(int id);
    List<Contact> getContactByKeyword(String keyword);
    Contact getContactShowOnIndex() throws Exception;
}
