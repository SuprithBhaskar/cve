package com.vasval.cve.sample.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

/**
 * This Class will Insert Sample JSON file into MongoDB .
 * 
 */
public class CVEMitreMain {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("testdb");

			/**** Get collection / table from 'testdb' ****/

			DBCollection collection = db.getCollection("dummyColl");

			/**** Insert ****/

			System.out.println("JSON parse example...");

			String currentDirectory = new File("").getAbsolutePath();

			System.out.println(currentDirectory);

			Object obj = parser.parse(new FileReader(currentDirectory + "\\cve-mitre.json"));

			JSONObject jsonObject = (JSONObject) obj;
			System.out.println(jsonObject.toString());

			DBObject dbObject = (DBObject) JSON.parse(jsonObject.toString());

			collection.insert(dbObject);

			DBCursor cursorDocJSON = collection.find();
			while (cursorDocJSON.hasNext()) {
				System.out.println(cursorDocJSON.next());
			}

			/**** Done ****/
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
