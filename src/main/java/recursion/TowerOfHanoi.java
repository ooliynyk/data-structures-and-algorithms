package recursion;


public class TowerOfHanoi {

    public void doTower(int size, char from, char inter, char to) {
        if (size == 1) {
            System.out.printf("Disk 1 from %c to %c\n", from, to);
        } else {
            doTower(size-1, from, to, inter);
            System.out.printf("Disk %d from %c to %c\n", size, from, to);
            doTower(size-1, inter, from, to);
        }
    }

}
