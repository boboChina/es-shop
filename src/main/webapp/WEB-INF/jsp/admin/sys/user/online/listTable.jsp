<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<form id="changelist-form" action="" method="post"><input type='hidden' name='csrfmiddlewaretoken' value='depy0qAotmsVOdoNJbNKvzmuBljvyVks' />
  <div class="results table-responsive">
	<table class="table table-bordered table-striped table-hover">
    <thead>
      <tr>
        <th scope="col" class="action-checkbox-column">
            <input type="checkbox" id="action-toggle" />
        </th>
        <th scope="col" class="sortable">
            <div class="dropdown pull-left">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                	用户名
              </a>
              <ul class="dropdown-menu" role="menu">
                  <li><a href="?o=widget_type" class="active"><i class="icon-caret-up"></i> 正序</a></li>
                  <li><a href="?o=-widget_type" class="active"><i class="icon-caret-down"></i> 倒序</a></li>
              </ul>
            </div>
        </th>
        <th scope="col" class="sortable">
            <div class="dropdown pull-left">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                	用户主机IP
              </a>
              <ul class="dropdown-menu" role="menu">
                  <li><a href="?o=page_id" class="active"><i class="icon-caret-up"></i> 正序</a></li>
                  <li><a href="?o=-page_id" class="active"><i class="icon-caret-down"></i> 倒序</a></li>
              </ul>
            </div>
        </th>
        <th scope="col" class="sortable">
            <div class="dropdown pull-left">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
               		 登录时间
              </a>
              <ul class="dropdown-menu" role="menu">
                
                  <li><a href="?o=user" class="active"><i class="icon-caret-up"></i> 正序</a></li>
                
                  <li><a href="?o=-user" class="active"><i class="icon-caret-down"></i> 倒序</a></li>
                
              </ul>
            </div>
          
        </th>
        <th scope="col" class="sortable">
            <div class="dropdown pull-left">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
               		 登录时间
              </a>
              <ul class="dropdown-menu" role="menu">
                
                  <li><a href="?o=user" class="active"><i class="icon-caret-up"></i> 正序</a></li>
                
                  <li><a href="?o=-user" class="active"><i class="icon-caret-down"></i> 倒序</a></li>
                
              </ul>
            </div>
          
        </th>
        <th scope="col" class="sortable">
            <div class="dropdown pull-left">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
               		 登录时间
              </a>
              <ul class="dropdown-menu" role="menu">
                
                  <li><a href="?o=user" class="active"><i class="icon-caret-up"></i> 正序</a></li>
                
                  <li><a href="?o=-user" class="active"><i class="icon-caret-down"></i> 倒序</a></li>
                
              </ul>
            </div>
          
        </th>
      </tr>
    </thead>
    <tbody>
   		<c:forEach items="${page.content}" var="m">
      		<tr class="grid-item">
        		<td  class="action-checkbox">
            		<input class="action-select" name="_selected_action" type="checkbox" value="278" />
        		</td>
      			<td>${m.host}</td>
				<td>${m.systemHost}</td>
				<td><pretty:prettyTime date="${m.startTimestamp}"/></td>
				<td><pretty:prettyTime date="${m.lastAccessTime}"/></td>
				<td>${m.id}</td>
      		</tr>
    	</c:forEach>
    </tbody>
  </table>
  
<es:page page="${page}"/>
</div>
  
	<div class="form-actions well well-sm">
	  <input type="hidden" id="action" name="action" value=""/>
	  <input type="hidden" id="select-across" name="select_across" value=""/>
	  <div class="btn-group clearfix dropup">
	    <a class="dropdown-toggle btn btn-success" data-toggle="dropdown" href="#">
	    <i class="icon-wrench icon-white"></i> 
	    <span class="action-counter">50 个中 0 个被选</span>
	    <span class="all" style="display: none;">选中了 93 个</span>
	    <span class="caret"></span></a>
	    <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
	      
	        <li><a onclick="$.do_action('delete_selected');"><i class="icon-remove"></i> 删除选中项</a></li>
	      
	    </ul>
	  </div>
	  
	      
	      <a class="question btn btn-default" href="javascript:;" style="display: none;" title="点击此处选择所有页面中包含的对象。">选中所有的 93 个 用户小组件</a>
	      <a class="clear btn btn-default" href="javascript:;" style="display: none;">清除选中</a>
	      
	      <script type="text/javascript">var _actions_icnt="50";</script>
	  
	</div>

  </form>