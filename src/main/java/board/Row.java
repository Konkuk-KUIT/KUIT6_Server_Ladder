package board;

import exceptions.DuplicateLineException;
import exceptions.ErrorMessage;
import wrap.NodeIndex;
import wrap.PersonCount;

public class Row {
    
    private final Node[] nodes;
    private final int rowIndex;
    private final PersonCount personCount;
    
    public Row(PersonCount personCount, int rowIndex) {
        this.personCount = personCount;
        this.nodes = new Node[personCount.getMaxLineIndex()];
        this.rowIndex = rowIndex;
        initializeNodes();
    }
    
    private void initializeNodes() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
    }
    
    public void connectNode(NodeIndex nodeIndex) {
        validateNodeIndex(nodeIndex);
        validateNoDuplicateConnection(nodeIndex);
        nodes[nodeIndex.value()].connect();
    }
    
    public boolean hasConnection(NodeIndex nodeIndex) {
        if (nodeIndex.isValidFor(personCount)) {
            return false;
        }
        return nodes[nodeIndex.value()].isConnected();
    }
    
    private void validateNodeIndex(NodeIndex nodeIndex) {
        if (nodeIndex.isValidFor(personCount)) {
            throw new IllegalArgumentException("Invalid node index: " + nodeIndex.value());
        }
    }
    
    private void validateNoDuplicateConnection(NodeIndex nodeIndex) {
        if (hasConnection(nodeIndex)) {
            throw new DuplicateLineException(ErrorMessage.DUPLICATE_LINE.format(rowIndex, nodeIndex.value()));
        }
    }
    
    public int getNodeCount() {
        return nodes.length;
    }
}