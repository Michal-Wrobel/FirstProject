package gJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.sql.Time;
import java.util.Map;
import java.util.Scanner;
import java.util.TimerTask;
//Znajdz sposob jak java/spring ma znalesc adotacje @Repository, zeby je zamknac
@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext ctx = SpringApplication.run(CompanyApplication.class, args);
     //   Map<String, Object> beansWithAnnotation = ctx.getBeansWithAnnotation(Repository.class);
//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            public void run() {
//                repositories.forEach(repository ->{
//                    File file = new File( repository.getClass().getSimpleName()+".json");
//                    try {
//                        file.createNewFile();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    repository.saveDatabaseToFile(file);
//                });
//                System.out.println("In shutdown hook persist do database");
//            }
//        }, "Shutdown-thread"));

        Scanner sc = new Scanner(System.in);
        String close = "";
        do {

            Thread.sleep(10000);

            System.out.println("You are not active for a while dO you wish to close app Y/N ?");
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
