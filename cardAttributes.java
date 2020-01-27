public class cardAttributes {

    private String NameFirst;
    private String NameLast;
    private int Size;
    private int Duration;
    private int Population;
    private int Antiquity;
    private int CoolFactor;

    public cardAttributes(String NameFirst, String NameLast, int Size, int Duration, int Population, int Antiquity, int CoolFactor) {

        this.NameFirst = NameFirst;
        this.NameLast = NameLast;
        this.Size = Size;
        this.Duration = Duration;
        this.Population = Population;
        this.Antiquity = Antiquity;
        this.CoolFactor = CoolFactor;

    }
    
    public String getName() { return getNameFirst() + " " + getNameLast(); }

    public String getNameFirst() { return NameFirst; }

    public String getNameLast() { return NameLast; }

    public int getSize() { return Size; }

    public int getDuration() { return Duration; }

    public int getPopulation() { return Population; }

    public int getAntiquity() { return Antiquity; }

    public int getCoolFactor() { return CoolFactor; }


    public String toString() {
        return String.format("\nCivilization: %s %s \nGeographic Size: %d \nDuration: %d \nPopulation: %d \nAntiquity: %d \nCool Factor: %d",
                this.getNameFirst(), this.getNameLast(), this.getSize(), this.getDuration(), this.getPopulation(), this.getAntiquity(), this.getCoolFactor());

 }
    
    

}