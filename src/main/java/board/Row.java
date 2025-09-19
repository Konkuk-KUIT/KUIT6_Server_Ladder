package board;

import exceptions.DuplicateLineException;
import exceptions.ErrorMessage;

public class Row {
    
    private final Node[] nodes;
    private final int rowIndex;
    
    public Row(int nodeCount, int rowIndex) {
        this.nodes = new Node[nodeCount];
        this.rowIndex = rowIndex;
        initializeNodes();
    }
    
    private void initializeNodes() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
    }
    
    public void connectNode(int nodeIndex) {
        validateNodeIndex(nodeIndex);
        validateNoDuplicateConnection(nodeIndex);
        nodes[nodeIndex].connect();
    }
    
    public boolean hasConnection(int nodeIndex) {
        if (nodeIndex < 0 || nodeIndex >= nodes.length) {
            return false;
        }
        return nodes[nodeIndex].isConnected();
    }
    
    private void validateNodeIndex(int nodeIndex) {
        if (nodeIndex < 0 || nodeIndex >= nodes.length) {
            throw new IllegalArgumentException("Invalid node index: " + nodeIndex);
        }
    }
    
    private void validateNoDuplicateConnection(int nodeIndex) {
        if (hasConnection(nodeIndex)) {
            throw new DuplicateLineException(ErrorMessage.DUPLICATE_LINE.format(rowIndex, nodeIndex));
        }
    }
    
    public int getNodeCount() {
        return nodes.length;
    }
}