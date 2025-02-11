import java.time.LocalDate;

public class Recensione {
    // Attributi
    LocalDate data;
    String nomeUtente;
    int numeroStelle;
    String testo;

    // Costruttore
    public Recensione(LocalDate data, String nomeUtente, int numeroStelle, String testo) {
        this.data = data;
        this.nomeUtente = nomeUtente;
        this.setNumeroStelle(numeroStelle);
        this.testo = testo;
    }

    // Getters and setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public int getNumeroStelle() {
        return numeroStelle;
    }

    public void setNumeroStelle(int numeroStelle) {
        // Assicura che il valore sia tra 1 e 5
        if (numeroStelle < 1) {
            this.numeroStelle = 1;
        } else if (numeroStelle > 5) {
            this.numeroStelle = 5;
        } else {
            this.numeroStelle = numeroStelle;
        }
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }


}
