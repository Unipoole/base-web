package coza.opencollab.unipoole;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This Controller redirects entry url's to the main page.
 * 
 * @since 1.0.0
 * @author OpenCollab
 */
@Controller
public class MainController {
    /**
     * This is called to load the main form
     */
    @RequestMapping(value={"/main","/index"}, method=RequestMethod.GET)
    public ModelAndView loadMainForm() {
        return new ModelAndView("main-tiles", "main",null);
    }
}