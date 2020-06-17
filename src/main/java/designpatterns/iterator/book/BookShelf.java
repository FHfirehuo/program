package designpatterns.iterator.book;

public class BookShelf implements Aggregate {

    private Book[] books;
    int pointer = 0;


    public BookShelf(int max_size) {
        books = new Book[max_size];
    }

    public void appendBook(Book book) {
        books[pointer] = book;
        pointer++;
    }

    public Book findBookAt(int index) {
        return books[index];
    }

    public int getLength() {
        return pointer;
    }

    /**
     * @return
     */
    public FireIterator iterator() {
        return new BookShelfIterator(this);
    }

    private class BookShelfIterator implements FireIterator {

        BookShelf bookShelf;
        int index;

        public BookShelfIterator(BookShelf bookShelf) {
            this.bookShelf = bookShelf;
            index = 0;
        }

        public boolean hasNext() {
            if (index < this.bookShelf.getLength()) {
                return true;
            }
            return false;
        }

        public Object next() {
            return bookShelf.findBookAt(index++);
        }
    }

}
