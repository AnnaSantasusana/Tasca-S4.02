package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruita")
public class Fruita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Quantitat_quilos")
    private int kg;

    public Fruita(){}

    public Fruita(String nom, int kg){
        this.nom = nom;
        this.kg = kg;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return "Fruita{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", kg=" + kg +
                '}';
    }
}
