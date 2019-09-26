package List;

public class runSeqList {
    public static void main(String[] args) {
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(1,10);
        seqList.display();
        System.out.println(seqList.contains(10));
        System.out.println(seqList.search(10));
        seqList.remove(2);
        seqList.display();
    }
}
