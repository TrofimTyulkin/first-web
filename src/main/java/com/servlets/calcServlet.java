package com.servlets;

import java.io.*;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calc.*;
import com.pdf.ListenerPDF;
  
/*излагаю смысл этой штуки 
 * сервлеты это чисто бэкэнд
 * в индекс.хтмл мы ввели данные и на репортит сюда, мы отрабатываем логику, изменяем(дописываем) реквест(данные)
 * и репортимся на тот же индекс.хтмл и передаем наши подсчеты
*/
public class calcServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
		
		
		final PrintWriter writer = response.getWriter();

		System.out.println("GET");

		File f = new File(this.getClass().getResource("/").getPath()); 
		writer.println(f);
		
		
		String absolutePath = f.getAbsolutePath();
		String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
		String test = filePath.substring(0,filePath.lastIndexOf(File.separator));
		writer.println("123123"+filePath.substring(0,filePath.lastIndexOf(File.separator)));
		ServletContext context = request.getServletContext();
		writer.println("PATH "+context.getRealPath("/"));
				
		
		File myObj = new File(filePath.substring(0,filePath.lastIndexOf(File.separator)) + File.separator +"tes1.txt");
		File myObj1 = new File(context.getRealPath("/") + "tes11.txt");
		try {
			writer.println(filePath.substring(0,filePath.lastIndexOf(File.separator)) + "\tes1.txt");
			//myObj.createNewFile();
			myObj1.createNewFile();
			writer.println("complete creating");
			
		} catch (IOException e1) {
			writer.println("ERRRRROOR "+e1.getCause());
		}

		File f1 = new File(this.getClass().getResource("").getPath()); 
		writer.println(f1);
		
		File directory = new File (""); // Параметр пуст 
		 String courseFile = directory.getCanonicalPath() ; 
		writer.println(courseFile); 
		
		URL xmlpath = this.getClass().getClassLoader().getResource(""); 
		writer.println(this.getClass().getClassLoader().getResource(""));
		
		writer.println( System.getProperty("java.class.path"));
		writer.println(System.getProperty("user.dir"));
		
		FileOutputStream fout;
	    try {
	        fout = new FileOutputStream("title.txt");
	        new PrintStream(fout).println(request.getParameter("txttitle"));
	        fout.close();
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    	writer.println(e.getMessage());
	    }
	
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");//потратил вечность на эту строку кода
    	request.setAttribute("error", "");//короче если с вычислениями ошибка от передается этот атрибут и 
    	//на фронте покажется что это ошибка
    	
		System.out.println("POST");

		//пытаясь формировать любой файл через код я ловлю ошибку и отказ в доступе
		//при этом это чисто серверный прикол я хз
		//когда этот код запускаешь в другом классе без привязки к серверу все ок
		//https://www.tutorialspoint.com/jsp/jsp_file_uploading.htm может помочь
		//кст файл из корня также не загружается на фронт, а из webapp спокойно
		//UPD я всё пофиксил там был дикий прикол с путями
		
		String[] from = ContentContainer.getFrom();
		  
		boolean hasGas = false;
		boolean fromCountry = false;
		
		try { 
			if(request.getParameter("hasGas").equals("has")) hasGas=true;	
		
		}catch(Exception e) { 
			   
		}
		
		if(request.getParameter("from").equals(from[1])) fromCountry=true;

		
		String[] tarifs = ContentContainer.getMeasures();
		
		int tarif = 1;
		
		System.out.println("select " + request.getParameter("select"));
		try{
			if (request.getParameter("select").equals(tarifs[0])) tarif=1;
			if (request.getParameter("select").equals(tarifs[1])) tarif=2;
			if (request.getParameter("select").equals(tarifs[2])) tarif=3;
		}catch(Exception e){
			
		}
		
		
		double sum = 0;

		 if (tarif==1){
			 int ind11 = 0;
			 int ind12 = 0;
			 try{
				 ind11 = Integer.parseInt(request.getParameter("11"));
				 ind12 = Integer.parseInt(request.getParameter("12"));
				 if (ind12-ind11<0) {
					 request.setAttribute("error", "yes");
				 }else {
					Tarif1 t = new Tarif1();
					double out = t.calcer(ind12-ind11,hasGas,fromCountry); 
					sum = Tarif1.getRes();
					request.setAttribute("calc" , t.toString());
					ServletContext context = request.getServletContext();
					
					ListenerPDF.createPDF(tarif-1, context.getRealPath("/"),
							new double[]{ind11,ind12}, new double[] {out}, !hasGas ||fromCountry);
				 }
				 
			 }catch(NumberFormatException e){
				 request.setAttribute("error", "yes"); // TODO UDALIT POTOM
			 }
			 
			 
		 }
		 if (tarif==2){
			 try{
				 int ind11 = Integer.parseInt(request.getParameter("11"));
				 int ind12 = Integer.parseInt(request.getParameter("12"));
				 int ind21 = Integer.parseInt(request.getParameter("21"));
				 int ind22 = Integer.parseInt(request.getParameter("22"));
				 if (ind12-ind11<0 || ind22-ind21<0) {
					 request.setAttribute("error", "yes");
				 }
				 else {
					 Tarif2 t = new Tarif2();
					 double[] out = t.calcer(ind12-ind11,ind22-ind21,hasGas,fromCountry);
					 sum = Tarif2.getRes();
					 request.setAttribute("calc", t.toString());
						ServletContext context = request.getServletContext();
						ListenerPDF.createPDF(tarif-1, context.getRealPath("/"),
								new double[]{ind11,ind12, ind21,ind22}, out, !hasGas ||fromCountry);
				 }
				 
			 }catch(NumberFormatException e){
				 request.setAttribute("error", "yes"); // TODO UDALIT POTOM
			 }
			 
		 }
		 
		 
		 if (tarif==3){
			 try{
				 int ind11 = Integer.parseInt(request.getParameter("11"));
				 int ind12 = Integer.parseInt(request.getParameter("12"));
				 int ind21 = Integer.parseInt(request.getParameter("21"));
				 int ind22 = Integer.parseInt(request.getParameter("22"));
				 int ind31 = Integer.parseInt(request.getParameter("31"));
				 int ind32 = Integer.parseInt(request.getParameter("32"));
				
					 System.out.println("12313123"+request.getParameter("11"));
				 
				 if (ind12-ind11<0 || ind22-ind21<0 || ind32-ind31<0) {
					 request.setAttribute("error", "yes");
				 }else {
					Tarif3 t = new Tarif3();
					double[] out = t.calcer(ind12-ind11, ind22-ind21, ind32-ind31,hasGas,fromCountry); 
					sum = Tarif3.getRes();
				    request.setAttribute("calc", t.toString());
					ServletContext context = request.getServletContext();
					ListenerPDF.createPDF(tarif-1, context.getRealPath("/"),
							new double[]{ind11,ind12, ind21,ind22, ind31,ind32}, out, !hasGas ||fromCountry);
				 }
				 
			 }catch(NumberFormatException e){
				 request.setAttribute("error", "yes"); // TODO UDALIT POTOM
			 }

		 } 
		 
		System.out.println("12313123"+request.getParameter("11").equals(""));
		request.setAttribute("sum", String.format("%.2f",sum));
		request.setAttribute("tarif", tarif);
		


		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }    
}