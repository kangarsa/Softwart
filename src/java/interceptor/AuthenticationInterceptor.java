/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interceptor;

import java.util.Map;
 
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import model.entities.Usuario;

/**
 *
 * @author banquete
 */

public class AuthenticationInterceptor implements Interceptor {
 
    private static final long serialVersionUID = -5011962009065225959L;
 
    @Override
    public void destroy() {
        //release resources here
    }
 
    @Override
    public void init() {
        // create resources here
    }
 
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("inside auth interceptor");
        //Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
        Map<String, Object> sessionAttributes = ActionContext.getContext().getSession();
         
        Usuario u = (Usuario) sessionAttributes.get("usuario");
         
        if(u == null){
            String str = actionInvocation.getAction().toString();
            String[] partes = str.split("@");
            System.out.println("UserNull");
            sessionAttributes.put("paginaSiguiente", partes[0]);
            return Action.LOGIN;
        }else{
            System.out.println("User NOT Null");
            return actionInvocation.invoke();
        }
    }
 
}

