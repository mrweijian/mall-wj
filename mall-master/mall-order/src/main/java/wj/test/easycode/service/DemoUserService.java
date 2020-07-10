package wj.test.easycode.service;

import wj.test.easycode.entity.DemoUser;
import java.util.List;

/**
 * (DemoUser)表服务接口
 *
 * @author makejava
 * @since 2020-03-20 10:18:24
 */
public interface DemoUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    DemoUser queryById(String userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DemoUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param demoUser 实例对象
     * @return 实例对象
     */
    DemoUser insert(DemoUser demoUser);

    /**
     * 修改数据
     *
     * @param demoUser 实例对象
     * @return 实例对象
     */
    DemoUser update(DemoUser demoUser);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(String userid);

}