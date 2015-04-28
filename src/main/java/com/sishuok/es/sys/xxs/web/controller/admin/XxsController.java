/**
 * auto code generation
 */
package com.sishuok.es.sys.xxs.web.controller.admin;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sishuok.es.common.Constants;
import com.sishuok.es.common.entity.search.Searchable;
import com.sishuok.es.common.utils.SpringUtils;
import com.sishuok.es.common.web.bind.annotation.PageableDefaults;
import com.sishuok.es.common.web.controller.BaseCRUDController;
import com.sishuok.es.sys.xxs.entity.Xxs;
import com.sishuok.es.sys.xxs.utils.LoadPackageClasses;

/**
 * 不知道叫什么功能，可耻的用了自己的名字Controller
 * @author xxs
 * @version 2015-03-22
 */
 
@Controller("adminXxsController")
@RequestMapping(value = "/admin/sys/xxs/xxs")
public class XxsController extends BaseCRUDController<Xxs, Long> {

	@Autowired
    private ApplicationContext ctx;
	
    public XxsController() {
        setResourceIdentity("sys:xxs");
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @PageableDefaults(sort = "id=desc")
    public String list(Searchable searchable, Model model) {

        if (permissionList != null) {
            this.permissionList.assertHasViewPermission();
        }
        LoadPackageClasses loadPackageClasses = (LoadPackageClasses) SpringUtils.getBean("loadPackageClasses");
        List<Class<?>> classLists = new ArrayList<Class<?>>();
        try {
        	classLists = loadPackageClasses.getClassList();
        	for (int i = 0; i < classLists.size(); i++) {
        		String str = classLists.get(i).getSimpleName();  
          	  	System.out.println("-----------------------------实体类名称："+str+"--------------------------------"+classLists.get(i).getCanonicalName()+"77777777777777777777777777777777");  
          	  	Field [] fields = classLists.get(i).getDeclaredFields();
                for(int ii=0; ii< fields.length; ii++)
                {
                    Field f = fields[ii];
                    //System.out.println("属性名："+f.getName()+"                    类型:"+f.getType().getSimpleName());
                } 
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        List<Xxs> xxsLists = baseService.findAll();
        //删除已设置的实体类
        Iterator <Class<?>> it = classLists.iterator();  
        while(it.hasNext())  
        {  
        	for (int j = 0; j < xxsLists.size(); j++) {
				if (it.next().getSimpleName().equals(xxsLists.get(j).getName())) {
					it.remove();
				}
			}
        } 
        model.addAttribute("xxsLists", xxsLists);
        model.addAttribute("classLists", classLists);
        return viewName("list");
    }
    
    @RequestMapping(value = "{name}/create", method = RequestMethod.GET)
    public String showCreateForm(@PathVariable("name") String name,Model model) {

        if (permissionList != null) {
            this.permissionList.assertHasCreatePermission();
        }
        System.out.println("当前名字："+name);
        Class<?> c = null ;
        try {
			c = Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setCommonData(model);
		model.addAttribute("c",c);
        
        model.addAttribute(Constants.OP_NAME, "新增");
        if (!model.containsAttribute("m")) {
            model.addAttribute("m", newModel());
        }
        return viewName("editForm");
    }
    
    
    @RequestMapping(value = "{name}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("name") String name,Model model) {

    	if (permissionList != null) {
            this.permissionList.assertHasCreatePermission();
        }
    	if("".equals(name)){
    		LoadPackageClasses loadPackageClasses = (LoadPackageClasses) SpringUtils.getBean("loadPackageClasses");
    		List<Class<?>> lists;
			try {
				lists = loadPackageClasses.getClassList();
				for (int i = 0; i < lists.size(); i++) {
	        		String str = lists.get(i).getSimpleName();  
	        		if(str.equals(name)){
	        			//System.out.println("当前实体对象实体类名称："+str+"--------------------------------");  
		          	  	Field [] fields = lists.get(i).getDeclaredFields();
		                for(int ii=0; ii< fields.length; ii++)
		                {
		                    Field f = fields[ii];
		                    //System.out.println("属性名："+f.getName()+"                    类型:"+f.getType().getSimpleName());
		                } 
	        		}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
        setCommonData(model);
        model.addAttribute(Constants.OP_NAME, "新增");
        
        return viewName("editForm");
    }
    
}