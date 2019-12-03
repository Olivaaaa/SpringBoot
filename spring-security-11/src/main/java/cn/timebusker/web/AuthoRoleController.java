package cn.timebusker.web;

import cn.timebusker.model.UserEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthoRoleController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/authRole")
    public String role(){
        return "admin auth";
    }

    // 匹配校验（执行前校验(PreAuthorize)，执行后校验(PostAuthorize)）
    @PreAuthorize("#id<10 and principal.username.equals(#username) and #user.username.equals('abc')")
    @PostAuthorize("returnObject%2==0")
    @RequestMapping("/grep")
    public Integer test(Integer id, String username, UserEntity user) {
        // ...
        return id;
    }

    @PreFilter("filterObject%2==0")
    @PostFilter("filterObject%4==0")
    @RequestMapping("/test2")
    public List<Integer> test2(List<Integer> idList) {
        // ...
        return idList;
    }

}
