package ink.verge.lab.mbg.mapper;

import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.mbg.model.DirectionExample;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionMapper {
    long countByExample(DirectionExample example);

    int deleteByExample(DirectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Direction record);

    int insertSelective(Direction record);

    List<Direction> selectByExample(DirectionExample example);

    Direction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Direction record, @Param("example") DirectionExample example);

    int updateByExample(@Param("record") Direction record, @Param("example") DirectionExample example);

    int updateByPrimaryKeySelective(Direction record);

    int updateByPrimaryKey(Direction record);

    int insertPhotoById(@Param("id") int id,@Param("url") String url);

    List<String> selectPhotoById(@Param("id") Integer id);

    int deletePhotoById(Integer id);

    int deletePhotoByUrl(String url);
}