package daySeventyEightKSorted;

public class Solution {
    public static class NList {
        int value;
        NList next;

        public NList(int value) {
            this.value = value;
        }

    }

    public static NList mergeLists(int last, NList ...lists) {
    	last--;
    	
        while(last != 0) {
            int i = 0; 
            int j = last;
            while(i < j) {
                lists[i] = merge(lists[i], lists[j]);
                i++;
                j--;
            }
            last = j;
        }
        
        
        return lists[0];
        
    }

    public static NList merge(NList l1, NList l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }
        
        NList head = null;
        NList aux = null;
        
        if(l1.value < l2.value) {
            head = l1;
            l1 = l1.next;
            aux = head;
        } else {
            head = l2;
            l2 = l2.next;
            aux = head;
        }

        while(l1 != null && l2 != null) {
            if(l1.value < l2.value) {
                aux.next = l1;
                l1 = l1.next;
                aux = aux.next;
            } else {
                aux.next = l2;
                l2 = l2.next;
                aux = aux.next;
            }
        }
        
        if(l1 != null) {
        	aux.next = l1;
        } else {
        	aux.next = l2;
        }

        return head;
    }


    public static void main(String[] args) {
    	NList a = new NList(1);
    	NList b = new NList(2);
    	NList b1 = new NList(5);
    	NList c = new NList(3);
    	NList d = new NList(4);
    	
    	a.next = b;
    	b.next = b1;
    	c.next = d;
    	
    	NList merge = mergeLists(2, a, c);
    	while(merge != null) {
    		System.out.format("%d ", merge.value);
    		merge = merge.next;
    	}
    	System.out.println("");

    }



}
