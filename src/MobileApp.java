import java.util.ArrayList;

public class MobileApp {

    int contatoreDownloads= 0;

    String name;
    String sistemaOperativo;
    Float prezzo;
    ArrayList<Recensione> recensioni = new ArrayList<>();;
    float ricavoTotale;

    // Costruttore
    public MobileApp(String name, String sistemaOperativo, Float prezzo, ArrayList<Recensione> recensioni,
            Float ricavoTotale) {
        this.name = name;
        this.sistemaOperativo = sistemaOperativo;
        this.setPrezzo(prezzo);
        this.ricavoTotale = 0;
    }

    // Metodo per aggiungere una recensione
    public void riceviRecensione(Recensione recensione) {
        this.recensioni.add(recensione);
    }

    // Metodo Download
    public void download(){
        contatoreDownloads += 1;
        setRicavoTotale(getPrezzo() + getRicavoTotale());
    }

    // Metodo che in base a quanti download fatti aumrnta il ricavo totale
    public void download(int numeroDownloads){
        
        setRicavoTotale((getPrezzo() * numeroDownloads) + getRicavoTotale());
    }

    // media recensioni
    float valutazioneMedia(){
        int sommaStelle=0;
        if (recensioni.isEmpty()) {
            System.out.println("Non hai recensioni");
            return 0;
        }else{
            for(Recensione r : recensioni){
                sommaStelle += r.getNumeroStelle();
            }
            float mediaStelle= sommaStelle/recensioni.size();
            return mediaStelle;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        if (prezzo instanceof Float) {
            this.prezzo = prezzo;
        }
        else{
            System.out.println("Valore non valido");
        }
    }

    public ArrayList<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(ArrayList<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    public Float getRicavoTotale() {
        return ricavoTotale;
    }

    public void setRicavoTotale(Float ricavoTotale) {
        this.ricavoTotale = ricavoTotale;
    }
    
}
