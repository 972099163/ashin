package com.ashin.service.algorithm;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 输入  5   5
 *
 * 输入 1，8   0
 *
 * 输入 1       ，9  9
 * 输出 0  0  1
 */
public class AddTwoNumbers2 {
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       return getNode(l1,l2,0);
    }

    public static ListNode getNode(ListNode l1, ListNode l2,int addResult)
    {
        l1=l1==null?new ListNode(0):l1;
        l2=l2==null?new ListNode(0):l2;

        ListNode node=new ListNode((l1.val+l2.val+addResult)%10);
        if(l1.next==null && l2.next==null )
        {
            if(l1.val+l2.val+addResult>=10)
            {
                node.next=new ListNode(1);
            }

        }else
        {

            addResult=(l1.val+l2.val+addResult)/10;
            node.next=getNode(l1.next,l2.next,addResult);
        }

        return node;
    }

    public static void main(String[] args) {
        ListNode node1=  new ListNode(2);
        ListNode node2=  new ListNode(4);
        ListNode node3=  new ListNode(3);


        ListNode node4=  new ListNode(5);
        ListNode node5=  new ListNode(6);
        ListNode node6=  new ListNode(4);

        node1.next=node2;
        node2.next=node3;

        node4.next=node5;
        node5.next=node6;
        ListNode node=addTwoNumbers(node1,node4);
        System.out.println(node.toString());
    }

}
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val=x;
    }
    ListNode()
    {

    }

}


