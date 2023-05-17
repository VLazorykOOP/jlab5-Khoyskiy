package Pair;

public class Money extends Pair {
        private int dollars;
        private int cents;
        
        public Money(int dollars, int cents) {
            super(dollars,cents);
            if (cents >= 100) {
                dollars += cents / 100;
                cents = cents % 100;
            }
            this.dollars = dollars;
            this.cents = cents;
        }
        public Money() {
            dollars = 350;
            cents = 50;
        }
        public int getx() {
            if (cents >= 100) {
                dollars += cents / 100;
                cents = cents % 100;
            }
            return dollars;
        }
        @Override
        public Pair add(Pair p) {
            if(this == null || p == null || !(p instanceof Pair)){
                System.out.println("Error");
                return null;
            }
            int newDollars = dollars + p.x;
            int newCents = cents + p.y;
            if (newCents >= 100) {
                newDollars += newCents / 100;
                newCents = newCents % 100;
            }
            return new Money(newDollars, newCents);
        }
        
        @Override
        public Pair subtract(Pair p) {
            if(this == null || p == null || !(p instanceof Pair)){
                System.out.println("Error");
                return null;
            }
            int newDollars = dollars - p.x;
            int newCents = cents - p.y;
            if (newCents < 0) {
                newDollars--;
                newCents += 100;
            }
            return new Money(newDollars, newCents);
        }
        
        @Override
        public Pair multiply(int n) {
            int totalCents = dollars * 100 + cents;
            totalCents *= n;
            int newDollars = totalCents / 100;
            int newCents = totalCents % 100;
            return new Money(newDollars, newCents);
        }
        
        @Override
        public Pair divide(int n) {
            int totalCents = dollars * 100 + cents;
            totalCents /= n;
            int newDollars = totalCents / 100;
            int newCents = totalCents % 100;
            return new Money(newDollars, newCents);
        }
        @Override
        public String toString() {
            return "Money: \n" + "$" + dollars + "." + cents;
        }
        
        @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        Money money = (Money)obj;
        return this.dollars == money.dollars && this.cents == money.cents;
    }
    @Override
        public int compareTo(Pair pair) {
            return Integer.compare(dollars, pair.x);
    }
}
