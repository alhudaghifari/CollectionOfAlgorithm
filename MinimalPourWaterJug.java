public class MinimalPourWaterJug {

    private static int minPourWaterJugAlgorithm(int jug1, int jug2, int target) {
        int n1 = 0;
        int m2 = 1;
        int step = 0;
        int jugTarget[] = new int[2];
        boolean flagRun = true;
        if (target == jug1 || target == jug2)
            return 1;

        jugTarget[n1] = jug1;
        while (flagRun) {
            step++;
            if (jugTarget[n1] == 0) {
                jugTarget[n1] = jug1;
            }

            if (jugTarget[m2] + jugTarget[n1] > jug2) {
                jugTarget[n1] = (jugTarget[m2] + jugTarget[n1]) - jug2;
                jugTarget[m2] = jug2;
            } else {
                jugTarget[m2] += jugTarget[n1];
                jugTarget[n1] = 0;
            }

            if (jugTarget[n1] == 0) {
                jugTarget[n1] = jug1;
            }

            if (jugTarget[m2] == jug2) {
                jugTarget[m2] = 0;
            }

            if (jugTarget[n1] == target || jugTarget[m2] == target) {
                flagRun = false;
            }
        }

        return step;
    }

    public static int minimalPourWaterJug(int jug1, int jug2, int target) {
        int step1 = minPourWaterJugAlgorithm(jug1, jug2, target);
        int step2 = minPourWaterJugAlgorithm(jug2, jug1, target);
        return (step1 < step2) ? step1 : step2;
    }

    public static void main(String[] args) {
        int step = minimalPourWaterJug(4, 7, 5);
        System.out.println("step yang dibutuhkan dari (4, 7, 5) : " + step);
        step = minimalPourWaterJug(4, 7, 3);
        System.out.println("step yang dibutuhkan dari (4, 7, 3) : " + step);
        step = minimalPourWaterJug(3, 5, 1);
        System.out.println("step yang dibutuhkan dari (3, 5, 1) : " + step);
        step = minimalPourWaterJug(3, 5, 4);
        System.out.println("step yang dibutuhkan dari (3, 5, 4) : " + step);
    }
}