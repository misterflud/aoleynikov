package ru.job4j;

import java.io.File;
import java.util.HashMap;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Anton on 10.06.2017.
 */
public class Manage {

    /**
     * Books.
     */
    private HashMap<String, Book> books;


    /**
     * Start.
     * @param path pathFile
     * @throws Exception Exception
     */
    public void startGlass(String path, HashMap<String, Book> books) throws Exception {
        this.books = books;
        takeXmlLine(path);
        print();
    }

    /**
     * Handler for xml parser.
     */
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

    /**
     * Xml parser.
     * @param path path
     */
    public void takeXmlLine(String path) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Стартуем разбор XML-документа
            File file = new File(path);
            saxParser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Manager.
     * @param action action
     */
    private void manage(Action action) {
        books.get(action.book).bookManage(action);
}

    /**
     * Print book.
     */
    private void print() {
        books.forEach((k,v) -> v.print());
    }
}
