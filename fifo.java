// Java implementation of FIFO page replacement
// in Operating Systems.
import java.util.*;

class demo {   // Method to find page faults using FIFO
    static int pageFaults(int pages[], int n, int capacity) {
        // To represent set of current pages. We use
        // an unordered_set so that we quickly check
        // if a page is present in set or not
        HashSet<Integer> s = new HashSet<>(capacity);

        // To store the pages in FIFO manner
        Queue<Integer> indexes = new LinkedList<>(); ///removing element out of the array from 1st position

        // Start from initial page
        int page_faults = 0;
        for (int i = 0; i < n; i++) {
            // Check if the set can hold more pages
            if (s.size() < capacity) {
                // Insert it into set if not present
                // already which represents page fault
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);

                    // increment page fault
                    page_faults++;

                    // Push the current page into the queue
                    indexes.add(pages[i]);
                }
            }

            // If the set is full then need to perform FIFO
            // i.e. remove the first page of the queue from
            // set and queue both and insert the current page
            else {
                // Check if current page is not already
                // present in the set
                if (!s.contains(pages[i])) {
                    // Pop the first page from the queue
                    int val = indexes.poll();

                    // Remove the indexes page
                    s.remove(val);

                    // insert the current page
                    s.add(pages[i]);

                    // push the current page into
                    // the queue
                    indexes.add(pages[i]);

                    // Increment page faults
                    page_faults++;
                }
            }
        }

        return page_faults;
    }

    // Driver method
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
 
        int PF = pageFaults(pages, pages.length, capacity); // page faults calculated
        System.out.println("page faults : "+PF);
        int PH = (n-PF); // page hits calculated
        System.out.println("page hits : "+PH);
        // System.out.println("Faults rate: "+(PF/n)*100);
        // System.out.println("Hits rate: "+(PH/n)*100);
    }
}