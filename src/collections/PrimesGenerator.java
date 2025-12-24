package collections;

import java.util.Iterator;

public class PrimesGenerator implements Iterator<Integer> {
    private int count;
    private int current;
    private int generated;

    public PrimesGenerator(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }
        this.count = count;
        this.current = 2;
        this.generated = 0;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        return generated < count;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("Больше нет простых чисел");
        }

        while (!isPrime(current)) {
            current++;
        }

        int prime = current;
        current++;
        generated++;
        return prime;
    }
}