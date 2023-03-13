package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.dto.FruitDto;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.dto.Message;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.exception.FruitaBadRequestException;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.exception.FruitaNotFoundException;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.services.FruitService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fruites")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    private static final String NAME_REQUIRED_MSG = "Name is required";
    private static final String NOT_VALID_WEIGHT_MSG = "Weight must be greater than 0";
    private static final String FRUITA_NO_EXIST_MSG = "This fruit does not exist";

    @PostMapping("/add")
    public ResponseEntity<Message> addFruita(@RequestBody FruitDto fruitaDto) {

        if(StringUtils.isBlank(fruitaDto.getNameFruit())) {
            throw new FruitaBadRequestException(NAME_REQUIRED_MSG);
        }
        if(fruitaDto.getKgFruit() <= 0) {
            throw new FruitaBadRequestException(NOT_VALID_WEIGHT_MSG);
        }
        Fruit f = new Fruit(fruitaDto.getNameFruit(), fruitaDto.getKgFruit());
        fruitService.saveFruita(f);
        return new ResponseEntity<>(new Message("Added fruit"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateFruita(@PathVariable("id") int id, @RequestBody FruitDto fruitaDto) {

        if (StringUtils.isBlank(fruitaDto.getNameFruit())) {
            throw new FruitaBadRequestException(NAME_REQUIRED_MSG);
        }
        if (fruitaDto.getKgFruit() <= 0) {
            throw new FruitaBadRequestException(NOT_VALID_WEIGHT_MSG);
        }
        Fruit f = fruitService.getFruita(id).orElseThrow(() -> new FruitaNotFoundException(FRUITA_NO_EXIST_MSG));
        f.setNom(fruitaDto.getNameFruit());
        f.setKg(fruitaDto.getKgFruit());
        fruitService.saveFruita(f);
        return new ResponseEntity<>(new Message("Updated fruit"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteFruita(@PathVariable("id") int id) {
        Fruit fruita = fruitService.getFruita(id).orElseThrow(() -> new FruitaNotFoundException(FRUITA_NO_EXIST_MSG));
        fruitService.deleteFruita(fruita);
        return new ResponseEntity<>(new Message("Fruit removed"), HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitaById (@PathVariable("id") int id){

        Fruit fruita = fruitService.getFruita(id).orElseThrow(() -> new FruitaNotFoundException(FRUITA_NO_EXIST_MSG));
        return new ResponseEntity<>(fruita, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruites () {

        List<Fruit> fruites = fruitService.listFruita();
        return new ResponseEntity<>(fruites, HttpStatus.OK);
    }

}