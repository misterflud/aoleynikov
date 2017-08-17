package ru.generator.Parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 * Created by Anton on 12.07.2017.
 */
public class XmlParameters {

    /**
     * Width table.
     */
    private int widthTable;

    /**
     * Height table.
     */
    private int heightTable;

    /**
     * Width of the first column.
     */
    private int widthNumber;

    /**
     * Width of the second column.
     */
    private int widthDate;

    /**
     * Width of the third column.
     */
    private int widthName;

    /**
     * Getter.
     * @return int
     */
    public int getWidthTable() {
        return widthTable;
    }

    /**
     * Getter.
     * @return int
     */
    public int getHeightTable() {
        return heightTable;
    }

    /**
     * Getter.
     * @return int
     */
    public int getWidthNumber() {
        return widthNumber;
    }

    /**
     * Getter.
     * @return int
     */
    public int getWidthDate() {
        return widthDate;
    }

    /**
     * Getter.
     * @return int
     */
    public int getWidthName() {
        return widthName;
    }


    /**
     * Constructor.
     * @param path path
     */
    public XmlParameters(String path) {
        parser(path);
    }

    /**
     * Parser xml.
     * @param path file
     */
    private void parser(String path) {
        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        final int zero = 0;
        final int one = 1;
        final int two = 2;
        final int three = 3;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList1 = document.getElementsByTagName("width");
            NodeList nodeList2 = document.getElementsByTagName("height");

            this.widthTable = Integer.parseInt(nodeList1.item(zero).getTextContent());
            this.heightTable = Integer.parseInt(nodeList2.item(zero).getTextContent());

            this.widthNumber = Integer.parseInt(nodeList1.item(one).getTextContent());
            this.widthDate = Integer.parseInt(nodeList1.item(two).getTextContent());
            this.widthName = Integer.parseInt(nodeList1.item(three).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
