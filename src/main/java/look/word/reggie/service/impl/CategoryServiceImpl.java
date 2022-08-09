package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import look.word.reggie.entity.Category;
import look.word.reggie.mapper.CategoryMapper;
import look.word.reggie.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
