package board;

public class Node {
    
    private boolean connected;
    
    public Node() {
        this.connected = false;
    }
    
    public void connect() {
        this.connected = true;
    }
    
    public boolean isConnected() {
        return connected;
    }
}