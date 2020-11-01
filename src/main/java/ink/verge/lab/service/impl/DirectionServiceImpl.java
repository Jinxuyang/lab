package ink.verge.lab.service.impl;

import ink.verge.lab.controller.viewobject.DirectionVO;
import ink.verge.lab.mbg.mapper.DirectionMapper;
import ink.verge.lab.mbg.model.Direction;
import ink.verge.lab.mbg.model.DirectionExample;
import ink.verge.lab.service.DirectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public List<DirectionVO> getAllDirectionVO() {
        List<Direction> directionList = directionMapper.selectByExample(new DirectionExample());
        List<DirectionVO> directionVOList = new ArrayList<>();
        for (Direction direction : directionList) {
            DirectionVO directionVO = new DirectionVO();
            BeanUtils.copyProperties(direction,directionVO);
            List<String> urlList = directionMapper.selectPhotoById(direction.getId());
            directionVO.setPhotos(urlList);
            directionVOList.add(directionVO);
        }
        return directionVOList;
    }

    @Override
    public boolean insertDirectionWithPhotos(DirectionVO directionVO) {
        Direction direction = new Direction();
        BeanUtils.copyProperties(directionVO,direction);
        List<String> urlList = directionVO.getPhotos();
        if (insertDirection(direction) == 1){
            boolean flag = true;
            for (String url : urlList) {
                if (directionMapper.insertPhotoById(direction.getId(),url) != 1) flag = false;
            }
            return flag;
        }
        return false;
    }

    @Override
    public DirectionVO getDirectionVOByID(int id) {
        Direction direction = getDirectionById(id);
        DirectionVO directionVO = new DirectionVO();
        List<String> urlList = getPhotoByDirId(id);
        BeanUtils.copyProperties(direction,directionVO);
        directionVO.setPhotos(urlList);
        return directionVO;
    }

    @Override
    public List<DirectionVO> getDirectionVOByKeyword(String keyword) {
        DirectionExample example = new DirectionExample();
        example.createCriteria().andNameLike(keyword);
        example.or().andIntroductionLike(keyword);
        List<Direction> list = directionMapper.selectByExample(example);
        List<DirectionVO> directionVOList = new ArrayList<>();
        for (Direction direction : list) {
            List<String> urlList = getPhotoByDirId(direction.getId());
            DirectionVO directionVO = new DirectionVO();
            BeanUtils.copyProperties(direction,directionVO);
            directionVO.setPhotos(urlList);
            directionVOList.add(directionVO);
        }
        return directionVOList;
    }

    @Override
    public List<String> getPhotoByDirId(int id) {
        return directionMapper.selectPhotoById(id);
    }

    @Override
    public int deleteDirection(int id) {
        directionMapper.deletePhotoById(id);
        return directionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateDirectionVO(DirectionVO directionVO) {
        List<String> urlList = directionVO.getPhotos();
        for (String url : urlList) {
            directionMapper.insertPhotoById(directionVO.getId(),url);
        }
        Direction direction = new Direction();
        BeanUtils.copyProperties(directionVO,direction);
        return directionMapper.updateByPrimaryKeySelective(direction);
    }

    @Override
    public int deletePhotoByUrl(String url) {
        return directionMapper.deletePhotoByUrl(url);
    }

    @Override
    public List<Direction> getAllDirection() {
        return directionMapper.selectByExample(new DirectionExample());
    }

    @Override
    public Direction getDirectionById(int id) {
        return directionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Direction> getDirectionByKeyword(String keyword) {
        DirectionExample example = new DirectionExample();
        example.createCriteria().andIntroductionLike(keyword);
        example.or().andNameLike(keyword);
        return directionMapper.selectByExample(example);
    }

}
