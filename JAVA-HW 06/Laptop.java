public class Laptop {
    private String Name;
    private Integer RAM;
    private Integer SSD;
    private String OS;
    private String Color;
            
    public Laptop(String Name, Integer RAM, Integer SSD, String OS, String Color){
        this.Name = Name;
        this.RAM = RAM;
        this.SSD  = SSD ;
        this.OS = OS;
        this.Color = Color;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public Integer getRAM() {
        return RAM ;
    }
    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }
    public Integer getSSD() {
        return SSD;
    }
    public void setSSD (Integer SSD) {
        this.SSD = SSD;
    }
    public String getOS() {
        return OS;
    }
    public void setOS(String OS) {
        this.OS = OS;
    }
    public String getColor() {
        return Color;
    }
    public void setColor(String Color) {
        this.Color = Color;
    }

    }