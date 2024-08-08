package com.LDS.linedata.cour;

import com.LDS.linedata.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cours")
public class courController {

    @Autowired
    private courService courService;

    @GetMapping("/get_cour")
    public Cour getCour(@RequestParam Integer id)
    {
        return courService.getCour(id);
    }



    @GetMapping("/getAllcour")
    public List<Cour> getAllCours() { return (List<Cour>) courService.getAllCours();
    }


    @PostMapping("/create_cour")
    public Cour createCour(@RequestBody Cour cour) {
        return courService.createCour(cour);
    }


    @DeleteMapping("/delete_cour")
    public void deleteCour(@RequestParam Integer id) {
        courService.deleteCour(id);
    }



    @PutMapping("/update_cour")
    public Cour updateCour(@RequestParam Integer id, @RequestBody Cour courDetails) {
        return courService.updateCour(id, courDetails);}


    @PostMapping("/{courId}/users/{userId}")
    public Cour addUserToCour(@PathVariable Integer courId, @PathVariable Integer userId) {
        return courService.addUserToCour(courId, userId);
    }

}
