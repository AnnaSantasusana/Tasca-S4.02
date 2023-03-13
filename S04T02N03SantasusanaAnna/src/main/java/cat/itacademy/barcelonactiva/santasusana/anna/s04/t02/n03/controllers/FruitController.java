package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.controllers;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.dto.FruitDto;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.dto.Message;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.exception.FruitBadRequestException;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.services.FruitService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    private static final String NAME_REQUIRED_MSG = "Name is required";
    private static final String NOT_VALID_WEIGHT_MSG = "Weight must be greater than 0";
    private static final String FRUITA_NO_EXIST_MSG = "This fruit does not exist";

    public void validateFields(BindingResult result) {
        String errorMessage = result.getFieldError("name") != null ? NAME_REQUIRED_MSG : NOT_VALID_WEIGHT_MSG;
        throw new FruitBadRequestException(errorMessage);
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addFruita(@Valid @RequestBody FruitDto fruitaDto, BindingResult result) {

        if(result.hasErrors()) {
            validateFields(result);
        }
        Fruit f = new Fruit(fruitaDto.getName(), fruitaDto.getKg());
        fruitService.saveFruita(f);
        return new ResponseEntity<>(new Message("Added fruit"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateFruita(@PathVariable("id") ObjectId id, @Valid @RequestBody FruitDto fruitaDto, BindingResult result) {

        if(result.hasErrors()) {
            validateFields(result);
        }
        Fruit f = fruitService.getFruita(id).orElseThrow(() -> new FruitNotFoundException(FRUITA_NO_EXIST_MSG));
        f.setName(fruitaDto.getName());
        f.setKg(fruitaDto.getKg());
        fruitService.saveFruita(f);
        return ResponseEntity.ok(new Message("Updated fruit"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteFruita(@PathVariable("id") ObjectId id) {

        Fruit fruit = fruitService.getFruita(id).orElseThrow(() -> new FruitNotFoundException(FRUITA_NO_EXIST_MSG));
        fruitService.deleteFruita(fruit);
        return ResponseEntity.ok(new Message("Fruit removed"));
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitaById (@PathVariable("id") ObjectId id){

        Fruit fruit = fruitService.getFruita(id).orElseThrow(() -> new FruitNotFoundException(FRUITA_NO_EXIST_MSG));
        return ResponseEntity.ok(fruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruites () {

        List<Fruit> fruits = fruitService.listFruita();
        if (fruits.isEmpty()) {
            throw new FruitBadRequestException("First add fruits");
        }
        return ResponseEntity.ok(fruits);
    }

}
