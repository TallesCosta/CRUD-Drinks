package br.com.talles.controll.command;

import br.com.talles.controll.Result;
import br.com.talles.domain.Entity;

public class SaveCmd extends AbstractCommand{

    @Override
    public Result execute(Entity entity) {
        return facade.save(entity);
    }
    
}
