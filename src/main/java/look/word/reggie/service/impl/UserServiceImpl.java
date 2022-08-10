package look.word.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import look.word.reggie.mapper.UserMapper;
import look.word.reggie.pojo.entity.User;
import look.word.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
