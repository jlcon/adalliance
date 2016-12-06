package com.wy.adalliance.action.manager.menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wy.adalliance.action.ExtAction;
import com.wy.adalliance.biz.menuservice.MenuService;
import com.wy.adalliance.dal.mybatis.model.MenuInfo;
import com.wy.adalliance.util.FormatUtil;

@Controller
@RequestMapping("/manager/menu")
public class MenuAction extends ExtAction{
	
	@Autowired
	private MenuService menuService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/getMenu")
	public String getMenu(ModelMap model){
		String debugstr = menuService.getMenu();
		logger.debug("获取菜单信息json：{}",FormatUtil.formatJson(debugstr));
		model.put("json", debugstr);
		return "json";
	}
	
	/**
	 * @Description:跳转链接
	 * @param code
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping("/toPage")
	public String toPage(String code,HttpServletResponse response,HttpServletRequest request){
		logger.info("收到原始URL：{}",code);
		if(code.startsWith("redirect:")){
			try {
				String tmp = StringUtils.substringAfter(code, "redirect:");
				logger.info("跳转外部地址：{}",tmp);
				if(!tmp.equals("#")&&StringUtils.isNotBlank(tmp)){
					response.sendRedirect(tmp);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return "fail.vm";
			}
		} else {
			try {
				logger.info("跳转内部地址：{}",code);
				request.getServletContext().getRequestDispatcher(code).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
				return "fail.vm";
			} catch (IOException e) {
				e.printStackTrace();
				return "fail.vm";
			}
		}
		return null;
	}
	
	/**
	 * /manager/menu/toMenuManagePage.htm
	 * @Description:
	 * @return
	 */
	@RequestMapping("/toMenuManagePage")
	public String toMenuManagePage(){
		return "/manager/MenuManager/MenuManager";
	}
	
	/**
	 * 
	 * @Description:根据节点ID获取节点信息
	 * @param map
	 * @param menuId
	 * @return
	 */
	@RequestMapping("/getNodeById")
	public String getNodeById(ModelMap map,String menuId){
		
		MenuInfo menuinfo = menuService.getNodeById(menuId);
		String debugString = buildForm(menuinfo, true);
		logger.debug("通过id获取Node返回json数据是：{}",debugString);
		map.put("json", debugString);
//		map.put("json", buildForm(menuinfo, true));
		
		return "json";
	}
	
	/**
	 * 
	 * @Description:更加nodeid更新node信息
	 * @param node
	 * @param map
	 * @return
	 */
	@RequestMapping("/updateNodeById")
	public String updateNodeById(MenuInfo node,ModelMap map){
		logger.debug("根据节点ID更新节点信息，入参Node：{}",node.toString());
		try {
			//如果是父节点，设置节点parentId为空
			if(StringUtils.isBlank(node.getParentId()))
				node.setParentId(null);
			//调动更新服务持久化node
			menuService.updateNodeById(node);
			//返回form成功
			map.put("json", formSuccess());
			return "json";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("json", formFail(e.getMessage()));
			return "json";
		}
		
	}
	
	@RequestMapping("/addNode")
	public String addNode(MenuInfo node,ModelMap map){
		
		if (menuService.addNode(node)!=null) {
			map.put("json", formSuccess(node.getMenuId()));
		} else {
			map.put("json", formFail("新增失败"));
		}
		return "json";
	}
	
	@RequestMapping("/deleteNodeById")
	public String deleteNodeById(String menuId,ModelMap map){
		
		try {
			menuService.deleteNodeById(menuId);
			map.put("json", formSuccess());
		} catch (Exception e) {
			map.put("json", formFail(e.getMessage()));
		}
		return "json";
	}
}
