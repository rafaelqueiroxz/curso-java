package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Post post1 = new Post(
                LocalDateTime.of(2018, 06, 21, 13, 05, 44),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        Post post2 = new Post(
                LocalDateTime.of(2018, 07, 28, 23, 14, 19),
                "Good night guys",
                "See you tomorrow",
                5);

        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow that's awesome!"));

        post2.addComment(new Comment("Good night"));
        post2.addComment(new Comment("May the force be with you"));

        System.out.println(post1);
        System.out.println(post2);




    }
}