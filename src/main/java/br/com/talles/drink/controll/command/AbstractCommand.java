package br.com.talles.drink.controll.command;

import br.com.talles.drink.controll.facade.IFacade;
import br.com.talles.drink.controll.facade.Facade;

public abstract class AbstractCommand implements ICommand{
     
    protected IFacade facade;
    
    public AbstractCommand() {
        facade = new Facade();
    }
    
}
