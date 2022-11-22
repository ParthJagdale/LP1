import java.util.*;

class priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, temp;
        int avgtat, avgwt;
        avgtat = 0;
        avgwt = 0;
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();
        int prio[] = new int[n];
        int p_id[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];

        System.out.println("Enter burst time and priority:");
        for (int i = 0; i < n; i++) {
            System.out.println("for process " + (i + 1));
            bt[i] = sc.nextInt();
            prio[i] = sc.nextInt();
            p_id[i] = (i + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (prio[j] < prio[j + 1]) {
                    temp = prio[j];
                    prio[j] = prio[j + 1];
                    prio[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = p_id[j];
                    p_id[j] = p_id[j + 1];
                    p_id[j + 1] = temp;
                }
            }
        }

        // calculations
        wt[0] = 0;
        avgwt = 0;
        tat[0] = bt[0];
        avgtat = tat[0];
        for (int i = 1; i < n; i++) {
            wt[i] = tat[i - 1];
            avgwt += wt[i];
            tat[i] = wt[i] + bt[i];
            avgtat += tat[i];
        }

        // display

        System.out.println("process \t Burst_Time \t priority \t waiting \t turn_around_time");
        for (int i = 0; i < n; i++) {
            System.out
                    .println("P" + p_id[i] + "\t\t" + bt[i] + "\t\t" + prio[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }
        System.out.println("average wating time:" + (avgwt / n));
        System.out.println("average turn_around_time:" + (avgtat / n));

    }
}
