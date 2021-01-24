import java.util.ArrayList;
import java.util.List;

class HashNode{
    int key;
    int value;

    HashNode next;

    public HashNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}


public class MyHashMap {

    private List<HashNode> buckets;
    private int capacity;
    private int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new ArrayList<>();
        capacity = 10;
        size = 0;
        for(int i = 0; i < 10; i++){
            buckets.add(null);
        }
    }

    private int getIndex(int key){
        return key%capacity;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        HashNode head = buckets.get(index);
        while(head!=null){
            if(head.key==key){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets.get(index);
        HashNode newNode = new HashNode(key, value);
        newNode.next=head;
        buckets.set(index, newNode);
        if(1.0*size/capacity >= 0.7){
            List<HashNode> temp = buckets;
            buckets = new ArrayList<>();
            capacity = 2*capacity;
            size=0;
            for(int i = 0; i < capacity; i++){
                buckets.add(null);
            }
            for(HashNode node : temp){
                while(node!=null){
                    put(node.key, node.value);
                    node=node.next;
                }
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        HashNode head = buckets.get(getIndex(key));
        while(head!=null){
            if(head.key == key){
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        HashNode head = buckets.get(getIndex(key));
        HashNode prev = null;
        while(head!=null){
            if(head.key == key){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null){
            return;
        }
        size--;
        if(prev!=null){
            prev.next = head.next;
        }
        else{
            buckets.set(getIndex(key),head.next);
        }
    }

}
