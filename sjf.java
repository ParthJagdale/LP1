import java.util.*;

public class sjf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, temp;
        int avgtat, avgwt;
        avgtat = 0;
        avgwt = 0;
        System.out.println("Enter number of processes: ");
        n = sc.nextInt();
        // int prio[]= new int[n];
        int p_id[] = new int[n];
        int bt[] = new int[n];
        int at[] = new int[n];
        int wt[] = new int[n];
        int ft[] = new int[n];
        int tat[] = new int[n];

        System.out.println("Enter bt and at:");
        for (int i = 0; i < n; i++) {
            System.out.println("for process " + (i + 1));
            bt[i] = sc.nextInt();
            at[i] = sc.nextInt();
            p_id[i] = (i + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (bt[j] > bt[j + 1]) {
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;
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
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ft[i] = at[i] + bt[i];
            } else {
                if (at[i] > ft[i - 1]) {
                    ft[i] = at[i] + bt[i];
                } else {
                    ft[i] = ft[i - 1] + bt[i];

                }
            }
            tat[i] = ft[i] - at[i];
            wt[i] = tat[i] - bt[i];
            avgwt += wt[i];
            avgtat += tat[i];
        }

        // display

        System.out.println("process \t Burst_Time \t Arival_Time \t finishing \t waiting \t turn_around_time");
        for (int i = 0; i < n; i++) {
            System.out
                    .println("P" + p_id[i] + "\t" + bt[i] + "\t" + at[i] + "\t" + ft[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        System.out.println("average wating time:" + (avgwt / n));
        System.out.println("average turn_around_time:" + (avgtat / n));

    }
}
