package look.word.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.R;
import look.word.reggie.common.aop.LogAnnotation;
import look.word.reggie.entity.Category;
import look.word.reggie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param category
     * @return
     */
    @LogAnnotation(module = "新增分类", operation = "新增分类")
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页查询
     */
    @LogAnnotation(module = "分类分页", operation = "分类分页")
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        //分页构造器
        Page<Category> pageInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);

        //分页查询
        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id删除分类
     */
    @DeleteMapping
    public R<String> delete(Long id) {
        log.info("删除分类，id为：{}", id);
        categoryService.removeById(id);
        return R.success("分类信息删除成功");
    }
}
