package com.geforce.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.geforce.dao.User;
import com.geforce.dao.UserQueryCondition;
import com.geforce.exception.UserNotExistException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author geforce
 * @date 2017/11/8
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping("signUp")
    public void signUp(HttpServletRequest request,User user) {
        //根据用户的选择进行用户注册或绑定，不论进行哪种操作，最后都应该得到一个用户的唯一标识，在
        //这里我们使用用户填写的用户名作为唯一标识来绑定服务提供商用户
        String userId = user.getUsername();
        providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
    }


    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){

        return user;
    }


    @ApiOperation(value = "创建用户",notes = "创建用户notes")
    @ApiImplicitParams({@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")})
    @PostMapping
    public User create(@Valid @RequestBody User user,BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> logger.info(error.getDefaultMessage()));
        }


        logger.info(user.getId());
        logger.info(user.getUsername());
        logger.info(user.getPassword());
        logger.info(""+user.getBirthday());

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors,@PathVariable String id) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                logger.info(error.getDefaultMessage());
            });
        }
        logger.info(id);
        logger.info(user.getId());
        logger.info(user.getUsername());
        logger.info(user.getPassword());
        logger.info(""+user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        logger.info(id);
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {

        logger.info(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        logger.info(""+pageable.getPageSize());
        logger.info(""+pageable.getPageNumber());
        logger.info(""+pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
//        throw new RuntimeException(id);
//        throw new UsernameNotFoundException(id);
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
