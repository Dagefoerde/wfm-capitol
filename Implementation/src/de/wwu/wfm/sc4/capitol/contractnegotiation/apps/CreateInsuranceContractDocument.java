package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ContractData.ContractData;
import ContractData.InsuranceContract;
import DTO.DataTransferObject;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import de.wwu.wfm.sc4.capitol.constants.CapitolConstants;
import de.wwu.wfm.sc4.capitol.contractnegotiation.Fonts;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Contract;

public class CreateInsuranceContractDocument {
	
	private Case contractingCase;
	
	private Contract contract;
	
	private DataTransferObject dto;
	
	public CreateInsuranceContractDocument() {

	}

	public void setCase(Case contractingCase) {
		this.contractingCase=contractingCase;
	}

	public void setContract(Contract contract) {
		this.contract=contract;
	}
	public void setDataTransferObject(DataTransferObject dto) {
		this.dto=dto;
	}

	public void complete() {		
		ByteArrayOutputStream byteArrayOutputStream;
		/* Basic document attributes */
		byteArrayOutputStream= new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4, Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(25), Utilities.millimetersToPoints(25));
		//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Capitol Contract.pdf"));
		PdfWriter writer;
		PdfContentByte canvas=null;
		try {
			writer = PdfWriter.getInstance(document, byteArrayOutputStream);
		
		document.open();
		canvas = writer.getDirectContent();
		} catch (DocumentException e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		
		float tableHeight;
		
		/* Header - Logo and document title*/
		Image img;
		try {
			img = Image.getInstance("Settings/Capitol.png");
		
        img.scaleToFit(Utilities.millimetersToPoints(25),Utilities.millimetersToPoints(25));
        img.setAbsolutePosition(Utilities.millimetersToPoints(175), Utilities.millimetersToPoints(262));
        document.add(img);
		} catch (BadElementException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		} catch (MalformedURLException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		} catch (IOException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Paragraph header = new Paragraph(Chunk.NEWLINE);
        header.setAlignment(Element.ALIGN_CENTER);
        header.add(Chunk.NEWLINE);
        header.add(Chunk.NEWLINE);
        header.add(new Phrase("MOTOR VEHICLE INSURANCE CONTRACT", Fonts.TITLE));
        try {
			document.add(header);
		} catch (DocumentException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		}
        
        /* Insurance Number */
        PdfPTable t0 = new PdfPTable(2);
        t0.getDefaultCell().setBorder(Rectangle.TOP);
        t0.getDefaultCell().setLeading(0f, 1.3f);
        t0.getDefaultCell().setPaddingTop(0);
        t0.getDefaultCell().setPaddingBottom(5);
        try {
			t0.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
		} catch (DocumentException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}
        t0.addCell(new Phrase("Insurance Nr.", Fonts.NORMAL));
        t0.addCell(new Phrase(": " + contractingCase.getId(), Fonts.NORMAL));
        t0.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(242), canvas);
        tableHeight = t0.getTotalHeight();
        
		/* Policy holder */
        PdfPTable t1 = new PdfPTable(2);
        t1.getDefaultCell().setBorder(Rectangle.TOP);
        t1.getDefaultCell().setLeading(0f, 1.3f);
        t1.getDefaultCell().setPaddingTop(0);
        t1.getDefaultCell().setPaddingBottom(5);
        try {
			t1.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
		} catch (DocumentException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}
        t1.addCell(new Phrase("Insured", Fonts.NORMAL));
        t1.addCell(new Phrase(": "+contractingCase.getCustomer().getFirstname()+" "+contractingCase.getCustomer().getLastname(), Fonts.NORMAL));
        t1.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t1.addCell(new Phrase("Address", Fonts.NORMAL));
        t1.addCell(new Phrase(": "+contractingCase.getCustomer().getStreet()+" "+contractingCase.getCustomer().getStreetNumber()+", "+contractingCase.getCustomer().getPostalCode() + " " + contractingCase.getCustomer().getCity(), Fonts.NORMAL));
        t1.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t1.getTotalHeight();

		/* Insurance Period */
        PdfPTable t2 = new PdfPTable(2);
        t2.getDefaultCell().setBorder(Rectangle.TOP);
        t2.getDefaultCell().setLeading(0f, 1.3f);
        t2.getDefaultCell().setPaddingTop(0);
        t2.getDefaultCell().setPaddingBottom(5);
        try {
			t2.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
		} catch (DocumentException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
        t2.addCell(new Phrase("Period of Insurance", Fonts.NORMAL));
		SimpleDateFormat dfForStartDate=new SimpleDateFormat("yyyy/MM/DD");

        t2.addCell(new Phrase(": From "+dfForStartDate.format(contract.getStartDate())+ " to " + dfForStartDate.format(contract.getEndDate()),Fonts.NORMAL));
        t2.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t2.getTotalHeight();

        /* Title Insured Vehicle */
        PdfPTable t31 = new PdfPTable(1);
        t31.getDefaultCell().setBorder(Rectangle.TOP);
        t31.getDefaultCell().setLeading(0f, 1.3f);
        t31.getDefaultCell().setPaddingTop(0);
        t31.getDefaultCell().setPaddingBottom(5);
        try {
			t31.setTotalWidth(new float[] {Utilities.millimetersToPoints(170)});
		} catch (DocumentException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
        t31.addCell(new Phrase(" ", Fonts.NORMAL));
        t31.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t31.addCell(new Phrase("Insured Vehicle Details", Fonts.NORMAL));
        t31.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t31.getTotalHeight();
        
		/* Insured Vehicle */
        PdfPTable t3 = new PdfPTable(5);
        t3.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t3.getDefaultCell().setLeading(0f, 1.3f);
        t3.getDefaultCell().setPaddingTop(0);
        t3.getDefaultCell().setPaddingBottom(5);
        try {
			t3.setTotalWidth(new float[] {Utilities.millimetersToPoints(10),Utilities.millimetersToPoints(40),Utilities.millimetersToPoints(50),Utilities.millimetersToPoints(30), Utilities.millimetersToPoints(40)});
		} catch (DocumentException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
        t3.getDefaultCell().setBorder(Rectangle.BOX);
        t3.addCell(new Phrase(" ", Fonts.NORMAL));
        t3.addCell(new Phrase("Name of Vehicle", Fonts.NORMAL));
        t3.addCell(new Phrase("License Plate Number", Fonts.NORMAL));
        t3.addCell(new Phrase("Color", Fonts.NORMAL));
        t3.addCell(new Phrase("Price at purchase", Fonts.NORMAL));
        int index=1;
        for (Car car:contract.getCars()){
        t3.addCell(new Phrase((index++)+"", Fonts.NORMAL));
        t3.addCell(new Phrase(car.getType(), Fonts.NORMAL));
        t3.addCell(new Phrase(car.getLicencePlate(), Fonts.NORMAL));
        t3.addCell(new Phrase(car.getColor(), Fonts.NORMAL));
        t3.addCell(new Phrase("EUR "+ String.format("%1$,.2f", car.getBuyingPrice()), Fonts.NORMAL));}
        //TODO: Not yet supported by datastructure
        //t3.addCell(new Phrase("Vehicle Identification Number", Fonts.NORMAL));
        //t3.addCell(new Phrase(": LJCPCBLCX11000237", Fonts.NORMAL));
        //t3.addCell(new Phrase("Year", Fonts.NORMAL));
        //t3.addCell(new Phrase(": 2004", Fonts.NORMAL));
        //t3.addCell(new Phrase("Purpose of Usage", Fonts.NORMAL));
        //t3.addCell(new Phrase(": Espionage", Fonts.NORMAL));}
        t3.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), Utilities.millimetersToPoints(242) - tableHeight, canvas);
        tableHeight = tableHeight + t3.getTotalHeight();
        
        /* Title Insured Vehicle */
        PdfPTable t41 = new PdfPTable(1);
        t41.getDefaultCell().setBorder(Rectangle.TOP);
        t41.getDefaultCell().setLeading(0f, 1.3f);
        t41.getDefaultCell().setPaddingTop(0);
        t41.getDefaultCell().setPaddingBottom(5);
        try {
			t41.setTotalWidth(new float[] {Utilities.millimetersToPoints(170)});
		} catch (DocumentException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
        t41.addCell(new Phrase(" ", Fonts.NORMAL));
        t41.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t41.addCell(new Phrase("Insured Value Details", Fonts.NORMAL));
        t41.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t41.getTotalHeight();
        
		/* Sum Insured */
        PdfPTable t4 = new PdfPTable(2);
        t4.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        t4.getDefaultCell().setLeading(0f, 1.3f);
        t4.getDefaultCell().setPaddingTop(0);
        t4.getDefaultCell().setPaddingBottom(5);
        try {
			t4.setTotalWidth(new float[] {Utilities.millimetersToPoints(70), Utilities.millimetersToPoints(100)});
		} catch (DocumentException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        t4.getDefaultCell().setBorder(Rectangle.BOX);
        t4.addCell(new Phrase("Natural causes covered", Fonts.NORMAL));
        t4.addCell(new Phrase("EUR " + String.format("%1$,.2f", contract.getNaturalInsured()), Fonts.NORMAL));
        t4.addCell(new Phrase("Pickup service covered", Fonts.NORMAL));
        t4.addCell(new Phrase(""+(contract.getPickupService()?"Yes":"No"), Fonts.NORMAL));
        t4.addCell(new Phrase("Human damage insured", Fonts.NORMAL));
        t4.addCell(new Phrase("EUR " + String.format("%1$,.2f", contract.getHumanInsured()), Fonts.NORMAL));
        t4.addCell(new Phrase("Total damage insured", Fonts.NORMAL));
        t4.addCell(new Phrase("EUR " + String.format("%1$,.2f", contract.getHumanInsured()+contract.getNaturalInsured()), Fonts.NORMAL));      
        t4.writeSelectedRows(0, -1, Utilities.millimetersToPoints(20), (Utilities.millimetersToPoints(242) - tableHeight), canvas);
        tableHeight = tableHeight + t4.getTotalHeight();
		
		/* Type of Coverage & Premium Rate 
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
        tableHeight = tableHeight + t5.getTotalHeight();*/
        
		/* Cost Details 
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
        tableHeight = tableHeight + t6.getTotalHeight();*/
        
        /* Date and Signature */
        PdfPTable tlast = new PdfPTable(1);
        tlast.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        tlast.getDefaultCell().setLeading(0f, 1.3f);
        tlast.getDefaultCell().setPadding(0);
        tlast.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tlast.setTotalWidth(Utilities.millimetersToPoints(80));
        tlast.addCell(new Phrase("Muenster, "+new Date(), Fonts.NORMAL));
        tlast.addCell(new Phrase("Capitol for People Inc.", Fonts.NORMAL));
        tlast.writeSelectedRows(0, -1, Utilities.millimetersToPoints(110), (Utilities.millimetersToPoints(50) + tlast.getTotalHeight()), canvas);
        Image siggy=null;
		try {
			siggy = Image.getInstance(CapitolConstants.SETTINGS_PATH+"/logo.jpg");
		
        siggy.scaleToFit(Utilities.millimetersToPoints(40), Utilities.millimetersToPoints(25));
        siggy.setAbsolutePosition(Utilities.millimetersToPoints(130), Utilities.millimetersToPoints(20));
			document.add(siggy);
        } catch (BadElementException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        document.close();
        ByteArrayOutputStream byteArrayOutputStreamConcat=new ByteArrayOutputStream();
        try{
        Document document2=new Document();
        
        PdfCopy copy= new PdfCopy(document2,byteArrayOutputStreamConcat);
        document2.open();
        PdfReader reader=new PdfReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Integer n = reader.getNumberOfPages();
        for (int page = 0; page < n; ) {
            copy.addPage(copy.getImportedPage(reader, ++page));
        }
        copy.freeReader(reader);
        reader.close();
        reader=new PdfReader(CapitolConstants.SETTINGS_PATH+"/LegalContractingPart.pdf");
        n = reader.getNumberOfPages();
       for (int page = 0; page < n; ) {
           copy.addPage(copy.getImportedPage(reader, ++page));
       }
        copy.freeReader(reader);
        reader.close();
        document2.close();}
        catch (Exception e){e.printStackTrace();}
        ContractData cd=dto.getContractData();
        InsuranceContract insuranceContract=new InsuranceContract();
        insuranceContract.setContractCapitol(byteArrayOutputStreamConcat.toByteArray());
        cd.setInsuranceContract(insuranceContract);
        //write pdf to file
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMDD");
        String path=CapitolConstants.PRELIMINARY_CONTRACTS_PATH+"/Contract-"+contractingCase.getId()+"-"+contractingCase.getCustomer().getLastname()+"-"+contractingCase.getContract().size()+"-"+df.format(new Date())+".pdf";
        contract.setPath(path);
        try {
            FileOutputStream output=new FileOutputStream(path);
			output.write(byteArrayOutputStreamConcat.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DataTransferObject getDataTransferObject() {
		return dto;
	}
}
