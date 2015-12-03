package controllers;

import models.Post;

/**
 * Created by julien on 03/12/15.
 */
public class PostsController extends BaseController {

    public static void ajouterPost(String post) {
        Post post = new Post();
        post.text = post;
    }
}
