package br.com.talles.drink.controll.command;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.domain.Entity;

public class SaveCmd extends AbstractCommand{

    @Override
    public Result execute(Entity entity) {
        return facade.save(entity);
    }
    
}
