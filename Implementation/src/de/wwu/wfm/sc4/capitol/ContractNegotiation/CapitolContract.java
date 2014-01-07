package de.wwu.wfm.sc4.capitol.ContractNegotiation;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class CapitolContract {

	String insuranceID = "17101989";
	double totalInsured = 13000;
	double premiumRate = 0.025f;
	double policyFee = 10;
	double premiumBasic = totalInsured * premiumRate;
	double premiumTotal = premiumBasic + policyFee;
	ByteArrayOutputStream outputStream;
	
	public CapitolContract() throws Exception {
		/* Basic document attributes */
		outputStream= new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4, Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(25), Utilities.millimetersToPoints(25));
		//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Capitol Contract.pdf"));
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		
		document.open();
		PdfContentByte canvas = writer.getDirectContent();
		float tableHeight;
		
		/* Header - Logo and document title*/
		Image img = Image.getInstance("Capitol.png");
        img.scaleToFit(Utilities.millimetersToPoints(25),Utilities.millimetersToPoints(25));
        img.setAbsolutePosition(Utilities.millimetersToPoints(175), Utilities.millimetersToPoints(262));
        document.add(img);
        Paragraph header = new Paragraph(Chunk.NEWLINE);
        header.setAlignment(Element.ALIGN_CENTER);
        header.add(Chunk.NEWLINE);
        header.add(Chunk.NEWLINE);
        header.add(new Phrase("MOTOR VEHICLE INSURANCE CONTRACT", Fonts.TITLE));
        document.add(header);
        
        /* Insurance Number */
        PdfPTable t0 = new PdfPTable(2);
        t0.getDefaultCell().setBorder(Rectangle.TOP);
        t0.getDefaultCell().setLeading(0f, 1.3f);
        t0.getDefaultCell().setPaddingTop(0);
        t0.getDefaultCell().setPaddingBottom(5);
        t0.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t0.addCell(new Phrase("Insurance Nr.", Fonts.NORMAL));
        t0.addCell(new Phrase(": " + insuranceID, Fonts.NORMAL));
        t0.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(242), canvas);
        tableHeight = t0.getTotalHeight();
        
		/* Policy holder */
        PdfPTable t1 = new PdfPTable(2);
        t1.getDefaultCell().setBorder(Rectangle.TOP);
        t1.getDefaultCell().setLeading(0f, 1.3f);
        t1.getDefaultCell().setPaddingTop(0);
        t1.getDefaultCell().setPaddingBottom(5);
        t1.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t1.addCell(new Phrase("Insured", Fonts.NORMAL));
        t1.addCell(new Phrase(": Jonathan Wilson", Fonts.NORMAL));
        t1.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t1.addCell(new Phrase("Address", Fonts.NORMAL));
        t1.addCell(new Phrase(": Hophop Str. 13, 48149 Muenster, Germany", Fonts.NORMAL));
        t1.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t1.getTotalHeight();

		/* Insurance Period */
        PdfPTable t2 = new PdfPTable(2);
        t2.getDefaultCell().setBorder(Rectangle.TOP);
        t2.getDefaultCell().setLeading(0f, 1.3f);
        t2.getDefaultCell().setPaddingTop(0);
        t2.getDefaultCell().setPaddingBottom(5);
        t2.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t2.addCell(new Phrase("Period of Insurance", Fonts.NORMAL));
        t2.addCell(new Phrase(": From 2013/10/01 to 2014/10/01",Fonts.NORMAL));
        t2.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t2.getTotalHeight();

		/* Insured Vehicle */
        PdfPTable t3 = new PdfPTable(2);
        t3.getDefaultCell().setBorder(Rectangle.TOP);
        t3.getDefaultCell().setLeading(0f, 1.3f);
        t3.getDefaultCell().setPaddingTop(0);
        t3.getDefaultCell().setPaddingBottom(5);
        t3.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t3.addCell(new Phrase("Insured Vehicle Details", Fonts.NORMAL));
        t3.addCell("");
        t3.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t3.addCell(new Phrase("Name of Vehicle", Fonts.NORMAL));
        t3.addCell(new Phrase(": Peugeot 207", Fonts.NORMAL));
        t3.addCell(new Phrase("License Plate Number", Fonts.NORMAL));
        t3.addCell(new Phrase(": B1846NFE", Fonts.NORMAL));
        t3.addCell(new Phrase("Vehicle Identification Number", Fonts.NORMAL));
        t3.addCell(new Phrase(": LJCPCBLCX11000237", Fonts.NORMAL));
        t3.addCell(new Phrase("Year", Fonts.NORMAL));
        t3.addCell(new Phrase(": 2004", Fonts.NORMAL));
        t3.addCell(new Phrase("Purpose of Usage", Fonts.NORMAL));
        t3.addCell(new Phrase(": Espionage", Fonts.NORMAL));
        t3.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(242) - tableHeight, canvas);
        tableHeight = tableHeight + t3.getTotalHeight();

		/* Sum Insured */
        PdfPTable t4 = new PdfPTable(2);
        t4.getDefaultCell().setBorder(Rectangle.TOP);
        t4.getDefaultCell().setLeading(0f, 1.3f);
        t4.getDefaultCell().setPaddingTop(0);
        t4.getDefaultCell().setPaddingBottom(5);
        t4.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t4.addCell(new Phrase("Value Insured", Fonts.NORMAL));
        t4.addCell(new Phrase(""));
        t4.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t4.addCell(new Phrase("Casco", Fonts.NORMAL));
        t4.addCell(new Phrase(": EUR 10,000.00", Fonts.NORMAL));
        t4.addCell(new Phrase("Sunroof", Fonts.NORMAL));
        t4.addCell(new Phrase(": EUR 3,000.00", Fonts.NORMAL));
        t4.addCell(new Phrase("Total Sum Insured", Fonts.NORMAL));
        t4.addCell(new Phrase(": EUR " + String.format("%1$,.2f", totalInsured), Fonts.NORMAL));
        t4.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t4.getTotalHeight();
		
		/* Type of Coverage & Premium Rate */
        PdfPTable t5 = new PdfPTable(2);
        t5.getDefaultCell().setBorder(Rectangle.TOP);
        t5.getDefaultCell().setLeading(0f, 1.3f);
        t5.getDefaultCell().setPaddingTop(0);
        t5.getDefaultCell().setPaddingBottom(5);
        t5.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t5.addCell(new Phrase("Type of Coverage", Fonts.NORMAL));
        t5.addCell(new Phrase(": Comprehensive + Flood + Riot", Fonts.NORMAL));
        t5.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t5.addCell(new Phrase("Premium Rate", Fonts.NORMAL));
        t5.addCell(new Phrase(": " + String.format("%1$,.3f", premiumRate * 100) + "%", Fonts.NORMAL));
        t5.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t5.getTotalHeight();
        
		/* Cost Details */
        PdfPTable t6 = new PdfPTable(2);
        t6.getDefaultCell().setBorder(Rectangle.TOP);
        t6.getDefaultCell().setLeading(0f, 1.3f);
        t6.getDefaultCell().setPaddingTop(0);
        t6.getDefaultCell().setPaddingBottom(5);
        t6.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
        t6.addCell(new Phrase("Deductible", Fonts.NORMAL));
        t6.addCell(new Phrase(": - Comprehensive EUR 15", Fonts.NORMAL));
        t6.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t6.addCell(new Phrase(""));
        t6.addCell(new Phrase("  - Flood 3.750% of Claim, minimum EUR 20", Fonts.NORMAL));
        t6.addCell(new Phrase(""));
        t6.addCell(new Phrase("  - Riot 5.000% of Claim, minimum EUR 30", Fonts.NORMAL));
        t6.addCell(new Phrase("Premium Details", Fonts.NORMAL));
        t6.addCell(new Phrase(""));
        t6.addCell(new Phrase("Basic Premium", Fonts.NORMAL));
        t6.addCell(new Phrase(": EUR " + String.format("%1$,.2f", premiumBasic), Fonts.NORMAL));
        t6.addCell(new Phrase("Policy Fee", Fonts.NORMAL));
        t6.addCell(new Phrase(": EUR " + String.format("%1$,.2f", policyFee), Fonts.NORMAL));
        t6.getDefaultCell().setBorder(Rectangle.BOTTOM);      
        t6.addCell(new Phrase("Total Premium", Fonts.NORMAL));
        t6.addCell(new Phrase(": EUR " + String.format("%1$,.2f", premiumTotal), Fonts.NORMAL));
        t6.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t6.getTotalHeight();
        
        /* Date and Signature */
        PdfPTable tlast = new PdfPTable(1);
        tlast.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        tlast.getDefaultCell().setLeading(0f, 1.3f);
        tlast.getDefaultCell().setPadding
        (0);
        tlast.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tlast.setTotalWidth(Utilities.millimetersToPoints(80));
        tlast.addCell(new Phrase("Muenster, 23 September 2013", Fonts.NORMAL));
        tlast.addCell(new Phrase("Capitol for People Inc.", Fonts.NORMAL));
        tlast.writeSelectedRows(0, -1, Utilities.millimetersToPoints(110), (Utilities.millimetersToPoints(50) + tlast.getTotalHeight()), canvas);
        Image siggy = Image.getInstance("logo.jpg");
        siggy.scaleToFit(Utilities.millimetersToPoints(40), Utilities.millimetersToPoints(25));
        siggy.setAbsolutePosition(Utilities.millimetersToPoints(130), Utilities.millimetersToPoints(20));
        document.add(siggy);

        document.close();
	}
	
	public static void main(String[] args) {
		try {
			CapitolContract capitolContract=new CapitolContract();
			//System.out.println(capitolContract.outputStream.toString());
			FileOutputStream output= new FileOutputStream("Capitol.pdf");
			output.write(capitolContract.outputStream.toByteArray());			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/* Helper methods to fill in information block - Not Used Yet */
	
	public void fillInfoBlock(PdfPTable table, String[] info, int alignment) {
    	table.getDefaultCell().setPadding(0);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setLeading(0f, 1.3f);
        switch (alignment) {
    	case 1:
    		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
    		break;	        	
    	case 2:
    		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    		break;
    	case 3:	
    		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
    		break;
    }        
        for(int i = 0; i < info.length; i++){
	        table.addCell(new Phrase(info[i], Fonts.NORMAL));
        }
    }

}
