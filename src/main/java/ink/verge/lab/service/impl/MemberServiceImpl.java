package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.MemberMapper;
import ink.verge.lab.mbg.model.Member;
import ink.verge.lab.mbg.model.MemberExample;
import ink.verge.lab.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    @Autowired
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public int insertMember(Member member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public int deleteMember(int id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public List<Member> getAllMember() {
        return memberMapper.selectByExample(new MemberExample());
    }

    @Override
    public Member getMemberById(int id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Member> getMemberByKeyWord(String keyword) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andNameLike(keyword);
        memberExample.or().andIntroductionLike(keyword);
        memberExample.or().andPositionLike(keyword);
        return memberMapper.selectByExample(memberExample);
    }
}
