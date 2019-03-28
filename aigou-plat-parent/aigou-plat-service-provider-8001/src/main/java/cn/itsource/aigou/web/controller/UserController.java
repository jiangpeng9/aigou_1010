package cn.itsource.aigou.web.controller;

import cn.itsource.aigou.common.AjaxResult;
import cn.itsource.aigou.domain.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plat")
public class UserController {
    /**
     *
     * @return  @RequestBody 把前台提交的body的参数封装到user对象中
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){
        //模拟前台传入数据
        if(user != null && !StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword())){
            if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
                return AjaxResult.me().setMsg("登陆成功");
            }else{
                return AjaxResult.me().setMsg("登陆失败").setSuccess(false);
            }
        }
        return AjaxResult.me().setMsg("登陆失败").setSuccess(false);
    }
}
