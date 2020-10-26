package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Introduction;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/26 13:58
 * @Version 1.0
 */
public interface IntroductionService {
    int insertIntroduction(Introduction introduction);
    int deleteIntroduction(int id);
    int updateIntroduction(Introduction introduction);
    List<Introduction> getAllIntroduction();
    Introduction getIntroductionById(int id);
    List<Introduction> getIntroductionByKeyword(String keyword);
}
