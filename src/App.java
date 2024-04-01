import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        int ogrSayi,secim;
        Scanner input = new Scanner(System.in);
        System.out.println("Sınıfta kaç tane öğrenci bulunuyor? ");
        ogrSayi = input.nextInt();
        String[] ogrIsim = new String[ogrSayi];
        int[] kimlik = new int[ogrSayi];
        int[] araSinav = new int[ogrSayi];
        int[] finalSinav = new int[ogrSayi];
        int[] donemSonu = new int[ogrSayi];
        double ortalama = 0;
        System.out.println("Bir seçim yapınız...");
        menu();
        secim = input.nextInt();
        while(secim!=0) {
            switch (secim) {
                case 1:
                    studentProcess(ogrSayi, input, ogrIsim, kimlik, araSinav, finalSinav); break;
                case 2:
                    listProcess(ogrSayi, ogrIsim, kimlik, araSinav, finalSinav); break;
                case 3:
                    gradeProcess(ogrSayi, ogrIsim, araSinav,kimlik, finalSinav,donemSonu,ortalama); break;

            }
            secim = input.nextInt();
        }

    }
    public static void menu(){
        System.out.println("----------------------");
        System.out.println("[1]-Öğrenci İşlemleri");
        System.out.println("[2]-Öğrenci Listele");
        System.out.println("[3]-Dönem Sonu Notları Listele");
        System.out.println("[0]-Çıkmak için basın...");
        System.out.println("----------------------");
    }
    public static void studentProcess(int a,Scanner b,String[] isim,int[] id,int[] ara,int[] finall){

        for (int i = 0; i < a; i++) {
            System.out.printf("%d. Öğrencinin ismini girin: ",i+1);
            isim[i] = b.next();

            System.out.printf("%d. Öğrencinin kimliğini girin: ",i+1);
            id[i] = b.nextInt();

            System.out.printf("%d. Öğrencinin ara sınav notunu girin: ",i+1);
            ara[i] = b.nextInt();
            
            System.out.printf("%d. Öğrencinin final sınav notunu girin: ",i+1);
            finall[i] = b.nextInt();
        }
    menu();
    }
    public static void listProcess(int a,String[] name,int[] id,int[] ara,int[] finall){

        for (int i = 0; i < a; i++) {
            System.out.println("Öğrenci adı : " + name[i] + "\n" + "Öğrenci kimliği : " + id[i] + "\n"
                    + "Ara sınav notu : " + ara[i] + "\n" + "Final sınav notu : " + finall[i]);
            System.out.println("----------------------");
        }
        menu();
    }
    public static void gradeProcess(int a,String[] name,int[] ara,int[] id,int[] finall,int[] toplam,double ort){
        int i;
        int minAra = ara[0];
        int maxFinal = finall[0];
        for ( i = 0; i < a; i++) {
            toplam[i] = (ara[i]*40/100) + (finall[i]*60/100);
        }
        for ( i = 0; i < a; i++) {
            System.out.printf("----------------------\n");
            System.out.printf("%s adlı öğrencinin dönem sonu toplam notu : %d\n",name[i], toplam[i]);
            System.out.printf("----------------------\n");
        }

       for (i=0;i<a;i++){
           ort += toplam[i];
       }
        ort = ort/a;
        System.out.println("Not ortalaması : "+ort);
        System.out.printf("----------------------\n");

        System.out.println("Final notları 60'ın altında olan öğrenciler :");
        for (i=0;i<a;i++){
            if(finall[i]<60)
                System.out.println("Öğrenci ismi : " + name[i] + " | " + "Öğrenci kimliği : " + id[i]);
        }
        System.out.printf("----------------------\n");
        System.out.println("Ortalamanın üzerinde olan öğrenciler : ");
        for ( i = 0; i < a; i++) {
            if(toplam[i]>ort)
                System.out.println(name[i]);

        }
        System.out.printf("----------------------\n");
        for ( i = 0; i < a; i++) {
            if(ara[i] < minAra) {
                minAra = ara[i];
            }
            if(finall[i] > maxFinal) {
                maxFinal = finall[i];
            }
        }
        System.out.println("Minimum vize notu : " + minAra);
        System.out.println("Maksimum final notu : " + maxFinal);
        System.out.printf("----------------------\n");

        menu();
    }

}
