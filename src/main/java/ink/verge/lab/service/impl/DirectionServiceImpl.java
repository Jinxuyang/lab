package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.DirectionMapper;
import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.mbg.model.DirectionExample;
import ink.verge.lab.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:54
 * @Version 1.0
 */
@Service
public class DirectionServiceImpl implements DirectionService {
    DirectionMapper directionMapper;

    @Autowired
    public void setDirectionMapper(DirectionMapper directionMapper) {
        this.directionMapper = directionMapper;
    }

    @Override
    public int insertDirection(Direction direction) {
        return directionMapper.insertSelective(direction);
    }

    @Override
    public int deleteDirection(int id) {
        return directionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateDirection(Direction direction) {
        return directionMapper.updateByPrimaryKeySelective(direction);
    }

    @Override
    public List<Direction> getAllDirection() {
        return directionMapper.selectByExample(new DirectionExample());
    }

    @Override
    public Direction getDirectionById(int id) {
        return directionMapper.selectByPrimaryKey(id);
    }
}
