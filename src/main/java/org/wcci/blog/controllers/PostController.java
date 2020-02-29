package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.models.HashTag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repositories.HashTagRepository;

import java.util.Optional;

@Controller
public class PostController {
    private PostStorage postStorage;
    private HashTagRepository hashTagRepository;

    public PostController(PostStorage postStorage, HashTagRepository hashTagRepository){
        this.postStorage = postStorage;
        this.hashTagRepository = hashTagRepository;
    }

    @RequestMapping("/posts/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retrievedPost = postStorage.findPostById(id);
        model.addAttribute("post", retrievedPost);
        return "postView";
    }

    @PostMapping("/post/{id}/add-hashtag")
    public String addHashTagToPost(@RequestParam String hashTagName, @PathVariable Long id){
        HashTag hashTagToAddToPost;
        Optional<HashTag> hashTagToAddOpt = hashTagRepository.findByName(hashTagName);
        if(hashTagToAddOpt.isEmpty()){
            hashTagToAddToPost = new HashTag(hashTagName);
            hashTagRepository.save(hashTagToAddToPost);
        } else {
            hashTagToAddToPost = hashTagToAddOpt.get();
        }
        Post postToAddHashTagTo = postStorage.findPostById(id);
        postToAddHashTagTo.addHashTag(hashTagToAddToPost);
        postStorage.store(postToAddHashTagTo);
        return "redirect:/posts/" + id;
    }
}
