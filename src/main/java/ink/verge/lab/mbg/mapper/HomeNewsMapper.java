package ink.verge.lab.mbg.mapper;

import ink.verge.lab.mbg.model.HomeNews;
import ink.verge.lab.mbg.model.HomeNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeNewsMapper {
    long countByExample(HomeNewsExample example);

    int deleteByExample(HomeNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HomeNews record);

    int insertSelective(HomeNews record);

    List<HomeNews> selectByExample(HomeNewsExample example);

    HomeNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HomeNews record, @Param("example") HomeNewsExample example);

    int updateByExample(@Param("record") HomeNews record, @Param("example") HomeNewsExample example);

    int updateByPrimaryKeySelective(HomeNews record);

    int updateByPrimaryKey(HomeNews record);
}