
package look.word.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import look.word.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
