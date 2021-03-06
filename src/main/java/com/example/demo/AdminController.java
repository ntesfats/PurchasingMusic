package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    SaleRepository saleRepository;

    //Artist Form
    @GetMapping("/addArtist")
    public String loadArtistForm(Model model){
        model.addAttribute("artist", new Artist());
        return "addArtist";
    }
    //Artist Form Processing
    @PostMapping("/processArtist")
    public String processArtistForm(@ModelAttribute Artist artist){
        artistRepository.save(artist);
        return "redirect:/";
    }

    //Add song form
    @GetMapping("/addSong")
    public String loadSongForm(Model model){
        model.addAttribute("song", new Song());
        return "addSong";
    }

    //Song processing
    @PostMapping ("/processSong")
    public String processSongForm (@ModelAttribute Song song){
        songRepository.save(song);
        return "redirect:/";
    }
    // Find song by ID
    @RequestMapping(value = "/{song_id}", method = RequestMethod.POST)
    public Sale getSale(@PathVariable("song_id")int song_id) {
        return null;

    }





}
