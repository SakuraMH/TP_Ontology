package ma.enset.sma;

public class Computer extends Product {
    private float ram;
    private float disk;
    private int processors;

    public Computer() {
    }

    public float getRam() {
        return this.ram;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public float getDisk() {
        return this.disk;
    }

    public void setDisk(float disk) {
        this.disk = disk;
    }

    public int getProcessors() {
        return this.processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }
}

