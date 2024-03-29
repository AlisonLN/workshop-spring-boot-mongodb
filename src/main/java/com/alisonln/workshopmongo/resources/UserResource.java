package com.alisonln.workshopmongo.resources;

import com.alisonln.workshopmongo.domain.User;
import com.alisonln.workshopmongo.dto.UserDTO;
import com.alisonln.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
  @RequestMapping(value = "/users")
  public class UserResource {
      @Autowired
      private UserService service;

      //@GetMapping Pode usar os dois, mesma função
      @RequestMapping(method = RequestMethod.GET)
      public ResponseEntity <List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
      }

}
