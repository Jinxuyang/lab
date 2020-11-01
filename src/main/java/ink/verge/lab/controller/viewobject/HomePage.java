package ink.verge.lab.controller.viewobject;

import ink.verge.lab.mbg.model.Contact;
import ink.verge.lab.mbg.model.HomeNews;
import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.mbg.model.Member;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/31 13:02
 * @Version 1.0
 */
@Component
public class HomePage {
    private List<HomeNews> homeNewsList;
    private Member leader;
    private Introduction introduction;
    private Contact contact;
    private List<Member> memberList;

    public List<HomeNews> getHomeNewsList() {
        return homeNewsList;
    }

    public void setHomeNewsList(List<HomeNews> homeNewsList) {
        this.homeNewsList = homeNewsList;
    }

    public Member getLeader() {
        return leader;
    }

    public void setLeader(Member leader) {
        this.leader = leader;
    }

    public Introduction getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String  toString() {
        return "HomePage{" +
                "homeNewsList=" + homeNewsList +
                ", leader=" + leader +
                ", introduction=" + introduction +
                ", contact=" + contact +
                ", memberList=" + memberList +
                '}';
    }
}
