/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sample;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author shanu
 */
public class Sample {

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase db = mongoClient.getDatabase("TicketBooking");
    MongoCollection<Document> collection;
    static List<List<String>> VlaueList = new ArrayList<List<String>>();
    static List<List<String>> KeyList = new ArrayList<List<String>>();

    public void InsetProfile(String coll, ArrayList<String> data) {

        collection = db.getCollection(coll);

        Document doc = new Document();
        doc.append("Name", data.get(0));
        data.remove(0);

        doc.append("Adhaar", data.get(0));
        data.remove(0);

        doc.append("Phone", data.get(0));
        data.remove(0);

        doc.append("Balance", data.get(0));
        data.remove(0);

        doc.append("Password", data.get(0));
        data.remove(0);

        collection.insertOne(doc);
        System.out.println("New User Created!!!");
    }

    public static List<String> getKeys(String str, int n) {
        // TODO Auto-generated constructor stub
        String idString;
        String nonId = str;
        List<String> anList = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            nonId = nonId.substring(nonId.indexOf('_') + 1);
            try {
                idString = nonId.substring(0, nonId.indexOf('='));
            } catch (Exception e) {
                idString = nonId.substring(0, nonId.indexOf(' '));
            }
            nonId = nonId.substring(nonId.indexOf(' ') + 1);
            anList.add(idString);
        }
        return anList;

    }

    public static List<String> getValues(String str, int n) {
        String idString;
        String nonId = str;
        List<String> anList = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            nonId = nonId.substring(nonId.indexOf('=') + 1);

            try {
                idString = nonId.substring(0, nonId.indexOf(','));
            } catch (Exception e) {
                idString = nonId.substring(0, nonId.indexOf('}'));
            }

            anList.add(idString);
        }

//		System.out.println(anList);
        return anList;
    }

    public List<List<String>> pullOneData(String key,String val, String coll) {
        System.out.println("this is done");
        collection = db.getCollection(coll);
//        String[] ansList;
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(key, val);
        System.out.println("Retrieving specific Mongo Document");
        MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
        System.out.println("DOne with this");

//		System.out.println(cursor.next().toString());
        

        while (cursor.hasNext()) {
            VlaueList.add(getValues(cursor.next().toString(), 7));
        }

        return VlaueList;
    }
    
    public void InsertTicker(String data[], String Coll){
        Document doc = new Document();
        collection = db.getCollection(Coll);
        
        doc.append("From", data[0]);
        doc.append("To", data[1]);
        doc.append("Price", data[2]);
        doc.append("UID", data[3]);
        doc.append("Type", data[4]);
        doc.append("Platform", data[5]);
        
        collection.insertOne(doc);
        System.out.println("Ticket Successfully Stored");
    }
    
    public void update(String fromK, String fromV, String toK, String toV){
        collection = db.getCollection("Accounts");
        collection.updateOne(Filters.eq(fromK, fromV), Updates.set(toK, toV));
    }

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        new Sample();
    }
}
