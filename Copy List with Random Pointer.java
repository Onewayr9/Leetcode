/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode copyhead = new RandomListNode(head.label);
        map.put(head,copyhead);
        RandomListNode node = head;
        while(node!=null){
            if(!map.containsKey(node)){
                RandomListNode copyNode = new RandomListNode(node.label);
                map.put(node,copyNode);
            }
            RandomListNode ran = node.random;
            if(ran==null){
                map.get(node).random = null;
            }else if(!map.containsKey(ran)){
                RandomListNode copyRandom = new RandomListNode(ran.label);
                map.get(node).random = copyRandom;
                map.put(ran,copyRandom);
            }else{
                map.get(node).random = map.get(ran);
            }
            RandomListNode nex = node.next;
            if(nex==null){
                map.get(node).next = null;
            }else if(!map.containsKey(nex)){
                RandomListNode copyNext = new RandomListNode(nex.label);
                map.get(node).next = copyNext;
                map.put(nex,copyNext);
            }else{
                map.get(node).next = map.get(nex);
            }
            node = node.next;
        }
        return copyhead;
    }
}