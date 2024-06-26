package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        //User user = repo.findById(id).get();
        Optional<User> user = repo.findById(id);
        if(!user.isPresent()){
            throw new ObjectNotFoundException("Objeto nao encontrado!");
        }
        return user.orElse(null);
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        repo.delete(findById(id));
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElse(null);
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User (objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

}
