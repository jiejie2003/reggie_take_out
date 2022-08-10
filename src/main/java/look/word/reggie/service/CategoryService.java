package look.word.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import look.word.reggie.pojo.entity.Category;

public interface CategoryService extends IService<Category> {
    //根据ID删除分类
    public void remove(Long id);
}
