package group.rxcloud.capabff.controller;

import group.rxcloud.capabff.domain.Pet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetController {

    @PostMapping("/pet")
    public Pet pet() {
        return new Pet(1L, "test");
    }

}
