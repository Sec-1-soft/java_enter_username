import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Yemek {
    String yemekadi;
    double yemekfiyat;

    public Yemek(String yemekadi, double yemekfiyat) {
        this.yemekadi = yemekadi;
        this.yemekfiyat = yemekfiyat;
    }
}

class YemekMenu {

    Scanner scanner = new Scanner(System.in);

    Yemek yemek1 = new Yemek("Pirinç Pilavı", 10.99);
    Yemek yemek2 = new Yemek("Kuru fasulye", 15.60);
    Yemek yemek3 = new Yemek("Ayran", 5.90);
    Yemek yemek4 = new Yemek("Baklava", 30.90);

    ArrayList<Yemek> yemekliste = new ArrayList<>(Arrays.asList(yemek1, yemek2, yemek3, yemek4));

    ArrayList<Yemek> siparisListe = new ArrayList<>();
    double menuhesapfiyat;

    void yemeklistele() {
        System.out.println("Menüdeki Yemekler Listeleniyor : \n");
        for (Yemek yemek : yemekliste) {
            System.out.println("Adı : " + yemek.yemekadi + "\t" + "Fiyat : " + yemek.yemekfiyat);
        }
        System.out.println("\n");
    }

    void yemeksiparis() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("---Yemek Sipariş Etme Arayüzü--");
            System.out.println("Bir yemek sipariş edin: ");
            yemeklistele();
            System.out.println("Bir yemek ismi girin >");
            String yemekadi = scanner.nextLine();
            System.out.println("Kaç porsiyon ? >");
            int porsiyon = scanner.nextInt();
            scanner.nextLine();

            for (Yemek yemek : yemekliste) {
                if (yemek.yemekadi.equalsIgnoreCase(yemekadi)) {
                    System.out.println("Siparişiniz eklendi ...");
                    for (int i = 0; i < porsiyon; i++) {
                        siparisListe.add(yemek);
                    }
                }
            }

            boolean _isok = true;
            while (_isok) {
                System.out.println("Siparişiniz tamam mı ? (y or n) >");
                String opt = scanner.nextLine();
                switch (opt) {
                    case "y":
                        isTrue = false;
                        _isok = false;
                        break;

                    case "n":
                        isTrue = true;
                        _isok = false;
                        break;

                    default:
                        System.out.println("Geçerli bir cevap girin !");
                }
            }
        }
    }

    double menuhesap() {
        menuhesapfiyat = 0; 
        for (Yemek yemek : siparisListe) {
            menuhesapfiyat += yemek.yemekfiyat;
        }
        return menuhesapfiyat;
    }
}

public class Yemekhane {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        YemekMenu menu = new YemekMenu();

        while (true) {
            System.out.println("""
                    "1-Yemek Listesi"
                    "2-Yemek Sipariş"
                    "3-Hesabı göster"
                    "4-Sistemden çık"
                    \n
                    """);

            System.out.println("Bir seçenek bekleniyor >");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    menu.yemeklistele();
                    break;

                case 2:
                    menu.yemeksiparis();
                    break;

                case 3:
                    System.out.println("Toplam Hesabınız :" + menu.menuhesap() + "\n");
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Geçersiz seçenek");
            }
        }
    }
}
