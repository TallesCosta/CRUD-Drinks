package br.com.talles.controll.command;

import br.com.talles.controll.facade.IFacade;
import br.com.talles.controll.facade.Facade;

public abstract class AbstractCommand implements ICommand{
     
    protected IFacade facade;
    
    public AbstractCommand() {
        facade = new Facade();
    }
    
}
