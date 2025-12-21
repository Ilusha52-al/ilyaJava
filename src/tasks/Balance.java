package tasks;

public class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addLeft(int weight) {
        leftWeight += weight;
    }

    public void addRight(int weight) {
        rightWeight += weight;
    }

    public void result() {
        if (leftWeight == rightWeight) {
            System.out.println("=");
        } else if (leftWeight > rightWeight) {
            System.out.println("L");
        } else {
            System.out.println("R");
        }
    }

    public int getLeftWeight() {
        return leftWeight;
    }

    public int getRightWeight() {
        return rightWeight;
    }
}