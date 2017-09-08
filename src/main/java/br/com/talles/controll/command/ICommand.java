package br.com.talles.controll.command;

import br.com.talles.controll.Result;
import br.com.talles.domain.Entity;

public interface ICommand {
    
    public Result execute(Entity entity);
    
}
