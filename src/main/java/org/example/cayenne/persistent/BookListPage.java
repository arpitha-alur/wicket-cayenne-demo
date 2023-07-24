package org.example.cayenne.persistent;


import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import java.util.List;

public class BookListPage extends WebPage {

    public BookListPage() {
        ObjectContext context = ((CayenneWicketApplication) getApplication()).getCayenneRuntime().newContext();
        List<Book> books = ObjectSelect.query(Book.class).select(context);
        books.forEach(book -> add(new Label("title", Model.of(book.getName()))));
    }
}
