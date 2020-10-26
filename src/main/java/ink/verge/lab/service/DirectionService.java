package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Direction;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:41
 * @Version 1.0
 */
public interface DirectionService {
    int insertDirection(Direction direction);
    int deleteDirection(int id);
    int updateDirection(Direction direction);
    List<Direction> getAllDirection();
    Direction getDirectionById(int id);
    List<Direction> getDirectionByKeyword(String keyword);
}
