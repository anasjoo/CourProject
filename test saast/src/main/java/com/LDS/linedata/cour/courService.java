package com.LDS.linedata.cour;

import com.LDS.linedata.user.User;
import com.LDS.linedata.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class courService {

    @Autowired
    private CourRepository courRepository;
    @Autowired
    private UserRepository userRepository;

    public Cour getCour(Integer id) {
        Optional<Cour> cour = courRepository.findById(id);
        return cour.orElse(new Cour());
    }


    public List<Cour> getAllCours() {
        return courRepository.findAll();
    }

    public Cour createCour(Cour cour) {
        return courRepository.save(cour);
    }


    public void deleteCour(Integer id) {
        Cour cour = courRepository.findById(id).orElseThrow(() -> new RuntimeException("Cour not found"));
        courRepository.delete(cour);
    }

    public Cour updateCour(Integer id, Cour courDetails) {
        Cour cour = courRepository.findById(id).orElseThrow(() -> new RuntimeException("Cour not found"));
        cour.setName(courDetails.getName());
        cour.setDescription(courDetails.getDescription());
        return courRepository.save(cour);
    }
    public Cour addUserToCour(Integer courId, Integer userId) {
        Cour cour = courRepository.findById(courId).orElseThrow(() -> new RuntimeException("Cour not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        cour.getUsers().add(user);
        user.getCours().add(cour);

        userRepository.save(user);  // Save user to persist the change in the join table
        return courRepository.save(cour);  // Save cour to persist the change in the join table
    }
}
