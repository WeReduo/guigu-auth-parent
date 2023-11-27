import com.atguigu.model.system.SysRole;
import com.atguigu.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class SysRoleMappperTest {
    @Resource
private SysRoleMapper sysRoleMapper;

//    pulic void testAdd(){
//
//    }
    @Test
    public void testAdd(){
         SysRole sysRole=new SysRole();
         sysRole.setRoleName("测试1");
//         sysRole.getRoleCode("111");
         sysRole.setDescription("111");
//         System.out.println(rows);

         sysRoleMapper.insert(sysRole);
    }
        @Test
        public void findAll(){
        List<SysRole> list=sysRoleMapper.selectList(null);
       list.forEach(System.out::println);
    }


}
