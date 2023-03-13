package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.model.repository.IFruitaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8080") Tinc el port.server a application.properties
@RestController
@RequestMapping("/fruites")
public class FruitaController {

    @Autowired
    private IFruitaRepo fruitaRepo;

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
        try {
            Fruita f = fruitaRepo.save(new Fruita(fruita.getNom(), fruita.getKg()));
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruita) {
        Optional<Fruita> fruitaData = fruitaRepo.findById(id);

        if (fruitaData.isPresent()) {
            Fruita f = fruitaData.get();
            f.setNom(fruita.getNom());
            f.setKg(fruita.getKg());
            return new ResponseEntity<>(fruitaRepo.save(f), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") int id) {
        try{
            fruitaRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") int id) {
        Optional<Fruita> fruitaData = fruitaRepo.findById(id);

        if (fruitaData.isPresent()) {
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        try {
            List<Fruita> fruitaData = fruitaRepo.findAll();

            if (fruitaData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruitaData, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
