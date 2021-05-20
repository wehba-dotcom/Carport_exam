package web.commands;

import business.exceptions.UserException;
import jdk.jshell.spi.ExecutionControl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUnprotectedPage extends Command
{
    public String pageToShow;

    public CommandUnprotectedPage(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }
@Override
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException, ExecutionControl.UserException {
        return pageToShow;
    }
}


