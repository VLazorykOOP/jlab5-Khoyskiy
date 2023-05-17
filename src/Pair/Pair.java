package Pair;

    public abstract class Pair implements Comparable<Pair>{
        protected int x;
        protected int y;
        Pair(int xp, int yp) {
            x = xp;
            y = yp;
        }
        public int getx() {
            return x;
        }
        Pair(){}
        public abstract Pair add(Pair p);
        public abstract Pair subtract(Pair p);
        public abstract Pair multiply(int n);
        public abstract Pair divide(int n);

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(getx(), pair.getx()); //переглянути
        }
    }
    
