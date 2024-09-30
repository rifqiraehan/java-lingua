class PrismaSegitigaLimas {

    public static class Luas {
        protected double tinggi, alas;

        public double LuasAlas(double alas, double tinggi) {
            return 0.5 * alas * tinggi;
        }
    }

    public interface Hitung {
        double volume();
        String hasil();
    }

    public static class LuasSegitiga extends Luas {
        public LuasSegitiga(double alas, double tinggi) {
            this.alas = alas;
            this.tinggi = tinggi;
        }

        public double luas() {
            return LuasAlas(alas, tinggi);
        }

        public String hasil() {
            return ("Luas Segitiga = " + luas());
        }
    }

    public static class Volume_Limas extends LuasSegitiga implements Hitung {
        public Volume_Limas(double alas, double tinggi) {
            super(alas, tinggi);
        }

        @Override
        public double volume() {
            return 1.0/3.0 * LuasAlas(alas, tinggi) * tinggi;
        }

        @Override
        public String hasil() {
            return ("Volume Limas Segitiga = " + volume());
        }
    }

    public static class VolumePrismaSegitiga extends LuasSegitiga implements Hitung {
        public VolumePrismaSegitiga(double alas, double tinggi) {
            super(alas, tinggi);
        }

        @Override
        public double volume() {
            return LuasAlas(alas, tinggi) * tinggi;
        }

        @Override
        public String hasil() {
            return ("Volume Prisma Segitiga = " + volume());
        }
    }


    public static void main(String[] args) {
        LuasSegitiga LS = new LuasSegitiga(5, 10);
        Volume_Limas VL = new Volume_Limas(5, 10);
        VolumePrismaSegitiga VPS = new VolumePrismaSegitiga(5, 10);
        System.out.println(LS.hasil());
        System.out.println(VL.hasil());
        System.out.println(VPS.hasil());
    }
}

// Apa rumus luas segitiga?
// Jawab: 1/2 * alas * tinggi

// Apa rumus volume limas segitiga?
// Jawab: 1/3 * luas alas * tinggi

// Apa rumus volume prisma segitiga?
// Jawab: luas alas * tinggi

// Apa rumus luas alas limas segitiga?
// Jawab: 1/2 * alas * tinggi

// Apa rumus luas alas prisma segitiga?
// Jawab: 1/2 * alas * tinggi