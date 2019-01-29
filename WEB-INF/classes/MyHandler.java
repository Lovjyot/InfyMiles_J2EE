import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {
private Map<String,Car> CarList = null;
    private Car ncar = null;
    public Map<String,Car> getCarList() {
        return CarList;
    }

    boolean bcarName = false;
    boolean bcarCategory = false;
    boolean bcarBrandName = false;
    boolean bcarMileage = false;
    boolean bcarModel = false;
    boolean bcarProductionYear = false;
    boolean bcarColor = false;
    boolean bcarImagePath = false;
	boolean bcarPrice = false;
	boolean bcarReservationStatus = false;
	boolean blocation = false;
    
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("Car")) {
            String id = attributes.getValue("id");
            ncar = new Car();
			ncar.setId(id);
            if (CarList == null)
                CarList = new HashMap<>();
            CarList.put(id, ncar);
        } else if (qName.equalsIgnoreCase("carCategory")) {
            bcarCategory = true;
			} else if (qName.equalsIgnoreCase("carBrandName")) {
            bcarBrandName = true;
        } else if (qName.equalsIgnoreCase("carName")) {
            bcarName = true;
        } else if (qName.equalsIgnoreCase("carMileage")) {
            bcarMileage = true;
        } else if (qName.equalsIgnoreCase("carModel")) {
            bcarModel = true;
        }
        else if (qName.equalsIgnoreCase("carProductionYear")) {
            bcarProductionYear = true;
        }
        else if (qName.equalsIgnoreCase("carColor")) {
            bcarColor = true;
        }
        else if (qName.equalsIgnoreCase("carImagePath")) {
            bcarImagePath = true;
        }else if (qName.equalsIgnoreCase("carPrice")) {
            bcarPrice = true;
        }else if (qName.equalsIgnoreCase("carReservationStatus")) {
            bcarReservationStatus = true;
        }else if (qName.equalsIgnoreCase("location")) {
            blocation = true;
        }
    }

    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Car")) {
        	int count=0;
        }
    }

   
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bcarMileage) {
            ncar.setcarMileage(new String(ch, start, length));
            bcarMileage = false;
        } else if (bcarBrandName) {
            ncar.setcarBrandName(new String(ch, start, length));
            bcarBrandName = false;
		} else if (bcarCategory) {
            ncar.setcarCategory(new String(ch, start, length));
            bcarCategory = false;
        } else if (bcarName) {
            ncar.setcarName(new String(ch, start, length));
            bcarName = false;
        } else if (bcarModel) {
            ncar.setcarModel(new String(ch, start, length));
            bcarModel = false;
        }
        else if (bcarProductionYear) {
            ncar.setcarProductionYear(new String(ch, start, length));
            bcarProductionYear = false;
        }
        else if (bcarColor) {
            ncar.setcarColor(new String(ch, start, length));
            bcarColor = false;
        }
        else if (bcarImagePath) {
            ncar.setcarImagePath(new String(ch, start, length));
            bcarImagePath = false;
        }
		else if (bcarPrice) {
            ncar.setcarPrice(new String(ch, start, length));
            bcarPrice = false;
        }
        else if (bcarReservationStatus) {
            ncar.setcarReservationStatus(new String(ch, start, length));
            bcarReservationStatus = false;
        }
		else if (blocation) {
            ncar.setLocation(new String(ch, start, length));
            blocation = false;
        }
    }
}