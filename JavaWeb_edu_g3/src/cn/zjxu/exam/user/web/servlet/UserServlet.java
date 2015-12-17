package cn.zjxu.exam.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.zjxu.exam.user.domain.User;
import cn.zjxu.exam.user.service.UserException;
import cn.zjxu.exam.user.service.UserService;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	/**
     * 退出功能
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String quit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        return "r:/index.jsp";
    }
    
    public String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 封装表单数据到form中
         * 2. 输入校验
         * 3. 调用service完成激活
         *   > 保存错误信息、form到request，转发到login.jsp
         * 4. 保存用户信息到session中，然后重定向到index.jsp
         */
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        
        String sessionCode = (String) request.getSession().getAttribute("session_vcode");
		String paramCode = request.getParameter("verifyCode");
		if(!paramCode.equalsIgnoreCase(sessionCode)){
			request.setAttribute("msg", "验证码错误！");
			return "f:/jsps/user/login.jsp";
		}
        
        try {
            User user = userService.login(form);
            request.getSession().setAttribute("session_user", user);
            return "r:/index.jsp";
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/jsps/user/login.jsp";
        }
    }
    
    /**
     * 注册功能
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 封装表单数据到form对象中
         * 2. 补全：id、
         * 3. 输入校验
         *   > 保存错误信息、form到request域，转发到regist.jsp
         * 4. 调用service方法完成注册
         *   > 保存错误信息、form到request域，转发到regist.jsp
         * 5. 保存成功信息转发到msg.jsp
         */
        // 封装表单数据
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        // 补全
        form.setId(CommonUtils.uuid());
        form.setMark(2);//默认为学生
        /*
         * 输入校验
         * 1. 创建一个Map，用来封装错误信息，其中key为表单字段名称，值为错误信息
         */
        Map<String,String> errors = new HashMap<String,String>();
        /*
         * 2. 获取form中的username、password、email进行校验
         */
        String username = form.getName();
        if(username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if(username.length() < 3 || username.length() > 10) {
            errors.put("username", "用户名长度必须在3~10之间！");
        }
        
        String password = form.getPassword();
        if(password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if(password.length() < 3 || password.length() > 10) {
            errors.put("password", "密码长度必须在3~10之间！");
        }
        
        String sessionCode = (String) request.getSession().getAttribute("session_vcode");
		String paramCode = request.getParameter("verifyCode");
		if(!paramCode.equalsIgnoreCase(sessionCode)){
			errors.put("verifyCode", "验证码错误！");
		}
        
        /*
         * 3. 判断是否存在错误信息
         */
        if(errors.size() > 0) {
            // 1. 保存错误信息
            // 2. 保存表单数据
            // 3. 转发到regist.jsp
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/jsps/user/regist.jsp";
        }
                
        /*
         * 调用service的regist()方法
         */
        try {
            userService.regist(form);
        } catch (UserException e) {
            /*
             * 1. 保存异常信息
             * 2. 保存form
             * 3. 转发到regist.jsp
             */
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/jsps/user/regist.jsp";
        }
         
        
        /*
         * 1. 保存成功信息
         * 2. 转发到msg.jsp
         */
        request.setAttribute("msg", "恭喜，注册成功！");
        return "f:/jsps/msg.jsp";
    }
	
}
