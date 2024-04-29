

 protected double weight; 
    protected double length; 
    protected double width; 
    protected double height; 
    protected boolean isFragile;

    public Shipment(double weight, double length, double width, double height, boolean isFragile) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.isFragile = isFragile;
    }

    public abstract double calculateCost();

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isFragile() {
        return isFragile;
    }
}


 class StandardPackage extends Shipm ent {
    public StandardPackage(double weight, double length, double width, double height, boolean isFragile) {
        super(weight, length, width, height, isFragile);
    }

    @Override
    public double calculateCost() {
        
        return weight * 0.5 + (length * width * height) * 0.1;
    }
}


 class UrgentDocument extends Shipment {
    public UrgentDocument(double weight, double length, double width, double height, boolean isFragile) {
        super(weight, length, width, height, isFragile);
    }

    @Override
    public double calculateCost() {
        
        return weight * 1.5 + 10.0; 
    }
}


 class FragileItem extends Shipment {
    public FragileItem(double weight, double length, double width, double height, boolean isFragile) {
        super(weight, length, width, height, isFragile);
    }

    @Override
    public double calculateCost() {
        
        return weight * 2.0 + (length * width * height) * 0.2 + (isFragile? 5.0 : 0.0);
    }
}


 class ShipmentCalculator {
    public static double calculateShipmentCost(Shipment shipment) {
        return shipment.calculateCost();
    }
}   


 class Main { 
    public static void main(String[] args) {
        
        Shipment standardPackage = new StandardPackage(2.0, 30, 20, 10, false);
        Shipment urgentDocument = new UrgentDocument(0.5, 20, 10, 5, false);
        Shipment fragileItem = new FragileItem(1.0, 40, 30, 20, true);

        
        double standardCost = ShipmentCalculator.calculateShipmentCost(standardPackage);
        double urgentCost = ShipmentCalculator.calculateShipmentCost(urgentDocument);
        double fragileCost = ShipmentCalculator.calculateShipmentCost(fragileItem);

        
        System.out.println("Standard Package Cost: " + standardCost);
        System.out.println("Urgent Document Cost: " + urgentCost);
        System.out.println("Fragile Item Cost: " + fragileCost);
    }
}