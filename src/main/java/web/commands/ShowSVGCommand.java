package web.commands;
import business.exceptions.UserException;
import business.services.SVG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import jdk.jshell.spi.ExecutionControl;
public class ShowSVGCommand extends CommandUnprotectedPage{
    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      SVG svg = new SVG(0,0,"0 0 800 600",100,100);
      svg.addRect(100,40,300,390);
      svg.addRect(100,75,4.5,390);
      svg.addRect(100,295,4.5,390);
      svg.addRect(200,75,4.5,4.5);
      svg.addRect(385,75,4.5,4.5);
      svg.addRect(200,295,4.5,4.5);
      svg.addRect(385,295,4.5,4.5);
      svg.addLine(350,50,50,350);
       SVG svg2 = new SVG(0,0,"0 0 800 600",100,100);
        for (int x = 0; x < 7; x++)
        {
            svg.addRect(100 +55 * x, 40, 300.0, 4.5);
        }
        svg.addSvg(svg2);
        request.setAttribute("svgdrawing",svg.toString());
        return pageToShow;
    }
}
