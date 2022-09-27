package com.monitor;

import com.monitor.dao.InitialSetup;
import com.monitor.service.Watcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.request.async.WebAsyncTask;

@SpringBootApplication
public class Monitor {

        public static void main(String[] args) {
            SpringApplication.run(Monitor.class, args);
            new Watcher().launch();
            new InitialSetup().init();
        }
}
