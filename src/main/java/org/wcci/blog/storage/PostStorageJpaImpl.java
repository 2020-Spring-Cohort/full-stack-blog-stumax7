package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.PostRepository;

@Service
public class PostStorageJpaImpl  implements PostStorage {
    private PostRepository postRepository;

    public PostStorageJpaImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(Long id){
        return postRepository.findById(id).get();
    }

    @Override
    public void store (Post postToStore){
        postRepository.save(postToStore);
    }
}
