package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class WorldClockController {

    @RequestMapping(value = "/worldclock", method = RequestMethod.GET)
    public String getTimeByTimeZone(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city, Model model){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
