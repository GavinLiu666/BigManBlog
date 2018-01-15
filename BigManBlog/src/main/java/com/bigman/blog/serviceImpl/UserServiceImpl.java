package com.bigman.blog.serviceImpl;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Service;

import com.bigman.blog.bean.MicroBlog;
import com.bigman.blog.bean.User;
import com.bigman.blog.bean.User_info;
import com.bigman.blog.dao.MicroBlogDao;
import com.bigman.blog.dao.UserDao;
import com.bigman.blog.dao.UserInfoDao;
import com.bigman.blog.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao dao;

	public String login(String username, String password, HttpSession session) {
		User u = dao.findUserByName(username);
		if (u == null)
			return "user not exist";// 用户不存在
		else if (!password.equals(u.getPassword()))
			return "password not match";// 密码错误
		else {
			session.setAttribute("user", u);
			return "success"; // 登录成功
		}
	}

	/**
	 * 更换头像
	 */
	public String upload(HttpServletRequest request, HttpServletResponse response) {
		// 检测是否含有文件
		if (!ServletFileUpload.isMultipartContent(request)) {
			return "error";
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 超过后将产生临时文件存储于临时目录中
		factory.setSizeThreshold(THRESHOLD);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);
		// 设置请求最大值（包含文件和标单数据）
		upload.setSizeMax(MAX_REQUEST_SIZE);
		// 中文处理
		upload.setHeaderEncoding("utf-8");
		try {
			// 解析请求的内容提取文件数据
			List<FileItem> formItems = upload.parseRequest(new ServletRequestContext(request));
			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {
					if (!item.isFormField()) {
						String fileName = item.getName();
						String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
						// 以上传时间作为文件名
						String newFileName = System.currentTimeMillis() + "." + fileType;
						if (fileType.equals("jpg") || fileType.equals("jpeg") || fileType.equals("png")) {
							// 判断原文件是否存在，存在则删除
							HttpSession session = request.getSession();
							User user = (User) session.getAttribute("user");
							int id = user.getId();
							// 初始图片路径
							String filePath = user.getUser_pic();
							if (filePath != null) {
								new File(filePath).delete();// 删除原有图片
							}
							// 保存上传文件的路径
							filePath = UPLOAD + File.separator + newFileName;
							// 在控制台输出文件上传的路径
							item.write(new File(filePath));
							// 获取图片在服务器上的请求路径
							filePath = request.getContextPath() + "/img/" + newFileName;
							// 与homepage配合;
							dao.changePortrait(id, filePath);
							// 更新session中的数据
							user.setUser_pic(filePath);
							request.setAttribute("user", user);
							RequestDispatcher re = request.getRequestDispatcher("/user/home.do");
							re.forward(request, response);
						} else {
							throw new RuntimeException();
						}
					}
				}
			}
		} catch (Exception e) {
			// 若果异常则上传失败
			User u = (User) request.getSession().getAttribute("user");
			u.setUser_pic("/BigManBlog/img/1.jpg");
			RequestDispatcher re = request.getRequestDispatcher("/WEB-INF/jsp/homepage.jsp");
			try {
				re.forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return null;
	}

	// 上传文件存储目录
	private static final String UPLOAD = "/home/liuzhifeng/tupian";
	// 上传配置
	// 临界值
	private static final int THRESHOLD = 1024 * 1024 * 3;// 1MB
	// 最大文件
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 3;// 3MB
	// 请求最大值
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;// 50MB

	@Resource
	MicroBlogDao microDao;

	public void showHomePage(HttpSession session) {
		Object obj = session.getAttribute("user");
		User u = null;
		if (obj instanceof User) {
			u = (User) obj;
		}
		/* 获取用户所有短博文 */
		List<MicroBlog> MBlist = microDao.selectMicroBlog(u.getId());
		/* 按时间先后顺序，最新的在前 */
		MBlist.sort(new Comparator<MicroBlog>() {
			public int compare(MicroBlog m1, MicroBlog m2) {
				int n = m1.getcreate_time().compareTo(m2.getcreate_time());
				return -1 * n;
			}
		});
		session.setAttribute("mBlogs", MBlist);
	}

	@Resource
	private UserInfoDao userInfoDao;

	public boolean addAttend(Integer friendId, HttpSession session) {
		User u = (User) session.getAttribute("user");
		int myId = u.getId();
		Integer n = userInfoDao.addAttend(myId, friendId);
		if(n==1)return true;
		return false;
	}

	public User_info findUserInfoByName(String name) {
		User_info u = userInfoDao.findUserInfoByName(name);
		return u;
	}

	public boolean isAttend(Integer myId, Integer attendId,HttpSession session) {

		int n = userInfoDao.isAttendFans(myId, attendId);
		if (n == 1) {
			session.setAttribute("isAttend", true);
			session.setAttribute("myName_is_friendName_fans", "btn btn-success btn-block");
			session.setAttribute("myName_is_friendName_fans_test", "已关注");
			return true;
		}
		session.setAttribute("isAttend", false);
		session.setAttribute("myName_is_friendName_fans", "btn btn-primary btn-block");
		session.setAttribute("myName_is_friendName_fans_test", "关注");
		return false;
	}

	public boolean rmAttend(Integer friendId, HttpSession session) {
		User u = (User) session.getAttribute("user");
		int myId = u.getId();
		Integer n = userInfoDao.cancelAttend(myId, friendId);
		if(n==1)return true;
		return false;
	}

	
}
