package gJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Time;
import java.util.Scanner;
import java.util.TimerTask;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext ctx = SpringApplication.run(CompanyApplication.class, args);

        Scanner sc = new Scanner(System.in);
        String close = "";
        do {

            Thread.sleep(5000);

            System.out.println("You are not active for a while d you wish to close app Y/N ?");
            close = sc.next();
            if (close.equals("Y"))
            {
                ctx.close();
                System.exit(0);
            }

        } while (true);

    }

//https://www.baeldung.com/spring-shutdown-callbacks
    //HOMEWORK
//9:48
//zapisac plik json na zamkniecie systemu z emoployee
//9:49
//2. wczytac plik json na wlaczenie systemu


}
