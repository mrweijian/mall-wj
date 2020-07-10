package wj.test.easycode.dao;

import org.springframework.web.bind.annotation.Mapping;
import wj.test.easycode.entity.DemoUser;
import java.util.List;

/**
 * (DemoUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-20 10:18:24
 */
public interface DemoUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    DemoUser queryById(String userid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DemoUser> queryAllByLimit(int offset, int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param demoUser 实例对象
     * @return 对象列表
     */
    List<DemoUser> queryAll(DemoUser demoUser);

    /**
     * 新增数据
     *
     * @param demoUser 实例对象
     * @return 影响行数
     */
    int insert(DemoUser demoUser);

    /**
     * 修改数据
     *
     * @param demoUser 实例对象
     * @return 影响行数
     */
    int update(DemoUser demoUser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(String userid);

}
