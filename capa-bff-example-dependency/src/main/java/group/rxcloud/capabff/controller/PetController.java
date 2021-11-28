package group.rxcloud.capabff.controller;

import group.rxcloud.capabff.domain.Pet;
import group.rxcloud.capabff.domain.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PetController {

    @PostMapping("/pet")
    public Pet pet() {
        return Pet.build(1L);
    }

    @PostMapping("/id")
    public Pet petById(@RequestBody Pet id) {
        return Pet.build(id.getId());
    }


    @PostMapping("/list")
    public ResponseEntity<List<Pet>> petList() {
        List<Pet> datas = Arrays.asList(
                Pet.build(1L),
                Pet.build(2L),
                Pet.build(3L),
                Pet.build(4L),
                Pet.build(5L),
                Pet.build(6L),
                Pet.build(7L),
                Pet.build(8L),
                Pet.build(9L),
                Pet.build(10L));
        ResponseEntity<List<Pet>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(200);
        responseEntity.setData(datas);

        return responseEntity;
    }

}
