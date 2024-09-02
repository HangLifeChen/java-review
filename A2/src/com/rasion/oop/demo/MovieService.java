package com.rasion.oop.demo;

import java.util.Scanner;

public class MovieService {
    private Movie[] movies;

    public MovieService(Movie[] movies) {
        this.movies = movies;
    }
    public Movie[] addMovie(Movie[] arr) {
        arr[0]=new Movie(1,"《老友记》",19.9,"林志玲");
        arr[1]=new Movie(2,"《星际穿越》",9.6,"安妮海瑟薇");
        arr[2]=new Movie(3,"《速度与激情7》",9.9,"范·迪塞尔");
        arr[3]=new Movie(4,"《夏洛特烦恼》",9.3,"沈腾");
        arr[4]=new Movie(5,"《让子弹飞》",9.0,"姜文");
        arr[5]=new Movie(6,"《速度与激情8》",9.0,"瑞秋·费尔南多");
        return arr;
    }

    public void printMovies() {
        System.out.println("ID\tName\tPrice\tDirector");
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getPrice()+"\t"+m.getDirector()+"\t");
        }
    }
    public void selectMovie() {
        System.out.println("Please input the movie id which you want select:");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        for (int i = 0; i < movies.length; i++) {
            Movie m=movies[i];
            if(m.getId()==id)
            {
                System.out.println("ID\tName\tPrice\tDirector");
                System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getPrice()+"\t"+m.getDirector()+"\t");
                return;
            }
        }
        System.out.println("No such movie!");
    }
}
