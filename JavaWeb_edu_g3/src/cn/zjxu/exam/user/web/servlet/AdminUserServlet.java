package cn.zjxu.exam.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.zjxu.exam.user.domain.User;
import cn.zjxu.exam.user.service.UserException;
import cn.zjxu.exam.user.service.UserService;


public class AdminUserServlet extends UserServlet {
	private UserService userService = new UserService();
	
    /**
     * 编辑之前的加载工作
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String preEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 获取id
         * 2. 使用id来调用service方法，得到user对象
         * 3. 把user保存到request域中
         * 4. 转发到edit.jsp显示在表单中
         */
        String id = request.getParameter("id");
        System.out.println(id);
        User user = userService.findById(id);
        request.setAttribute("user", user);
        return "f:/adminjsps/admin/user/edit.jsp";
    }
	
	/**
	 * 编辑信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("editing");
        /*
         * 1. 封装表单数据
         * 2. 调用service方法完成修改工作
         * 3. 调用findAll
         */
        User user = CommonUtils.toBean(request.getParameterMap(), User.class);
        System.out.println(user.getId());
        userService.Edit(user);
        return findAll(request, response);
    }
	
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 获取参数:id
         * 2. 调用service方法，传递id参数
         *   > 如果抛出异常，保存异常信息，转发到msg.jsp显示
         * 3. 调用findAll()
         */
        String id = request.getParameter("id");
        
        request.setAttribute("mark", userService.getMark(id));
        
        userService.delete(id);
        return findAll(request, response);
    }

	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
    public String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 封装表单数据
         * 2. 补全：id
         * 3. 调用service方法完成添加工作
         * 4. 调用findAll()
         */
        User user = CommonUtils.toBean(request.getParameterMap(), User.class);
        user.setId(CommonUtils.uuid());
        
        try {
			userService.regist(user);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
            return "f:/adminjsps/msg.jsp";
		}
        
        return findAll(request, response);
    }
    
    /**
     * 查询所有
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 调用service方法，得到所有分类
         * 2. 保存到request域，转发到/adminjsps/admin/list.jsp
         */
    	int mark = 2;
    	if(request.getParameter("mark") != null){
    		mark = Integer.parseInt(request.getParameter("mark"));
    		System.out.println("----"+mark);
    	} else {
    		mark = Integer.parseInt(String.valueOf(request.getAttribute("mark")));
    	}
        request.setAttribute("UserList", userService.findAll(mark));
        return "f:/adminjsps/admin/list.jsp";
    }
}
