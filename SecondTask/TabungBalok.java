public class TabungBalok {

    public static class Luas {
        protected double panjang, lebar, jari, tinggi, volume;
        double pi = 3.14;

        public double LuasAlas(double panjang, double lebar) {
            return panjang * lebar;
        }

        public double LuasAlas(double jari) {
            return pi * jari * jari;
        }
    }

    public interface Hitung {
        final double pi = 3.14;
        double volume();
        String hasil();
    }

    public static class Volume_Tabung extends Luas implements Hitung {
        public Volume_Tabung (double jari, double tinggi) {
            this.tinggi = tinggi;
            this.jari = jari;
        }

        @Override
        public double volume() {
            return LuasAlas(jari) * tinggi;
        }

        @Override
        public String hasil() {
            return ("Volume Tabung = " + volume());
        }
    }

    public static class Volume_Balok extends Luas implements Hitung {
        public Volume_Balok (double panjang, double lebar, double tinggi) {
            this.tinggi = tinggi;
            this.panjang = panjang;
            this.lebar = lebar;
        }

        @Override
        public double volume() {
            return LuasAlas(panjang, lebar) * tinggi;
        }

        @Override
        public String hasil() {
            return ("Volume Balok = " + volume());
        }
    }

    public static void main(String[] args) {
       Volume_Tabung TB = new Volume_Tabung(5, 10);
       Volume_Balok BL = new Volume_Balok(5, 15, 10);
       System.out.println(TB.hasil());
       System.out.println(BL.hasil());
    }
}

// Rumus Volume Tabung:
// Volume = Luas Alas x Tinggi

// Rumus Volume Balok:
// Volume = Luas Alas x Tinggi

// Rumus Luas Alas Tabung:
// Luas Alas = π x r x r

// Rumus Luas Alas Balok:
// Luas Alas = Panjang x Lebar