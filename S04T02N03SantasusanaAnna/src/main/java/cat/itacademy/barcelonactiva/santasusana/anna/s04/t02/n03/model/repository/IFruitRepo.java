package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitRepo extends MongoRepository<Fruit, ObjectId> {
}
