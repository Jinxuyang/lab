package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.mbg.model.HomeNews;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:43
 * @Version 1.0
 */
public interface HomeNewsService {
    int insertHomeNews(HomeNews homeNews);
    int deleteHomeNews(int id);
    int updateHomeNews(HomeNews homeNews);
    List<HomeNews> getAllHomeNews();
    HomeNews getHomeNewsById(int id);
    List<HomeNews> getHomeNewsByKeyword(String keyword);
}
