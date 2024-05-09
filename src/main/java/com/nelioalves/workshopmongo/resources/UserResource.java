package com.nelioalves.workshopmongo.resources;


import com.nelioalves.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //ResponseEntity ja retorna os possiveis cabecalhos
    //formatadinhos
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
        //Vai retornar um ResponseEntity do tipo , e estamos usando
        //o metodo ok(), que vai instanciar o objeto ResponseEntity
        //ja com o codigo de resposta http de forma que a resposta
        //ja venha com sucesso, e estamos usando o .body() para colocar
        //a nossa lista no corpo da resposta
    }
}
