import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean proseguire = true;
        Scanner sc = new Scanner(System.in);

        // Costruzione app
        System.out.println("Costruisci la tua App!");
        System.out.println("Inserisci il nome:");
        String name = sc.nextLine();
        System.out.println("Inserisci il sistema operativo");
        String sistemaOperativo = sc.nextLine();
        System.out.println("Inserisci il prezzo");
        float prezzo = sc.nextFloat();
        sc.nextLine();

        MobileApp m = new MobileApp(name, sistemaOperativo, prezzo, null, null);

        // Menu
        do {
            System.out.println("Menu:");
            System.out.println("Digita 1 per download singolo");
            System.out.println("Digita 2 per download multiplo");
            System.out.println("Digita 3 per ricevere una recensione");
            System.out.println("Digita 4 per vedere le recensioni");
            System.out.println("Digita 5 per uscire");

            int valoreScelto = sc.nextInt();
            sc.nextLine();
            switch (valoreScelto) {
                // Funzione download singolo
                case 1:
                    m.download();
                    System.out.println("Hai scaricato " + m.getName());
                    break;

                // Funzione download multiplo
                case 2:
                    System.out.println("Quante volte vuoi scaricarlo?");
                    int numero = sc.nextInt();
                    m.download(numero);

                    System.out.println("Hai scaricato " + m.getName() + " " + numero + " volte");
                    break;

                // Scrive una recensione
                case 3:
                    System.out.print("Inserisci il tuo nome utente: ");
                    String nomeUtente = sc.nextLine();

                    System.out.print("Inserisci il numero di stelle (1-5): ");
                    int numeroStelle = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Inserisci il testo della recensione: ");
                    String testo = sc.nextLine();

                    Recensione nuovaRecensione = new Recensione(LocalDate.now(), nomeUtente, numeroStelle, testo);
                    m.riceviRecensione(nuovaRecensione);
                    System.out.println("----------------------------------");
                    System.out.println("Recensione aggiunta con successo!");
                    System.out.println("----------------------------------");
                    break;

                // mostra tutte le recensioni
                case 4:
                    ArrayList<Recensione> recensioni = m.getRecensioni();
                    if (recensioni.isEmpty()) {
                        System.out.println("Nessuna recensione disponibile");
                    } else {
                        for (Recensione r : recensioni) {
                            System.out.println(r.getNumeroStelle() + " stelle");
                            System.out.println("Utente: " + r.getNomeUtente());
                            System.out.println("Data: " + r.getData());
                            System.out.println("Recensione: " + r.getTesto());
                            System.out.println("--------------------------");
                        }
                    }
                    break;
                
                // Exit
                case 5:
                    proseguire = false;
                    System.out.println("Uscita in corso");
                    break;

                // In caso valore non valido
                default:
                    System.out.println("Valore non valido");
                    break;
            }

            // Mostro media valutazione e il guadagno
            System.out.println("La tua valutazione media di " + m.getName() + " è " + m.valutazioneMedia());
            System.out.println("Hai guadagnato " + m.ricavoTotale + "Euro");

        } while (proseguire);

        System.out.println("grazie per essere passato");
        sc.close();
    }
}
