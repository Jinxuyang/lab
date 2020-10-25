package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Member;

import java.util.List;

public interface MemberService {
    /**
     * 插入成员
     * @param member
     * @return
     */
    int insertMember(Member member);

    /**
     * 删除成员
     * @param id
     * @return
     */
    int deleteMember(int id);

    /**
     * 更新成员信息
     * @param member
     * @return
     */
    int updateMember(Member member);

    /**
     * 查询所有成员
     * @return
     */
    List<Member> getAllMember();

    /**
     * 通过Id查找成员
     * @param id
     * @return
     */
    Member getMemberById(int id);

    /**
     * 通过关键词查找成员
     * @return
     */
    List<Member> getMemberByKeyWord(String keyword);
}
