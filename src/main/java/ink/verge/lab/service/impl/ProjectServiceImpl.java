package ink.verge.lab.service.impl;

import ink.verge.lab.mbg.mapper.ProjectMapper;
import ink.verge.lab.mbg.model.Member;
import ink.verge.lab.mbg.model.MemberExample;
import ink.verge.lab.mbg.model.Project;
import ink.verge.lab.mbg.model.ProjectExample;
import ink.verge.lab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:57
 * @Version 1.0
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    ProjectMapper projectMapper;

    @Autowired
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public int insertProject(Project project) {
        return projectMapper.insertSelective(project);
    }

    @Override
    public int deleteProject(int id) {
        return projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateProject(Project project) {
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public List<Project> getAllProject() {
        return projectMapper.selectByExample(new ProjectExample());
    }

    @Override
    public Project getProjectById(int id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> getProjectByKeyWord(String keyword) {
        return null;
    }

    /*@Override
    public List<Project> getProjectByKeyWord(String keyword) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andNameLike(keyword);
        projectExample.or().andManagerLike(keyword);
        return null;
    }*/
}