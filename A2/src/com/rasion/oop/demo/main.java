package com.rasion.oop.demo;

public class main {
    public static void main(String[] args) {
        Movie[] arr=new Movie[6];
        //创建电影操作对象
        MovieService ms=new MovieService(arr);
        ms.addMovie(arr);
        ms.printMovies();
        ms.selectMovie();
    }
}
