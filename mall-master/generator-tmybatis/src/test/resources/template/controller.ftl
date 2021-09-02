package ${basePackage}.web;
import ${basePackage}.domain.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import io.swagger.annotations.ApiOperation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by gang.tu on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PreAuthorize("@ss.hasPermi('${modelNameUpperCamel}:add')")
    @ApiOperation("新增")
    @Log(title = "新增${modelNameUpperCamel}", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public Result add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PreAuthorize("@ss.hasPermi('${modelNameUpperCamel}:delete')")
    @ApiOperation("删除")
    @Log(title = "删除${modelNameUpperCamel}", businessType = BusinessType.DELETE)
    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PreAuthorize("@ss.hasPermi('${modelNameUpperCamel}:update')")
    @ApiOperation("修改")
    @Log(title = "修改${modelNameUpperCamel}", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public Result update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PreAuthorize("@ss.hasPermi('${modelNameUpperCamel}:detail')")
    @ApiOperation("获取详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @PreAuthorize("@ss.hasPermi('${modelNameUpperCamel}:list')")
    @ApiOperation("获取列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer currPage, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult();
    }
}
