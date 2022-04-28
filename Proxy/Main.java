package Proxy;

/**
 * We are writing an example where we have a book-parser(3rd party library)
 * and whenever we instantiate this book-parser with a book it pre-parse the book to create statistics
 * about the book, and this parsing is computationally expensive.
 *
 * Now the Problem arises if we dotn call getters of this statistics so often, i.e. we don't need them often
 * So we want to Lazily Instantiate this book parser to save that extra automatic parsing on instantiation.
 *
 * We can use a proxy to delegate instantiation
 */

interface IBookParser{
    int statistics();
}

class BookParser implements IBookParser {
    private final int statsData;

    BookParser(String bookData) {
        System.out.println("Book Parser Initialized");
        /*
        * Some expensive computation to generate statistics
        *
        * We want to delegate this behaviour to a proxy
        * */

        this.statsData = bookData.length();
    }

    @Override
    public int statistics() {
        return this.statsData;
    }
}

/***
 * This Proxy HAS-A and IS-A IBookParser
 * same as Decorator pattern, only difference is the intent of lazy delegation in proxy
 * VS adding behaviours in decorator
 */

class LazyBookParserProxy implements IBookParser {
    private final String bookData;
    private BookParser bookParser = null;

    LazyBookParserProxy(String bookData) {
        this.bookData = bookData;
    }

    /*
    * If this method is called then we need statsData, so we will initialize
    * Book-parser if it is null.
    * */
    @Override
    public int statistics() {
        if (bookParser == null) {
            //Doing Costly work lazily
            this.bookParser = new BookParser(this.bookData);
        }

        return this.bookParser.statistics();
    }
}

public class Main {

    public static void main(String[] args) {
        LazyBookParserProxy lazyBookParserProxy = new LazyBookParserProxy("Sample book data");
        System.out.println("Only LazyBookParserProxy is initialized till now.");

        System.out.println(lazyBookParserProxy.statistics());
    }

}
