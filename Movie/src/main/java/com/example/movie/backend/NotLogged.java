package com.example.movie.backend;

import java.util.List;

public class NotLogged {
	private List<Movie> movieList = JsonAdapter.getMoviesFromJson("Movies");
	
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
		// 通过条件 逻辑判断符合条件，返回新列表
		return movieList;
	}
	
	/**
	 * 预定电影
	 * @return
	 */
	public Prompt orderMovie(Movie movie) {
		return new Prompt();
	}
}
