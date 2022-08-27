package mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author John.Cena
 * @date 2022/8/25 10:56
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findMyUser(Long id);
}
