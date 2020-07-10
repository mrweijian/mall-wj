package wj.test.easycode.service.impl;

import wj.test.easycode.entity.DemoUser;
import wj.test.easycode.dao.DemoUserDao;
import wj.test.easycode.service.DemoUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DemoUser)表服务实现类
 *
 * @author makejava
 * @since 2020-03-20 10:18:24
 */
@Service("demoUserService")
public class DemoUserServiceImpl implements DemoUserService {
    @Resource
    private DemoUserDao demoUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public DemoUser queryById(String userid) {
        return this.demoUserDao.queryById(userid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DemoUser> queryAllByLimit(int offset, int limit) {
        return this.demoUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param demoUser 实例对象
     * @return 实例对象
     */
    @Override
    public DemoUser insert(DemoUser demoUser) {
        this.demoUserDao.insert(demoUser);
        return demoUser;
    }

    /**
     * 修改数据
     *
     * @param demoUser 实例对象
     * @return 实例对象
     */
    @Override
    public DemoUser update(DemoUser demoUser) {
        this.demoUserDao.update(demoUser);
        return this.queryById(demoUser.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userid) {
        return this.demoUserDao.deleteById(userid) > 0;
    }
}