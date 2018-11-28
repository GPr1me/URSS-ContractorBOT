package urss.contractorbot.Model;

public class BLE_Device {

    private String name;
    private String address;

    public BLE_Device(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }

    public String getAddress(){ return address; }
}
