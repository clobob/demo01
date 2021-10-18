package com.example.movie.backend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonAdapter {

    //convert Json object into Card class
    public static ArrayList<Movie> getMoviesFromJson(String filename){
        ArrayList<Movie> movies = getJsonArray(filename);
        if (movies == null){
            return new ArrayList<>();
        }
        return movies;

    }

    //convert Json object into Card class
    public static List<User> getUserFromJson(String filename){
    	String s = readJsonFile(filename);
    	List<User> users = JSONObject.parseArray(s, User.class);
    	return users;
    }
    //check if file exit
    private static void isFileExistOrCreatIt(String fileName)  {
        if (!fileName.endsWith(".json")){
            throw new IllegalArgumentException("Invalid file name");
        }
        File file = new File("src//main//resources"+"//"+fileName);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    //reading json file using a byte stream
    private static String readJsonFile (String fileName) {
        if (!fileName.endsWith(".json")){
            throw new IllegalArgumentException("Invalid file name");
        }
        String jsonStr = "";
        try{
            isFileExistOrCreatIt(fileName);
            File jsonFile = new File("src//main//resources"+"//"+fileName);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while((ch = reader.read())!=-1){
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // convert string into JSONObject
    private static ArrayList<Movie> getJsonArray(String fileName){
        String s = readJsonFile(fileName);
        return (ArrayList<Movie>) JSONObject.parseArray(s, Movie.class);
    }


    //saved movies status
    public static void writeMovies(String filename, ArrayList<Movie> movies){
        JSONArray temp = JSONArray.parseArray(JSON.toJSONString(movies));
        String jsonArray = JSON.toJSONString(temp, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        isFileExistOrCreatIt(filename);
        String path = "src//main//resources"+"//"+ filename;
        writeJson(path, jsonArray);
    }


    //write json file
    private static void writeJson(String path, String content){
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert fw != null;
        PrintWriter out = new PrintWriter(fw);
        out.write(content);
        out.println();
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }


}
