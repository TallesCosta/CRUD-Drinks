package br.com.talles.drink.controll.viewHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.domain.Entity;

public interface IViewHelper {
    
    public Entity getEntity(HttpServletRequest request);
    
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response);
    
}
