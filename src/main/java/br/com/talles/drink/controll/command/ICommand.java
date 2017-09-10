package br.com.talles.drink.controll.command;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.domain.Entity;

public interface ICommand {
    
    public Result execute(Entity entity);
    
}
