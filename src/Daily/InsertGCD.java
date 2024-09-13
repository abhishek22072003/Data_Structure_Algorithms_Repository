package Daily;
// comment this class if you are submitting on leetcode
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
class InsertGCD {
    static int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a, a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode(-1);
        if(head==null || head.next==null)
            return head;
        ListNode ans = dummy;
        ListNode  curr = head;
        ListNode next = curr.next;
        ans.next = curr;
        ans  = ans.next;
        while(next!=null){
            int val = gcd(curr.val, next.val);
            //System.out.println("values got "+curr.val+" "+next.val);
            ListNode newNode = new ListNode(val);
            ans.next = newNode;
            ans = ans.next;
            ans.next = next;
            ans = ans.next;
            curr = next;
            next  = next.next;
        }
        return dummy.next;
    }
}