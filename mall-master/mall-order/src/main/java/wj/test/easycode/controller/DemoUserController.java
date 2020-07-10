package wj.test.easycode.controller;

import wj.test.easycode.entity.DemoUser;
import wj.test.easycode.service.DemoUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DemoUser)表控制层
 *
 * @author makejava
 * @since 2020-03-20 10:18:25
 */
@RestController
@RequestMapping("demoUser")
public class DemoUserController {
    /**
     * 服务对象
     */
    @Resource
    private DemoUserService demoUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DemoUser selectOne(String id) {
        return this.demoUserService.queryById(id);
    }

}