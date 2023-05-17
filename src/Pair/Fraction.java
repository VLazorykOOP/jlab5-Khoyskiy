package Pair;


public class Fraction extends Pair{
        private int numerator;
        private int denominator;
    
        public Fraction(int numerator, int denominator) {
            super(numerator,denominator);
            simplify(numerator, denominator);
        }
        public Fraction() {
            this.numerator = 1;
            this.denominator = 2;
        }
        public int getx(){
            return numerator/denominator;
        }
        @Override
        public Pair add(Pair p) {
            if(this == null || p == null || !(p instanceof Pair)){
                System.out.println("Error");
                return null;
            }
            int newNumerator = this.numerator *p.y + p.x * this.denominator;
            int newDenominator = this.denominator * p.y;
            return new Fraction(newNumerator, newDenominator);
        }                                                                         //null
    
        @Override
        public Pair subtract(Pair p) { 
            if(this == null || p == null || !(this instanceof Pair)){
                System.out.println("Error");
                return null;
            }
            int newNumerator = this.numerator * p.y - p.x * this.denominator;
            int newDenominator = this.denominator * p.y;
            return new Fraction(newNumerator, newDenominator);
        }

        @Override
        public Pair multiply(int n) {
            int newNumerator = this.numerator * n;
            return new Fraction(newNumerator, this.denominator);
        }       

        @Override
        public Pair divide(int n) {
            int newDenominator = this.denominator * n;
            return new Fraction(this.numerator, newDenominator);
        }

        private void simplify(int A, int B) {
            int gcd = gcd(A, B);
           // System.out.println(gcd+" ");
            this.numerator = A / gcd;
            this.denominator = B / gcd;
        }

        private int gcd(int a, int b) {
            //System.out.println(a+" "+b);                                            
            if (b == 0) {                                                             
                return a;                 //   81 28    28 25   25 3   3 1    1 0                                       
            }                                                                        
            return gcd(b, a % b);
        }

        @Override
        public String toString() {
            return "Fraction: \n" + this.numerator + "/" + this.denominator;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fraction)) {
                return false;
            }
            Fraction f = this;
            f.simplify(f.numerator, f.denominator);
            Fraction g = (Fraction) obj;
            g.simplify(g.numerator, g.denominator);
            return g.numerator == f.numerator && g.denominator == f.denominator;
        }
        @Override
        public int compareTo(Pair pair) {
            return Float.compare((float)numerator/denominator, (float)pair.x/pair.y);
        }
}
