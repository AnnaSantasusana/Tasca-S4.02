package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "fruits")
public class Fruit {
    @Id
    private ObjectId id;
    private String name;
    private int kg;

    public Fruit(String name, int kg) {
        this.name = name;
        this.kg = kg;
    }

}
