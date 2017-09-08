package br.com.talles.controll.viewHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.talles.controll.Result;
import br.com.talles.domain.Entity;

public interface IViewHelper {
    
    public Entity getEntity(HttpServletRequest request);
    
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response);
    
}
