import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

public class BeanTest {


    public static void main(String[] args) {
        Album album = new Album(1, "the doors", "the doors", LocalDate.of(1996, 12, 15), 15 , "rock");
        Album album2 = new Album(2, "2 pac", "All eyez on me", LocalDate.of(1996, 11, 25), 50000, "rap");

        Author author = new Author(1, "john", "doe");
        Author author1 = new Author(2, "billy", "joe");

        Quote quote = new Quote(1, "don't panic plz!", author);
        Quote quote2 = new Quote(2, "don't stress plz!", author1);

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote);
        quotes.add(quote2);

//        for(Quote quoteItem: quotes){
//            System.out.println(quoteItem.getContent());
//            System.out.println(quoteItem.getAuthor().getFirstName() + " " + quoteItem.getAuthor().getLastName());
//        }

        System.out.println(album.getRelease_date());
    }

}
