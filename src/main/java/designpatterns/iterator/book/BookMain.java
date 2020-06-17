package designpatterns.iterator.book;

public class BookMain {


    public static void main(String[] args) {

        Book book1 = new Book("朝花夕拾");
        Book book2 = new Book("围城");
        Book book3 = new Book("遮天");
        Book book4 = new Book("寻秦记");
        Book book5 = new Book("骆驼祥子");

        BookShelf bookShelf = new BookShelf(5);

        bookShelf.appendBook(book1);
        bookShelf.appendBook(book2);
        bookShelf.appendBook(book3);
        bookShelf.appendBook(book4);
        bookShelf.appendBook(book5);

        /**
         * MyIterator，而不是BookShelfIterator，这样做的好处是完全屏蔽了内部的细节，
         * 在用户使用的时候，完全不知道BookShelfIterator的存在。
         *
         * 引入迭代器之后，可以将元素的遍历和实现分离开来，
         * 如下面的代码中的while循环，没有依赖与BookShelf的实现，
         * 没有使用BookShelf的其他方法，只是用了迭代器中hasNext和next方法。
         * 可复用指的是将一个类作为一个组件，当一个组件改变时，不需要对其他组件进行修改或者只进行少量的修改就可以实现修改后的功能。
         * MyIterator it= bookShelf.iterator();面向接口编程，便于程序的修改和维护。
         */
        FireIterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println("书的名字为《" + book.getName() + "》");
        }
    }
}
