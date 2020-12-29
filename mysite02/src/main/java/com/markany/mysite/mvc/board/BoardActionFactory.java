package com.markany.mysite.mvc.board;

import com.markany.web.mvc.Action;
import com.markany.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("write".equals(actionName)) {		
			action = new WriteAction();
		}else if("writesuccess".equals(actionName)) {		
			action = new WriteSuccessAction();
		}else if("view".equals(actionName)) {		
			action = new ViewAction();
		}else if("delete".equals(actionName)) {		
			action = new DeleteAction();
		}else if("modify".equals(actionName)) {		
			action = new ModifyAction();
		}else if("modifysuccess".equals(actionName)) {		
			action = new ModifySuccessAction();
		}else {
			action = new ListAction();
		}
		
		return action;
	}

}
 