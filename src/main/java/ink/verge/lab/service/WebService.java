package ink.verge.lab.service;

import ink.verge.lab.controller.viewobject.DirectionVO;
import ink.verge.lab.controller.viewobject.HomePage;
import ink.verge.lab.mbg.model.Contact;
import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.mbg.model.Project;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/31 13:05
 * @Version 1.0
 */
public interface WebService {
    HomePage getHomePage() throws Exception;
    List<Introduction> getIntroductionList();
    List<DirectionVO> getDirectionList();
    List<Project> getProjectList();
    List<Contact> getContactList();

}
