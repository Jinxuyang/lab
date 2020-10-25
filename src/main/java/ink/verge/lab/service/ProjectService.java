package ink.verge.lab.service;

import ink.verge.lab.mbg.model.Member;
import ink.verge.lab.mbg.model.Project;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/8 23:42
 * @Version 1.0
 */
public interface ProjectService {
    int insertProject(Project project);
    int deleteProject(int id);
    int updateProject(Project project);
    List<Project> getAllProject();
    Project getProjectById(int id);
    List<Project> getProjectByKeyWord(String keyword);
}
