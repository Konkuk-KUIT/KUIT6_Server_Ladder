package board;

import exceptions.DuplicateLineException;
import wrap.NodeIndex;
import wrap.PersonCount;

public class Row {
    
    private final Node[] nodes;
    private final PersonCount personCount;
    
    public Row(PersonCount personCount) {
        this.personCount = personCount;
        this.nodes = new Node[personCount.getMaxLineIndex()];
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
        nodes[nodeIndex.getValue()].connect();
    }
    
    public boolean hasConnection(NodeIndex nodeIndex) {
        if (nodeIndex.isValidFor(personCount)) {
            return false;
        }
        return nodes[nodeIndex.getValue()].isConnected();
    }
    
    private void validateNodeIndex(NodeIndex nodeIndex) {
        if (nodeIndex.isValidFor(personCount)) {
            throw new IllegalArgumentException("Invalid node index: " + nodeIndex.getValue());
        }
    }
    
    private void validateNoDuplicateConnection(NodeIndex nodeIndex) {
        if (hasConnection(nodeIndex)) {
            throw new DuplicateLineException(nodeIndex.getValue());
        }
    }
    
    public int getNodeCount() {
        return nodes.length;
    }
}