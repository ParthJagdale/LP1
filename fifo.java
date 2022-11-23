
import java.util.*;

class demo {   
    static int pageFaults(int pages[], int n, int capacity) {
    
        HashSet<Integer> s = new HashSet<>(capacity);
        Queue<Integer> indexes = new LinkedList<>(); 

        int page_faults = 0;
        for (int i = 0; i < n; i++) {
           
            if (s.size() < capacity) {
         
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);

                    page_faults++;
e
                    indexes.add(pages[i]);
                }
            }
            else {
               
                if (!s.contains(pages[i])) {
               
                    int val = indexes.poll();


                    s.remove(val);

  
                    s.add(pages[i]);

  
                    indexes.add(pages[i]);

                    page_faults++;
                }
            }
        }

        return page_faults;
    }


    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of reference string: ");
        n = sc.nextInt();
        int pages[] = new int[n];
        
        int capacity;
        System.out.println("Enter the frame size: ");
        capacity = sc.nextInt();

        System.out.println("Enter the string : ");
        for(int i = 0; i<n; i++)
        {
            pages[i] = sc.nextInt();
        }
 
        int PF = pageFaults(pages, pages.length, capacity);
        System.out.println("page faults : "+PF);
        int PH = (n-PF); // page hits calculated
        System.out.println("page hits : "+PH);
    
    }
}
