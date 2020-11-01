package ink.verge.lab.service;

import ink.verge.lab.controller.viewobject.DirectionVO;
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
    int updateDirectionVO(DirectionVO directionVO);
    List<Direction> getAllDirection();
    List<DirectionVO> getAllDirectionVO();
    Direction getDirectionById(int id);
    List<Direction> getDirectionByKeyword(String keyword);
    boolean insertDirectionWithPhotos(DirectionVO directionVO);
    DirectionVO getDirectionVOByID(int id);
    List<DirectionVO> getDirectionVOByKeyword(String keyword);
    List<String> getPhotoByDirId(int id);
    int deletePhotoByUrl(String url);
}
