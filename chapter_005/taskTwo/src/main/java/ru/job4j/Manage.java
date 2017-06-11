package ru.job4j;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Anton on 10.06.2017.
 */
public class Manage {


    private Book book1 = new Book();
    private Book book2 = new Book();
    private Book book3 = new Book();


    public void startGlass(String path) throws Exception {
        takeXmlLine(path);
        print();
    }

    private DefaultHandler handler = new DefaultHandler() {

        String tagAdd = "AddOrder";

        String tagDelete = "DeleteOrder";


        /**
         * Метод вызывается, когда SAXParser начинает обработку тэга
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals(tagAdd)) {
                manage(new Action(attributes.getValue(0), attributes.getValue(1), attributes.getValue(2) , attributes.getValue(3), attributes.getValue(4)));
            } else if (qName.equals(tagDelete)) {
                manage(new Action(attributes.getValue(0), attributes.getValue(1)));
            }
        }
    };

    public Action takeXmlLine(String path) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Стартуем разбор XML-документа
            File file = new File(path);
            saxParser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private void manage(Action action) {

        if (action.book.equals("book-1")) {
            book1.bookManage(action);
        } else if (action.book.equals("book-2")) {
            book2.bookManage(action);
        } else {
            book3.bookManage(action);
        }
    }
    private void print() {
        book1.print();
        book2.print();
        book3.print();
    }
}
