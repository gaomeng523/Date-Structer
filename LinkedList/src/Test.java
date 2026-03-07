public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        //mySingleList.createList();


        /*mySingleList.addFirst(12);
        mySingleList.addFirst(23);
        mySingleList.addFirst(34);
        mySingleList.addFirst(45);
        mySingleList.addFirst(56);
        mySingleList.addFirst(67);*/

        mySingleList.addLast(12);
        mySingleList.addLast(23);
        mySingleList.addLast(34);
        mySingleList.addLast(45);
        mySingleList.addLast(56);
        mySingleList.addLast(67);


        mySingleList.display();
        System.out.println();
        System.out.println("节点个数：");
        System.out.println(mySingleList.size());
    }
}
