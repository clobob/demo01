package com.example.movie;

import com.example.movie.backend.Condition;
import com.example.movie.backend.JsonAdapter;
import com.example.movie.backend.Logged;
import com.example.movie.backend.Movie;
import com.example.movie.backend.NotLogged;
import com.example.movie.backend.Order;
import com.example.movie.backend.Orders;
import com.example.movie.backend.PeopleClass;
import com.example.movie.backend.Position;
import com.example.movie.backend.Prompt;
import com.example.movie.backend.User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Movie.setMovies(JsonAdapter.getMoviesFromJson("Movies.json"));
        Movie.setUpcomingMovies(JsonAdapter.getMoviesFromJson("UpcomingMovies.json"));

//        String m1_synopsis = "Ride or Die is a Japanese romance drama film written by Nami Sakkawa and directed by Ryuichi Hiroki, starring Kiko Mizuhara and Honami Sato. The film is based on Ching Nakamura's manga series Gunjō and was released by Netflix on April 15, 2021.";
//
//        Calendar m1_releaseDate = Calendar.getInstance();
//        m1_releaseDate.set(2021, Calendar.APRIL , 15, 0, 0, 0);
//
//        Calendar m1_upcomingDate =  Calendar.getInstance();
//        m1_upcomingDate.set(2021, Calendar.NOVEMBER, 6, 20, 30, 0);
//
//        Movie m1 = new Movie("Ride or Die", 142 , m1_synopsis, "Ryuichi Hiroki", new ArrayList<>(Arrays.asList("Kiko Mizuhara", "Honami Sato",
//                "Yōko Maki", "Shunsuke Tanaka")), "Parental Guidance", "Gold", 40.00, 1, m1_releaseDate, m1_upcomingDate, new int[10][10]);

        for (Movie m :Movie.getUpcomingMovies()){
            System.out.println(m.getHall());
            System.out.println(m.getUpcomingTime().getTime());
            System.out.println(m.getCast());
            System.out.println(m.getClassification());
            System.out.println(m.getLength());
            System.out.println(m.getScreen());
            System.out.println(m.getTitle());
            System.out.println("--------------");

        }

        JsonAdapter.writeMovies("UpcomingMovies.json", Movie.getUpcomingMovies());
        JsonAdapter.writeMovies("Movies.json", Movie.getMovies());
        
        NotLogged guest = new NotLogged();
        
//        System.out.println("展示所有的电影：");
//        List<Movie> list = guest.listAllMovie();
//        for(Movie m:list) {
//        	System.out.println(m.getTitle());
//        	System.out.println(m.getDirector());
//        	System.out.println(m.getCast());
//        	System.out.println(m.getScreen());
//        }
        System.out.println("过滤和查询");
        Condition c = new Condition();
        System.out.println("过滤条件不填：");
        List<Movie> listO = guest.filterMoviePlace(c);
      for(Movie m:listO) {
    	System.out.println(m.getHall());
    	System.out.println(m.getClassification());
    	System.out.println(m.getScreen());
    	System.out.println(m.getTitle());
      }
      System.out.println(listO.size());
      System.out.println("测试 1号放映厅");
      c.setHall(1);
      List<Movie> list1 = guest.filterMoviePlace(c);
    for(Movie m:list1) {
    	System.out.println(m.getHall());
    }
    System.out.println(list1.size());
    System.out.println("测试按屏幕过滤： Gold");
    c.reset(); // 重置查询条件
    c.setScreen("Gold");
    List<Movie> listM = guest.filterMoviePlace(c);
    for(Movie m:listM) {
    	System.out.println(m.getHall());
    	System.out.println(m.getScreen());
    }
    c.reset(); // 重置查询条件
    System.out.println("测试分类和标题组合查询：Parental Guidance |Ride or Die");
    c.setClassfication("Parental Guidance");
    c.setTitle("Ride or Die");
    List<Movie> listZH = guest.filterMoviePlace(c);
    for(Movie m:listZH) {
    	System.out.println(m.getClassification());
    	System.out.println(m.getTitle());
    }
    
    System.out.println("测试 未登录提示");
    Prompt p = guest.orderMovie(listZH.get(0));
    System.out.println("当前执行结果： "+ p.getMsg());
    Logged customer = new Logged();
    ///////
    System.out.println("添加人员");
    System.out.println("添加前的人员列表： " + customer.getPeoples().size());
    for(int i=0; i<10;i++) {
    	customer.addPeople(PeopleClass.CHILD);
        customer.addPeople(PeopleClass.ADAULT);
        customer.addPeople(PeopleClass.STUDENT);
        customer.addPeople(PeopleClass.SENIORPENSIONER);
    }
//    customer.addPeople(PeopleClass.SENIORPENSIONER); //测试空位不够抛异常
    
    System.out.println("添加的人员1是否是儿童(1)：" + customer.getPeoples().get(0).getPeopleClass());
    System.out.println("添加的人员2是否是儿童(1)：" + customer.getPeoples().get(1).getPeopleClass());
    System.out.println("添加的人员3是否是儿童(1)：" + customer.getPeoples().get(2).getPeopleClass());
    System.out.println("人员数量：" + customer.getPeoples().size());
    
    //////
    System.out.println("选择座位");
    for(int i=0;i<10;i++) {
//    	customer.selectSeat(listZH.get(0), Position.front);
//        customer.selectSeat(listZH.get(0), Position.middle);
        customer.selectSeat(listZH.get(0), Position.rear);
    }
    
    
    System.out.println("测试已登录调用");
    Prompt orderedPrompt = customer.orderMovie(listZH.get(0));
    System.out.println("登录后预定电影提示： " + orderedPrompt.getMsg());
    
    System.out.println("预定成功后订单增加");
    Orders orders = customer.getOrders();
    for(Order order: orders.getOrderList()) {
    	System.out.println("订单： "+ order.getId());
    	System.out.println(order.getCustomer());
    	System.out.println(order.getSeatsIndex());
    	System.out.println(order.getMovie().getTitle());
    	System.out.println("总价： " + order.getTotalPrice());
    }
    System.out.println("预定成功后座位情况： " );
    for(int i=0;i<10;i++) {
    	for(int j=0;j<10;j++) {
    		System.out.print(listZH.get(0).getSeats()[i][j]);
    	}
    }
    ///////////////////
    System.out.println("取消订单： ");
    customer.cancelOrder(orders.getOrderList().get(0));
    
    System.out.println("订单列表的总数: "+ orders.getOrderList().size());
    System.out.println("取消成功后座位情况： " );
    for(int i=0;i<10;i++) {
    	for(int j=0;j<10;j++) {
    		System.out.print(listZH.get(0).getSeats()[i][j]);
    	}
    }
    /////////////////////////////////
    System.out.println("测试 用户登录：");
    User u = new User();
    u.setPassword("");
    u.setUsername("不存在用户");
    System.out.println("登录失败测试： "+ User.login(u));
    
    ///////////////////////////////////////////////////
    u.setPassword("password1");
    u.setUsername("user1");
    System.out.println("登录成功测试： "+ User.login(u));
    
    
//        launch();
    }
}