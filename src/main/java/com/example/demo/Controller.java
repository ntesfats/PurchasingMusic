package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    SongRepository songRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SaleRepository saleRepository;
//
//    @RequestMapping("/")
//    public String home(Model model) {
//        model.addAttribute("songs",songRepository.findAll());
//        return"Home";
//    }
    @RequestMapping("/")
    public String home(Model model, Principal principal) {
        model.addAttribute("songs",songRepository.findAll());
        if(principal!=null) {
            User currentUser = userRepository.findByUsername(principal.getName());
            model.addAttribute("currentUser", currentUser);
        }
        return "home";
    }


    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return"registerUser";
    }

    @PostMapping("/processregister")
<<<<<<< HEAD
    public String processRegistrationPage(@ModelAttribute User user){
        userRepository.save(user);
        return "index";
    }
=======
    public String processRegisterationPage(
            @Valid @ModelAttribute("user") User user, BindingResult result, Model model)
    {
        if(result.hasErrors()){
            user.clearPassword();
            model.addAttribute("user",user);
            return "register";
        }
        else {
            model.addAttribute("user",user);
            model.addAttribute("message","New user account created");

            user.setEnabled(true);
            userRepository.save(user);
            Role role = new Role(user.getUsername(),"ROLE_USER");
            roleRepository.save(role);
        }
        return "home";
    }
    @RequestMapping("/ArtistPage")
    public String ArtistPage(){
        return "ArtistPage";
    }

    @RequestMapping("/purchase/song/{id}")
    public String purchaseSong(@PathVariable long id, Principal principal, Model model) {
        User currentUser = userRepository.findByUsername(principal.getName());
        Song purchaseSong = songRepository.findById(id).get();
        double totalPrice = purchaseSong.getSongPrice();
        Sale newSale = new Sale(currentUser, totalPrice, true);
        HashSet<Song> allPurchaseSong = new HashSet<>();
        allPurchaseSong.add(purchaseSong);
        newSale.setSongs(allPurchaseSong);
        saleRepository.save(newSale);

        return "redirect:/";



    }

>>>>>>> d5c7c813c1ec30a081578bbd7e8780aea0965d66
}
