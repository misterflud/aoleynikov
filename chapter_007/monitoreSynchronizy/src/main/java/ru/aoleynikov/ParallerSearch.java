package ru.aoleynikov;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;

/**
 * Searcher.
 * @author Anton Oleynikov
 * created on 08.08.2017
 */
public class ParallerSearch {
//Можно без потоков, используя рекурсию
	//запускать на каждую директорию свой поток, в котором пробегаются по всем файлам, а при попадании на папку запускает такой же поток для нее
	
	private volatile int threadsCount = 0;
	/**
	 * Path of root.
	 */
	private final String root;
	
	//private InputStreamReader inputStreamReader = new InputStreamReader(new File(root).)
	
	/**
	 * Text witch we want to found.
	 */
	private final String text;
	
	/**
	 * Extension.
	 */
	private final CopyOnWriteArrayList<String> exts = new CopyOnWriteArrayList<String>();
	//private ArrayList<String> exts = new ArrayList<>();
	
	
	/**
	 * Paths of files with found text. 
	 */
	private final CopyOnWriteArrayList<String> result = new CopyOnWriteArrayList<>();
	//private ArrayList<String> result = new ArrayList<>();
	
	/**
	 * Constructor.
	 * @param root start path for search
	 * @param text text
	 * @param exts extension
	 */
	public ParallerSearch(String root, String text, ArrayList<String> exts) {
		this.root = root;
		this.text = text;
		this.exts.addAll(exts);
	}
	
	/**
	 * Start searching.
	 * @return
	 */
	public synchronized CopyOnWriteArrayList<String> start() {
		Thread thread = new Searcher(root);
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (threadsCount != 0) {
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * Searching the text in inside file.
	 * @param file file
	 * @param ext extension
	 * @return have or no text the inside the file
	 */
	private boolean insideSearcher(File file, String ext) {
		
		if (file.canRead()) {
			//System.out.println(file.getAbsolutePath());
			if ("txt".equals(ext)) {
				insideTxt(file);
			} else if ("xls".equals(ext)) {
				insideXls(file);
			} else if ("xlsx".equals(ext)) {
				insideXlsx(file);
			} else if ("doc".equals(ext)) {
				insideDoc(file);
			}
		}	
		return false;
	}
	
	/**
	 * Finding in xls.
	 * @param file file
	 * @return have or no text the inside the file
	 */
	private boolean insideXls(File file) {
		//System.out.println(file.getAbsolutePath());
		try(InputStream in = new FileInputStream(file); HSSFWorkbook wb = new HSSFWorkbook(in); ExcelExtractor extractor = new ExcelExtractor(wb)) {
	        extractor.setFormulasNotResults(false); // Считать формулы
	        extractor.setIncludeSheetNames(true);
	        String s = extractor.getText();
			if (s.contains(text)) {
				result.add(file.getAbsolutePath());//addResult(file.getAbsolutePath());
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(file.getAbsolutePath());
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Finding in xlsx.
	 * @param file file
	 * @return have or no text the inside the file
	 */
	private boolean insideXlsx(File file) {
		//System.out.println(file.getAbsolutePath());
		try(InputStream in = new FileInputStream(file); XSSFWorkbook wb = new XSSFWorkbook(in); XSSFExcelExtractor extractor = new XSSFExcelExtractor(wb)) {
	        extractor.setFormulasNotResults(false); // Считать формулы
	        extractor.setIncludeSheetNames(true);
	        String s = extractor.getText();
	      
			if (s.contains(text)) {
				//System.out.println(s);
				result.add(file.getAbsolutePath());//addResult(file.getAbsolutePath()); /?
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(file.getAbsolutePath());
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Finding in doc.
	 * @param file file
	 * @return have or no text the inside the file
	 */
	private boolean insideDoc(File file) {
		
		return false;
	}
	
	
	/**
	 * Finding in txt.
	 * @param file file
	 * @return have or no text the inside the file
	 */
	private boolean insideTxt(File file) {
		try (InputStream inp = new FileInputStream(file); InputStreamReader isr = new InputStreamReader(inp); BufferedReader reader = new BufferedReader(isr)) {
			String s = "";
			while ((s = reader.readLine()) != null ) {
				//System.out.println(s);
				if (s.contains(text)) {
					result.add(file.getAbsolutePath());//addResult(file.getAbsolutePath());
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Addding path to result.
	 * @param path path of file
	 */
	private synchronized void addResult(String path) {
		result.add(path);
	}
	
	
	/**
	 * Class for finding.
	 * @author Anton Oleynikov
	 * created on 11.08.2017
	 */
	private class Searcher extends Thread {
		
		private String startPath;
		
		public Searcher(String startPath) {
			this.startPath = startPath;
			this.start();
		}
		

		/**
		 * Start tread.
		 */
		@Override
		public void run() {
			threadsCount++;
			String ext;
			File file = new File(startPath);
			File[] files = file.listFiles();
			for (File iter : files) {
				ext = extension(iter.getName());
				//System.out.println(iter.getAbsolutePath());
				if (iter.isDirectory()) {
					new Searcher(iter.getAbsolutePath());
				} else if (exts.contains(extension(iter.getName()))) { //(exts.contains(extention(iter.getName())))
					//System.out.println(iter.getAbsolutePath());
					insideSearcher(iter, ext);
				}
			}
			threadsCount--;
		}
		
		/**
		 * Getting the extension of file.
		 * @param fileName
		 * @return
		 */
		private String extension(String fileName) {
			//System.out.println(fileName);
			String[] two = fileName.split("\\.");
			if (two.length == 2) {
				//System.out.println(two[1]);
				return two[1];
			} else {
				return "";
			} 
		}
		

	}
}
