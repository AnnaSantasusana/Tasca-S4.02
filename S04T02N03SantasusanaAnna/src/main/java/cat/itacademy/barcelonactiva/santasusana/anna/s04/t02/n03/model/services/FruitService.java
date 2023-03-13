package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.repository.IFruitRepo;
import jakarta.transaction.Transactional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FruitService {

    @Autowired
    IFruitRepo fruitaRepo;

    public void saveFruita(Fruit fruit){
        fruitaRepo.save(fruit);
    }

    public boolean existsByIdFruita(ObjectId id){
        return fruitaRepo.existsById(id);
    }

    public Optional<Fruit> getFruita(ObjectId id){
        return fruitaRepo.findById(id);
    }

    public void deleteFruita(Fruit fruit) {
        fruitaRepo.delete(fruit);
    }

    public List<Fruit> listFruita(){
        return fruitaRepo.findAll();
    }

}


