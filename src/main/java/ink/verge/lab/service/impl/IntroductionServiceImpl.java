package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.IntroductionMapper;
import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.mbg.model.IntroductionExample;
import ink.verge.lab.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/26 14:00
 * @Version 1.0
 */
@Service
public class IntroductionServiceImpl implements IntroductionService {
    IntroductionMapper introductionMapper;

    @Autowired
    public void setIntroductionMapper(IntroductionMapper introductionMapper) {
        this.introductionMapper = introductionMapper;
    }

    @Override
    public int insertIntroduction(Introduction introduction) {
        return introductionMapper.insertSelective(introduction);
    }

    @Override
    public int deleteIntroduction(int id) {
        return introductionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateIntroduction(Introduction introduction) {
        return introductionMapper.updateByPrimaryKeySelective(introduction);
    }

    @Override
    public List<Introduction> getAllIntroduction() {
        return introductionMapper.selectByExample(new IntroductionExample());
    }

    @Override
    public Introduction getIntroductionById(int id) {
        return introductionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Introduction> getIntroductionByKeyword(String keyword) {
        IntroductionExample example = new IntroductionExample();
        example.createCriteria().andContentLike(keyword);
        return introductionMapper.selectByExample(example);
    }

    @Override
    public Introduction getIntroductionShowOnIndex() throws Exception{
        IntroductionExample example = new IntroductionExample();
        example.createCriteria().andIsShowOnHomeEqualTo(true);
        List<Introduction> list = introductionMapper.selectByExample(example);
        if (list.size() == 1){
            return list.get(0);
        } else {
            throw new Exception();
        }
    }
}
