package resServlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.awt.geom.Line2D;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfChunk;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfLine;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;



public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Document document = new Document();
		HttpSession os=request.getSession(false);
		try{
		    response.setContentType("application/pdf");
		    PdfWriter writer=PdfWriter.getInstance(document, response.getOutputStream());
		    
		    document.setPageSize(PageSize.A4);
		    document.setMargins(50, 50, 50, 30);//margins-> (left,right,top,bottom)
		    document.open();
		    
		    //Resume Heading Start
		    Font font_res = FontFactory.getFont(FontFactory.TIMES_BOLD, 22, BaseColor.BLACK);
		    Chunk chunk_res=new Chunk("Resume",font_res);
		    Paragraph para_res=new Paragraph();
		    para_res.add(chunk_res);
		    para_res.setAlignment(Paragraph.ALIGN_CENTER);
		    document.add(para_res);
		    //Resume Heading Stop
		    
		    //font for headings
		    Font font_head=FontFactory.getFont(FontFactory.TIMES_BOLD,16,BaseColor.BLACK);
		    //font for overall text
		    Font font=FontFactory.getFont(FontFactory.TIMES,14,BaseColor.BLACK);
		    //font for table headings
		    Font font_table=FontFactory.getFont(FontFactory.TIMES_BOLD,14,BaseColor.BLACK);
		    
		    //writing name, mob_no and email id
		    Chunk chunk_1=new Chunk((String) os.getAttribute("name")+"\n",font);
		    Paragraph para_1=new Paragraph();
		    para_1.add(chunk_1);
		    chunk_1=new Chunk((String) os.getAttribute("mob_no"),font);
		    para_1.add(chunk_1);
		    chunk_1=new Chunk(new VerticalPositionMark());
		    para_1.add(chunk_1);
		    chunk_1=new Chunk((String) os.getAttribute("user_id"),font);
		    para_1.add(chunk_1);
		    para_1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		    document.add(para_1);
		    //end
		    
		    //making a line
		    PdfContentByte canvas = writer.getDirectContent();
	        CMYKColor magentaColor = new CMYKColor(0,0,0,10000);
	        canvas.setColorStroke(magentaColor);
	        canvas.moveTo(5, 735);
	        canvas.lineTo(590, 735);//595 is max for x-axis
	        canvas.closePathStroke();
	        //end
	        
	        //adding a new line
	        Chunk chunk_new=new Chunk("\n");
	        document.add(chunk_new);
	        
	        //for career objectives
	        Chunk chunk_2=new Chunk("Career Objective:",font_head);
	        Paragraph para_2=new Paragraph();
	        para_2.add(chunk_2);
	        chunk_2=new Chunk("\n"+"To Contribute in the growth of the organization"+"\n",font);
	        para_2.add(chunk_2);
	        para_2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	        document.add(para_2);
	        //end
	        
	        //adding a new line
	        document.add(chunk_new);
	        
	        //making the table for academics
	        //adding table heading
	        Chunk chunk_3=new Chunk("Academic Qualifications:",font_head);
	        document.add(chunk_3);
	        
	        //making table
	        int widths[]= {2,5,4,2,3};
	        PdfPTable table = new PdfPTable(5);
	        table.setWidths(widths);
	        
	        Phrase phrase_1_1=new Phrase();
	        phrase_1_1.add(new Chunk("Class",font_table));
	        table.addCell(phrase_1_1);
	        
	        Phrase phrase_1_2=new Phrase();
	        phrase_1_2.add(new Chunk("Name of School/ College",font_table));
	        table.addCell(phrase_1_2);
	        
	        Phrase phrase_1_3=new Phrase();
	        phrase_1_3.add(new Chunk("Board/ University",font_table));
	        table.addCell(phrase_1_3);
	        
	        Phrase phrase_1_4=new Phrase();
	        phrase_1_4.add(new Chunk("Year of Passing",font_table));
	        table.addCell(phrase_1_4);
	        
	        Phrase phrase_1_5=new Phrase();
	        phrase_1_5.add(new Chunk("Percentage",font_table));
	        table.addCell(phrase_1_5);
	        
	        Phrase phrase_2_1=new Phrase();
	        phrase_2_1.add(new Chunk("10th",font));
	        table.addCell(phrase_2_1);
	        
	        Phrase phrase_2_2=new Phrase();
	        phrase_2_2.add(new Chunk((String) os.getAttribute("tenscl"),font));
	        table.addCell(phrase_2_2);
	        
	        Phrase phrase_2_3=new Phrase();
	        phrase_2_3.add(new Chunk((String) os.getAttribute("board_10"),font));
	        table.addCell(phrase_2_3);
	        
	        Phrase phrase_2_4=new Phrase();
	        phrase_2_4.add(new Chunk(integer2String((int)os.getAttribute("year_10")),font));
	        table.addCell(phrase_2_4);
	        
	        Phrase phrase_2_5=new Phrase();
	        phrase_2_5.add(new Chunk(double2String((double)os.getAttribute("tenth")),font));
	        table.addCell(phrase_2_5);
	        
	        Phrase phrase_3_1=new Phrase();
	        phrase_3_1.add(new Chunk("12th",font));
	        table.addCell(phrase_3_1);
	        
	        Phrase phrase_3_2=new Phrase();
	        phrase_3_2.add(new Chunk((String) os.getAttribute("twescl"),font));
	        table.addCell(phrase_3_2);
	        
	        Phrase phrase_3_3=new Phrase();
	        phrase_3_3.add(new Chunk((String) os.getAttribute("board_12"),font));
	        table.addCell(phrase_3_3);
	        
	        Phrase phrase_3_4=new Phrase();
	        phrase_3_4.add(new Chunk(integer2String((int)os.getAttribute("year_12")),font));
	        table.addCell(phrase_3_4);
	        
	        Phrase phrase_3_5=new Phrase();
	        phrase_3_5.add(new Chunk(double2String((double)os.getAttribute("twelth")),font));
	        table.addCell(phrase_3_5);
	        
	        Phrase phrase_4_1=new Phrase();
	        phrase_4_1.add(new Chunk("B.Tech",font));
	        table.addCell(phrase_4_1);
	        
	        Phrase phrase_4_2=new Phrase();
	        phrase_4_2.add(new Chunk((String) os.getAttribute("clgname"),font));
	        table.addCell(phrase_4_2);
	        
	        Phrase phrase_4_3=new Phrase();
	        phrase_4_3.add(new Chunk((String) os.getAttribute("university"),font));
	        table.addCell(phrase_4_3);
	        
	        Phrase phrase_4_4=new Phrase();
	        phrase_4_4.add(new Chunk(integer2String((int)os.getAttribute("year_clg")),font));
	        table.addCell(phrase_4_4);
	        
	        Phrase phrase_4_5=new Phrase();
	        phrase_4_5.add(new Chunk(double2String((double)os.getAttribute("bclg")),font));
	        table.addCell(phrase_4_5);
	        
	        document.add(table);
	        //ending table
	        
	        //adding a line 
	        document.add(chunk_new);
	        
	        //displaying skills
	        Chunk chunk_4=new Chunk("Skills\n",font_head);
	        document.add(chunk_4);
	        Paragraph para_4=new Paragraph(20);
	        chunk_4=new Chunk(string2String((String)os.getAttribute("skills")),font);
	        para_4.setIndentationLeft(20);
	        para_4.add(chunk_4);  
		    document.add(para_4);
		    
		    //adding a line 
	        document.add(chunk_new);
		    
		    //displaying projects
		    Chunk chunk_5=new Chunk("Projects\n",font_head);
	        document.add(chunk_5);
		    Paragraph para_5=new Paragraph(20);
	        chunk_5=new Chunk(string2String((String)os.getAttribute("projects")),font);
	        para_5.setIndentationLeft(20);
		    para_5.add(chunk_5);  
		    document.add(para_5);
		    
		    //adding a line 
	        document.add(chunk_new);
		    
		    //displaying certifications
		    Chunk chunk_6=new Chunk("Certifications\n",font_head);
	        document.add(chunk_6);
		    Paragraph para_6=new Paragraph(20);
	        chunk_6=new Chunk(string2String((String)os.getAttribute("certi")),font);
	        para_6.setIndentationLeft(20);
		    para_6.add(chunk_6);  
		    document.add(para_6);
		    
		    //adding a line 
	        document.add(chunk_new);
		    
		    //displaying designation
		    Chunk chunk_7=new Chunk(new VerticalPositionMark());
		    Paragraph para_7=new Paragraph(20);
		    para_7.add(chunk_7);
		    chunk_7=new Chunk("Designation\n",font_head);
		    para_7.add(chunk_7);
		    chunk_7=new Chunk(new VerticalPositionMark());
		    para_7.add(chunk_7);
		    chunk_7=new Chunk((String)os.getAttribute("designation"),font);
		    para_7.add(chunk_7);
		    document.add(para_7);
		    
		}catch(Exception e){
		    e.printStackTrace();
		}
		    document.close();
		System.out.println((String)os.getAttribute("name"));
		System.out.println((String) os.getAttribute("board_10"));
	}
	
	public static String double2String(double number)
	{
		String ans = "";
		int temp_int = (int)number;
		while(temp_int > 0)
		{
			ans = (char)(temp_int % 10 + '0') + ans;
			temp_int = temp_int / 10;
		}
		ans = ans + '.';
		ans = ans + (char)((number * 10) % 10 + '0');//For one point
		ans = ans + (char)((number * 100) % 10 + '0');//For two
		//ans = ans + (char)((number * 1000) % 10 + '0');//For three
		return ans;
	}
	
	public static String integer2String(int number)
	{
		String ans = "";
		int temp_int = (int)number;
		while(temp_int > 0)
		{
			ans = (char)(temp_int % 10 + '0') + ans;
			temp_int = temp_int / 10;
		}
		return ans;
	}
	
	public static String string2String(String str)
	{
		str=str.trim();
		String ans = "";
		int count = 1;
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '<')//<br>
			{
				int j = i, temp = 0;
				for(; j < str.length() && temp < 4 ; ++temp, j++);
				if(temp == 4 && str.substring(i, i + temp).equals("<br>"))
				{
					if(j != str.length())
					{
						ans = ans + "\n" + (char)(count + '0') + ". ";
					}
					i += 3;
					count++;
				}
				else
				{
					if(i == 0)
					{
						ans = ans + (char)(count + '0') + ". ";
						count++;
					}
					ans = ans + str.charAt(i);
				}
			}
			else
			{
					if(i == 0)
					{
						ans = ans + (char)(count + '0') + ". ";
						count++;
					}
				ans = ans + str.charAt(i);
			}
		}
		return ans;
	}
	
	
}