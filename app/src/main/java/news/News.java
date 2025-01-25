package news;

import java.util.ArrayList;

public class News {
    int age;
    String name;
    public News(int age,String name){
        this.age=age;
        this.name=name;
    }
//    public String toString(){
//        return name+" "+age;
//    }
    public static void main(String args[]){
        ArrayList<News> list=new ArrayList<>();
        list.add(new News(21,"pradeep"));
        System.out.println(list.get(0));

    }
}
