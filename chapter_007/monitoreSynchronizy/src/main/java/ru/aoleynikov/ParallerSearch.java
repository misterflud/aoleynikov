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

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;

/**
 * 
 * @author Anton Oleynikov
 * created on 08.08.2017
 */
public class ParallerSearch {
//Можно без потоков, используя рекурсию
	//запускать на каждую директорию свой поток, в котором пробегаются по всем файлам, а при попадании на папку запускает такой же поток для нее
	
	
	
	private String root;
	
	//private InputStreamReader inputStreamReader = new InputStreamReader(new File(root).)
	
	private String text;
	
	private ArrayList<String> exts;
	
	private ArrayList<String> result = new ArrayList<>();
	
	public ParallerSearch(String root, String text, ArrayList<String> exts) {
		this.root = root;
		this.text = text;
		this.exts = exts;
	}
	
	public synchronized ArrayList<String> start() {
		Thread thread = new Searcher(root);
		
		try {
			thread.join(); //join не работает
			Thread.sleep(5000); //
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
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
	
	private boolean insideDoc(File file) {
		
		return false;
	}
	
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
	
	private synchronized void addResult(String path) {
		result.add(path);
	}
	
	
	/**
	 * 
	 * @author Anton Oleynikov
	 * created on 11.08.2017
	 */
	private class Searcher extends Thread {
		
		private String startPath;
		
		public Searcher(String startPath) {
			this.startPath = startPath;
			this.start();
		}
		

		
		@Override
		public void run() {
			String ext;
			File file = new File(startPath);
			File[] files = file.listFiles();
			for (File iter : files) {
				ext = extention(iter.getName());
				//System.out.println(iter.getAbsolutePath());
				if (iter.isDirectory()) {
					new Searcher(iter.getAbsolutePath());
				} else if (exts.contains(extention(iter.getName()))) { //(exts.contains(extention(iter.getName())))
					//System.out.println(iter.getAbsolutePath());
					insideSearcher(iter, ext);
				}
			}
		}
		
		private String extention(String fileName) {
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
