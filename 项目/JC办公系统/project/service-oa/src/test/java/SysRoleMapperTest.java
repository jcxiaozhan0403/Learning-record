import com.jc.auth.ServiceAuthApplication;
import com.jc.auth.mapper.SysRoleMapper;
import com.jc.model.system.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author John.Cena
 * @date 2023/3/9 19:44
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAuthApplication.class)
public class SysRoleMapperTest {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Test
    public void tset(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        for(SysRole sysRole: sysRoles){
            System.out.println(sysRole.toString());
        }
    }
}
