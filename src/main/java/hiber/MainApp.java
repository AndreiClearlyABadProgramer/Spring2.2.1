package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User userSet;
      userSet = new User("name1", "lastName1", "user1@mail.ru");
      userSet.setCar(new Car("car1", 1));
      userService.add(userSet);
      userSet = new User("User2", "Lastname2", "user2@mail.ru");
      userSet.setCar(new Car("car2", 2));
      userService.add(userSet);
      userSet = new User("User3", "Lastname3", "user3@mail.ru");
      userSet.setCar(new Car("car3", 3));
      userService.add(userSet);
      userSet = new User("User4", "Lastname4", "user4@mail.ru");
      userSet.setCar(new Car("car4", 4));
      userService.add(userSet);

     List<User> users = userService.listUsers();
     for (User user : users) {
        System.out.println("Id = "+user.getId());
        System.out.println("First Name = "+user.getFirstName());
        System.out.println("Last Name = "+user.getLastName());
        System.out.println("Email = "+user.getEmail());
        System.out.println("Car = " + user.getCar());
        System.out.println();
     }
      //userService.getUserByCarModelAndSeries(new Car("car1", 1));
      context.close();
   }
}
