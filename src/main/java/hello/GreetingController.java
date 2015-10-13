package hello;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/getTime")
    public String getTime(boolean time){
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY-hh:mm:ss");
        DateFormat df2 = new SimpleDateFormat("dd/MM/YYYY");
        Date date = Calendar.getInstance().getTime();

        if (time) {
            return df.format(date);
        } else {
            return df2.format(date);
        }
    }

}
