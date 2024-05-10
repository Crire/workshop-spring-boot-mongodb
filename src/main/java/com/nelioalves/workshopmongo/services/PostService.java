package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        //User user = repo.findById(id).get();
        Optional<Post> post = repo.findById(id);
        if(!post.isPresent()){
            throw new ObjectNotFoundException("Objeto nao encontrado!");
        }
        return post.orElse(null);
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
