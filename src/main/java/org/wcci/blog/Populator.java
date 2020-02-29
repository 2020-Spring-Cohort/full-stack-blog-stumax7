package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.*;

public class Populator implements CommandLineRunner {

    private CategoryStorageJpaImpl categoryStorageJpaImpl;
    private AuthorStorageJpaImpl authorStorageJpaImpl;
    private PostStorage postStorageJpaImpl;

    public Populator(CategoryStorageJpaImpl categoryStorageJpaImpl, AuthorStorageJpaImpl authorStorageJpaImpl, PostStorageJpaImpl postStorageJpaImpl){
        this.categoryStorageJpaImpl = categoryStorageJpaImpl;
        this.authorStorageJpaImpl = authorStorageJpaImpl;
        this.postStorageJpaImpl = postStorageJpaImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        Category media = new Category("Media");
        categoryStorageJpaImpl.store(media);
        Category newsAndPolitics = new Category("News and Politics");
        categoryStorageJpaImpl.store(newsAndPolitics);

        Author hugoBrass = new Author("Hugo Brass");
        authorStorageJpaImpl.store(hugoBrass);
        Author victoriaGelding = new Author("Victoria Gelding");
        authorStorageJpaImpl.store(victoriaGelding);

        Post ripPopSmoke = new Post("R.I.P. Pop Smoke", "What a tragedy!", hugoBrass,  media);
        postStorageJpaImpl.store(ripPopSmoke);
        Post grimes = new Post("Grimes - Miss Anthropocene", "This concept album has some issues.", victoriaGelding, media);
        postStorageJpaImpl.store(grimes);
        Post virusCruise = new Post("Virus Cruise", "Well, this sucks.", hugoBrass, newsAndPolitics);
        postStorageJpaImpl.store(virusCruise);
        Post democrats = new Post("The Democrats", "Can they pull it off?", victoriaGelding, newsAndPolitics);
        postStorageJpaImpl.store(democrats);
    }
}
