/*

package com.example.hellorestdatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class HelloController {
    @Autowired
//we will cover this later
private GreetingDAO greetingDao;
    @RequestMapping(value = "/createGreeting", method = RequestMethod.POST)
    public Greeting createGreeting(@RequestBody String name) throws IOException {
        Greeting newGreeting = new Greeting(name);
        greetingDao.create(newGreeting);
        return newGreeting;
    }
    @RequestMapping(value = "/getGreeting/{id}", method = RequestMethod.GET)
    public Greeting getGreeting(@PathVariable("id") int id) throws IOException {
        return greetingDao.getById(id);
    }
}

 */