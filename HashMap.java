import java.util.*;

public class OODHashMap {

    class ListNode{
        int key, value;
        ListNode next;
        public ListNode(int key, int value, ListNode next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    class HashMap{
        static final int size = 19997;
        ListNode[] data;

        public HashMap(){
            this.data=new ListNode[size];
        }
        private int hash(int key){
            return (int)((long)key % size);
        }
        public void put(int key, int value){
            remove(key);
            int h= hash(key);
            ListNode node=new ListNode(key, value, data[h]);
            data[h]=node;
        }
        public int get(int key){
            int h = hash(key);
            ListNode node=data[h];
            for(;node != null; node=node.next){
                if(node.key == key){
                    return node.value;
                }
            }
            return -1;
        }
        public void remove(int key){
            int h=hash(key);
            ListNode node=data[h];
            if(node == null){
                return;
            }
            if(node.key==key){
                data[h]=node.next;
            }else{
                for(;node.next != null;node=node.next){
                    if(node.next.key== key){
                        node.next=node.next.next;
                        return;
                    }
                }
            }
        }
    }    
}
