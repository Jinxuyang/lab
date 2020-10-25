package ink.verge.lab.mbg.mapper;

import ink.verge.lab.mbg.model.Introduction;
import ink.verge.lab.mbg.model.IntroductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroductionMapper {
    long countByExample(IntroductionExample example);

    int deleteByExample(IntroductionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Introduction record);

    int insertSelective(Introduction record);

    List<Introduction> selectByExample(IntroductionExample example);

    Introduction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Introduction record, @Param("example") IntroductionExample example);

    int updateByExample(@Param("record") Introduction record, @Param("example") IntroductionExample example);

    int updateByPrimaryKeySelective(Introduction record);

    int updateByPrimaryKey(Introduction record);
}