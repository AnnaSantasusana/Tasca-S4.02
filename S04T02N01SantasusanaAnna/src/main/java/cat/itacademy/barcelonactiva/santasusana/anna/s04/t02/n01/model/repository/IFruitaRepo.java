package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.model.domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitaRepo extends JpaRepository<Fruita, Integer> {
}
