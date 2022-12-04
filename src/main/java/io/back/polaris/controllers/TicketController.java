package io.back.polaris.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.back.polaris.models.Status;
import io.back.polaris.models.Ticket;
import io.back.polaris.models.Category;
import io.back.polaris.models.Movie;
import io.back.polaris.models.User;
import io.back.polaris.repositories.ItemRepository;
import io.back.polaris.repositories.TicketRepository;
import io.back.polaris.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;
    


    @GetMapping("/ticket")
    public String test() {
    Optional<User> opuser = userRepository.findById(100L);
    User user = opuser.isPresent() ? opuser.get() : null;
   
    
    Ticket ticket = new Ticket("test",Status.ANALYSIS, Category.FILM, user);
    ticketRepository.save(ticket);
    return ticketRepository.findAll().toString();
    }

    
    @GetMapping("/item")
    public String test2(){
      Optional<Ticket> opTicket = ticketRepository.findById(2L);
      Ticket ticket = opTicket.isPresent() ? opTicket.get() : null;
      Movie movie = new Movie("test", ticket, "test/test/test", ticket.getCategory(), 45L);
      itemRepository.save(movie);
      return itemRepository.findAll().toString();
    }
  
}
