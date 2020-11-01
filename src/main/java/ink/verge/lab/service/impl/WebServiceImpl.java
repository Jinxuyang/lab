package ink.verge.lab.service.impl;

import ink.verge.lab.controller.viewobject.DirectionVO;
import ink.verge.lab.controller.viewobject.HomePage;
import ink.verge.lab.mbg.model.Contact;
import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.mbg.model.Project;
import ink.verge.lab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/31 13:08
 * @Version 1.0
 */
@Service
public class WebServiceImpl implements WebService {
    private HomeNewsService homeNewsService;
    private DirectionService directionService;
    private ProjectService projectService;
    private ContactService contactService;
    private IntroductionService introductionService;
    private MemberService memberService;
    @Autowired
    public WebServiceImpl(HomeNewsService homeNewsService, DirectionService directionService, ProjectService projectService, ContactService contactService, IntroductionService introductionService, MemberService memberService) {
        this.homeNewsService = homeNewsService;
        this.directionService = directionService;
        this.projectService = projectService;
        this.contactService = contactService;
        this.introductionService = introductionService;
        this.memberService = memberService;
    }

    @Override
    public HomePage getHomePage() throws Exception{
        HomePage homePage = new HomePage();
        homePage.setHomeNewsList(homeNewsService.getAllHomeNews());
        homePage.setContact(contactService.getContactShowOnIndex());
        homePage.setIntroduction(introductionService.getIntroductionShowOnIndex());
        homePage.setMemberList(memberService.getAllMember());
        homePage.setLeader(memberService.getLeader());
        return homePage;
    }

    @Override
    public List<Introduction> getIntroductionList() {
        return introductionService.getAllIntroduction();
    }

    @Override
    public List<DirectionVO> getDirectionList() {
        return directionService.getAllDirectionVO();
    }

    @Override
    public List<Project> getProjectList() {
        return projectService.getAllProject();
    }

    @Override
    public List<Contact> getContactList() {
        return contactService.getAllContact();
    }
}
