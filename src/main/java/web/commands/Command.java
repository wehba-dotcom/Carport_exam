package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;
import jdk.jshell.spi.ExecutionControl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";
    private static HashMap<String, Command> commands;
    public static Database database;
    private static void initCommands(Database database) throws UserException {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("custom",new SkæddersyredeCommand("skæddersyrede"));
        commands.put("enkelt",new EnkeltCarportCommand("enkeltcarport"));
        commands.put("bergen",new ResultCommand("resultpage"));
        commands.put("mangeorders",new ShowordersCommand("showorderspage","employee"));
        commands.put("showsvg",new ShowSVGCommand("svgpage"));
        commands.put("myorders",new ShowMyOrdersCommand("showmyorderspage","customer"));
        commands.put("station",new HandelStationCommand("getstationpage"));
    }
    public static Command fromPath(
            HttpServletRequest request,
            Database db) throws UserException {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }
        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }
    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException, ExecutionControl.UserException;
}
