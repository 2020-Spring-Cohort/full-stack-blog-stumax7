package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;

public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;
    private PostStorage postStorage;

    public Populator(CategoryStorage categoryStorage, AuthorStorage authorStorage, PostStorage postStorage){
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
        this.postStorage = postStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        Category media = new Category("Media");
        categoryStorage.store(media);
        Category newsAndPolitics = new Category("News and Politics");
        categoryStorage.store(newsAndPolitics);

        Author hugoBrass = new Author("Hugo Brass");
        authorStorage.store(hugoBrass);
        Author victoriaGelding = new Author("Victoria Gelding");
        authorStorage.store(victoriaGelding);

        Post ripPopSmoke = new Post("R.I.P. Pop Smoke", "What a tragedy!", hugoBrass,  media);
        postStorage.store(ripPopSmoke);
        Post grimes = new Post("Grimes - Miss Anthropocene", "This concept album has some issues.", victoriaGelding, media);
        postStorage.store(grimes);
        Post virusCruise = new Post("Virus Cruise", "Well, this sucks.", hugoBrass, newsAndPolitics);
        postStorage.store(virusCruise);
        Post democrats = new Post("The Democrats", "Can they pull it off?", victoriaGelding, newsAndPolitics);
    }
}
