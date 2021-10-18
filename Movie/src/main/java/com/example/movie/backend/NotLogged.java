package com.example.movie.backend;

import java.util.ArrayList;
import java.util.List;

public class NotLogged {
	private List<Movie> movieList = JsonAdapter.getMoviesFromJson("Movies.json");
	
	/**
	 * 列出所有电影
	 * @return
	 */
	public List<Movie> listAllMovie(){
		
		return movieList;
	}
	
	/**
	 * 查询过滤看电影地点
	 * @param c 过滤条件
	 * @return
	 */
	public List<Movie> filterMoviePlace(Condition c){
		List<Movie> listC = movieList;
		
		if(!"".equals(c.getClassfication())) {
			movies = movieList;
			listC = filterMoviesByClassification(c.getClassfication());
		}
		if(-1!=c.getHall()){
			movies = listC;
			listC = filterMoviesByHall(c.getHall());
		}
		if(!"".equals(c.getScreen())) {
			movies = listC;
			listC = filterMoviesByScreen(c.getScreen());
		}
		if(!"".equals(c.getTitle())) {
			movies = listC;
			listC = searchMoviesByTitle(c.getTitle());
		}
		
		// 通过条件 逻辑判断符合条件，返回新列表
		return listC;
	}
	
	/**
	 * 预定电影
	 * @return
	 */
	public Prompt orderMovie(Movie movie) {
		return new Prompt();
	}
	
	public static List<Movie> movies;
    //filter movies by screen
    public static ArrayList<Movie> filterMoviesByScreen(String screen){
        ArrayList<Movie> moviesByScreen = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.getScreen().equals(screen)){
                moviesByScreen.add(mv);
            }
        }
        return moviesByScreen;
    }

    //filter movies by classification
    public static ArrayList<Movie> filterMoviesByClassification(String classification){
        ArrayList<Movie> moviesByClassification = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.getClassification().equals(classification)){
                moviesByClassification.add(mv);
            }
        }
        return moviesByClassification;
    }

    //filter movies by hall
    public static ArrayList<Movie> filterMoviesByHall(int hall){
        ArrayList<Movie> moviesByHall = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.getHall() == hall){
                moviesByHall.add(mv);
            }
        }
        return moviesByHall;
    }

    //search movies by title
    public static ArrayList<Movie> searchMoviesByTitle(String title){
        ArrayList<Movie> moviesByHTitle = new ArrayList<>();
        for(Movie mv : movies){
            if (mv.getTitle().equals(title)){
                moviesByHTitle.add(mv);
            }
        }
        return moviesByHTitle;
    }

}
