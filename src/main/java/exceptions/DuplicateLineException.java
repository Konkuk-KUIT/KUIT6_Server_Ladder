package exceptions;

public class DuplicateLineException extends RuntimeException {
    private final int nodeIndex;
    
    public DuplicateLineException(int nodeIndex) {
        super("Duplicate line at node index: " + nodeIndex);
        this.nodeIndex = nodeIndex;
    }
    
    public DuplicateLineException(String message) {
        super(message);
        this.nodeIndex = -1; // 완성된 메시지의 경우 nodeIndex는 필요없음
    }
    
    public int getNodeIndex() {
        return nodeIndex;
    }
}