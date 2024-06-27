package com.kaanju;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ItemApplication {

    public static void main(String[] args) throws JAXBException, IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter # of items per file: ");
        int noOfItemsPerFile = scan.nextInt();
        System.out.println("Enter file path: ");
        String tag = scan.next().split("\\.")[0];
        System.out.print(tag);
        String fileName = tag + ".xml";


        int fileNameSuffix = 1;

        Items itemList1 = new Items();
        int itemsInFile = 0;
        Items itemList = createItemFromFile(fileName);
        for (int i = 0; i < itemList.getItemList().size(); i++) {
            itemList1.addItem(itemList.getItemList().get(i));
            itemsInFile += 1;
            if (itemsInFile >= noOfItemsPerFile) {
                writeItemToFile(itemList1, tag + "_" + fileNameSuffix + ".xml");
                itemsInFile = 0;
                itemList1 = new Items();
                fileNameSuffix += 1;
            }

            System.out.println(itemList.getItemList().get(i).getId());
        }
        if (itemsInFile > 0) {
            writeItemToFile(itemList1, "./tags_" + fileNameSuffix + ".xml");
        }
    }

    private static Items createItemsFromOtherItems(Items originalItems) {
        Items items = new Items();
        for(Item originalItem: originalItems.getItemList()) {
            items.addItem(originalItem);
        }
        return items;
    }

    public static Item createItem(String id, String author) {
        Item item = new Item();
        item.setId(id);
        item.setAuthor(author);
        return item;
    }

    public static void writeItemToFile(Items items, String fileName) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Items.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(items, new File(fileName));
    }

    public static Items createItemFromFile(String fileName) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Items.class);
        return (Items) context.createUnmarshaller()
                .unmarshal(new FileReader(fileName));
    }



}
