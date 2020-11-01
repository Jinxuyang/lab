package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.ContactMapper;
import ink.verge.lab.mbg.model.Contact;
import ink.verge.lab.mbg.model.ContactExample;
import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:45
 * @Version 1.0
 */
@Service
public class ContactServiceImpl implements ContactService {
    ContactMapper contactMapper;

    @Autowired
    public void setContactMapper(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public int insertContact(Contact contact) {
        return contactMapper.insertSelective(contact);
    }

    @Override
    public int deleteContact(int id) {
        return contactMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateContact(Contact contact) {
        return contactMapper.updateByPrimaryKeySelective(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactMapper.selectByExample(new ContactExample());
    }

    @Override
    public Contact getContactById(int id) {
        return contactMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Contact> getContactByKeyword(String keyword) {
        ContactExample example = new ContactExample();
        example.createCriteria().andAddressLike(keyword);
        example.or().andEmailLike(keyword);
        return contactMapper.selectByExample(example);
    }

    @Override
    public Contact getContactShowOnIndex() throws Exception {
        ContactExample example = new ContactExample();
        example.createCriteria().andIsShowOnHomeEqualTo(true);
        List<Contact> list  = contactMapper.selectByExample(example);
        if (list.size() == 1){
            return list.get(0);
        } else {
            throw new Exception();
        }
    }
}
