package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.HomeNewsMapper;
import ink.verge.lab.mbg.model.HomeNews;
import ink.verge.lab.mbg.model.HomeNewsExample;
import ink.verge.lab.service.HomeNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/9 0:08
 * @Version 1.0
 */
@Service
public class HomeNewsServiceImpl implements HomeNewsService {
    HomeNewsMapper homeNewsMapper;

    @Autowired
    public void setHomeNewsMapper(HomeNewsMapper homeNewsMapper) {
        this.homeNewsMapper = homeNewsMapper;
    }

    @Override
    public int insertHomeNews(HomeNews homeNews) {
        return homeNewsMapper.insertSelective(homeNews);
    }

    @Override
    public int deleteHomeNews(int id) {
        return homeNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateHomeNews(HomeNews homeNews) {
        return homeNewsMapper.updateByPrimaryKeySelective(homeNews);
    }

    @Override
    public List<HomeNews> getAllHomeNews() {
        return homeNewsMapper.selectByExample(new HomeNewsExample());
    }

    @Override
    public HomeNews getHomeNewsById(int id) {
        return homeNewsMapper.selectByPrimaryKey(id);
    }
}
