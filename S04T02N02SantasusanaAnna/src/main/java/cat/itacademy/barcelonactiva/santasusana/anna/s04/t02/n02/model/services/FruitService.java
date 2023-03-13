package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.repository.IFruitRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FruitService {

    @Autowired
    IFruitRepo fruitRepo;

    public void saveFruita(Fruit fruit){
        fruitRepo.save(fruit);
    }

    public boolean existsByIdFruita(int id){
        return fruitRepo.existsById(id);
    }

    public Optional<Fruit> getFruita(int id){
        return fruitRepo.findById(id);
    }

    public void deleteFruita(Fruit fruit) {
        fruitRepo.delete(fruit);
    }

    public List<Fruit> listFruita(){
        return fruitRepo.findAll();
    }
}
