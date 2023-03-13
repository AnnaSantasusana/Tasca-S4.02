package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
En este caso la clase FruitDto no seria necesaria y directamente podriamos usar
la clase Fruit. La clase FruitDto se usa sobretodo si se desea ocultar ciertos
atributos de la clase Fruit en algunas operaciones de la API o si se desea agregar
información adicional que no está presente en la entidad Fruit.
*/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FruitDto {
    @NotBlank
    private String name;
    @Min(value = 1)
    private int kg;

}
