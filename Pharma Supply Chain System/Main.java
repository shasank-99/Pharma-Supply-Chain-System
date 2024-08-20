import java.util.HashMap;
import java.util.Map;

class Drug {
    private String drugId;
    private String name;
    private String manufacturer;
    private String batchNumber;
    private String manufactureDate;
    private String expiryDate;
    private String location;
    private boolean isSold;

    public Drug(String drugId, String name, String manufacturer, String batchNumber, String manufactureDate, String expiryDate) {
        this.drugId = drugId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.batchNumber = batchNumber;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.location = "Manufacturing Facility";
        this.isSold = false;
    }

    public String getDrugId() {
        return drugId;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean isSold) {
        this.isSold = isSold;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId='" + drugId + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", location='" + location + '\'' +
                ", isSold=" + isSold +
                '}';
    }
}

class PharmaSupplyChain {
    private Map<String, Drug> drugLedger = new HashMap<>();

    public void addDrug(String drugId, String name, String manufacturer, String batchNumber, String manufactureDate, String expiryDate) {
        Drug drug = new Drug(drugId, name, manufacturer, batchNumber, manufactureDate, expiryDate);
        drugLedger.put(drugId, drug);
        System.out.println("Drug added: " + drug);
    }

    public Drug queryDrug(String drugId) {
        return drugLedger.get(drugId);
    }

    public void updateDrugLocation(String drugId, String newLocation) {
        Drug drug = drugLedger.get(drugId);
        if (drug != null) {
            drug.setLocation(newLocation);
            System.out.println("Updated location for drug " + drugId + " to " + newLocation);
        } else {
            System.out.println("Drug not found!");
        }
    }

    public void markDrugAsSold(String drugId) {
        Drug drug = drugLedger.get(drugId);
        if (drug != null) {
            drug.setSold(true);
            System.out.println("Drug " + drugId + " marked as sold.");
        } else {
            System.out.println("Drug not found!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PharmaSupplyChain pharmaSupplyChain = new PharmaSupplyChain();

   
        pharmaSupplyChain.addDrug("DRUG001", "Aspirin", "PharmaInc", "BATCH001", "2024-01-01", "2025-01-01");

        
        Drug drug = pharmaSupplyChain.queryDrug("DRUG001");
        System.out.println("Query Result: " + drug);

        
        pharmaSupplyChain.updateDrugLocation("DRUG001", "Distribution Center");

        
        pharmaSupplyChain.markDrugAsSold("DRUG001");

        
        drug = pharmaSupplyChain.queryDrug("DRUG001");
        System.out.println("Query Result after update: " + drug);
    }
}
