package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruita")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Quantity kg")
    private int kg;

    public Fruit(){}

    public Fruit(String name, int kg){
        this.name = name;
        this.kg = kg;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return name;
    }

    public void setNom(String name) {
        this.name = name;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kg=" + kg +
                '}';
    }
}

