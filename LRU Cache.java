class Node{
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    int capacity = 0;
    HashMap<Integer,Node> cache;
    Node head = null;
    Node end = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node n = cache.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }else{
            return -1;
        }
    }
    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
    }
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
        if(head!=null)
            head.pre = n;
        head = n;
        if(end ==null)
            end = head;
    }
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            Node old = cache.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(cache.size()>=capacity){
                cache.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
            cache.put(key, created);
        }
    }
}