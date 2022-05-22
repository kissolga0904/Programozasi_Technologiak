public class Product {
    public static class Builder{
        private String Nev;
        private TermekSzin Szin;
        private int Suly;
        private String Tipus;
        private Gyartok Gyarto;
        private int Id;

        public String getNev() {
            return Nev;
        }

        public TermekSzin getSzin() {
            return Szin;
        }

        public int getSuly() {
            return Suly;
        }

        public String getTipus() {
            return Tipus;
        }

        public Gyartok getGyarto() {
            return Gyarto;
        }

        public int getId() { return Id; }

        public Builder(String nev, TermekSzin szin, String tipus, Gyartok gyarto, int id){
            this.Nev = nev;
            this.Szin = szin;
            this.Tipus = tipus;
            this.Gyarto = gyarto;
            this.Id = id;
        }

        public Builder suly(int suly){
            this.Suly = suly;
            return this;
        }

        public Product build(){
            Product product = new Product(this);
            return product;
        }
    }

    private Product(Builder builder){
        this.Nev = builder.getNev();
        this.Szin = builder.getSzin();
        this.Suly = builder.getSuly();
        this.Tipus = builder.getTipus();
        this.Gyarto = builder.getGyarto();
        this.Id = builder.getId();
    }

    private String Nev;
    private TermekSzin Szin;
    private int Suly;
    private String Tipus;
    private Gyartok Gyarto;

    private int Id;

    public String getNev() {
        return Nev;
    }

    public TermekSzin getSzin() {
        return Szin;
    }

    public int getSuly() {
        return Suly;
    }

    public String getTipus() {
        return Tipus;
    }

    public Gyartok getGyarto() {
        return Gyarto;
    }

    public int getId() { return Id; }
}
