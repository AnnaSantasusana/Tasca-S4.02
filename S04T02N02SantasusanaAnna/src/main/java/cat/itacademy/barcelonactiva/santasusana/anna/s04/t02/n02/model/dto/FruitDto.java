package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.dto;

/*
En este caso la clase FruitDto no seria necesaria y directamente podriamos usar
la clase Fruit. La clase FruitDto se usa sobretodo si se desea ocultar ciertos
atributos de la clase Fruit en algunas operaciones de la API o si se desea agregar
información adicional que no está presente en la entidad Fruit.
*/

public class FruitDto {

    private String nameFruit;
    private int kgFruit;

    public FruitDto(){}

    public FruitDto(String nameFruit, int kgFruit){
        this.nameFruit = nameFruit;
        this.kgFruit = kgFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public int getKgFruit() {
        return kgFruit;
    }

    public void setKgFruit(int kgFruit) {
        this.kgFruit = kgFruit;
    }
}
