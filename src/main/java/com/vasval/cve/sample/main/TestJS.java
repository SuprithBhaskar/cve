package com.vasval.cve.sample.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestJS {

	public static void main(String[] args) {

		try {

			System.out.println("uhfidu");
			ScriptEngineManager factory = new ScriptEngineManager();
			// create a JavaScript engine

			// System.out.println(Files.newBufferedReader(Paths.get("F:\\adapa.csv")));
			System.out.println(new java.io.FileReader(
					"F:\\Data\\Spring\\workspace\\mongodb\\src\\main\\java\\com\\mkyong\\core\\hello.js"));
			ScriptEngine engine = factory.getEngineByName("JavaScript");
			// evaluate JavaScript code from String
			engine.eval("print('Welcome to java world')");

			/*
			 * URL fileUrl = getClass().getResource("js/WebWorker.js");
			 * engine.eval(Files.newBufferedReader(Paths.get(fileUrl.toURI(‌​)),
			 * StandardCharsets.‌​UTF_8));
			 */

			// engine.eval(new java.io.FileReader(
			// "F:\\Data\\Spring\\workspace\\mongodb\\src\\main\\java\\com\\mkyong\\core\\welcome3.js"));
			engine.eval(Files.newBufferedReader(Paths
					.get("F:\\Data\\Spring\\workspace\\mongodb\\src\\main\\java\\com\\mkyong\\core\\welcome3.js")));
			// Paths.get("C:/Scripts/Jsfunctions.js")
			Invocable inv = (Invocable) engine;
			// call function from script file
			inv.invokeFunction("readTextFile", "file:///F:/Data/Suprith/VASVAL/sample.xml");

			System.out.println("SUP");

			// System.out.println(Files.newBufferedReader(
			// Paths.get("F:\\Data\\Spring\\workspace\\mongodb\\src\\main\\java\\com\\mkyong\\core\\hello.js")));

			System.out.println(Files.newBufferedReader(Paths.get("F:\\adapa.csv")));
			/*
			 * .get(
			 * "F:\\Data\\Spring\\workspace\\mongodb\\src\\main\\java\\com\\mkyong\\core\\hello.js"
			 * )), (ScriptContext) StandardCharsets.UTF_8);
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
