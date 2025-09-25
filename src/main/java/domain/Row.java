package domain;

import game.Direction;
import game.LineNumber;
import util.NaturalNumber;

public class Row {
    private Node[] nodes;

    public Row(NaturalNumber numberOfPerson){
        nodes = new Node[numberOfPerson.getNumber()];
        for(int i = 0; i < numberOfPerson.getNumber(); i++){
            nodes[i] = Node.from(Direction.NONE);
        }
    }

    public boolean createRightBridge(int c){
        if(nodes[c].isAlreadySetDirection()){
            return false;
        }

        if(nodes[c+1].isAlreadySetDirection()){
            return false;
        }
        nodes[c].setRightNode();
        nodes[c+1].setLeftNode();
        return true;
    }

    public boolean isNodeLeft(int c){
        return nodes[c].isLeft();
    }

    public  boolean isNodeRight(int c){
        return nodes[c].isRight();
    }

    public void printRow(){
        for (Node node : nodes) {
            node.printNode();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void createLeftBridge(int c) {
        if(nodes[c].isAlreadySetDirection()){
            return;
        }

        if(nodes[c-1].isAlreadySetDirection()){
            return;
        }
        nodes[c].setLeftNode();
        nodes[c-1].setRightNode();
    }

    public void run(LineNumber position) {
        if(nodes[position.getNumber()].isLeft()){
            position.goLeft();
            return;
        }

        if(nodes[position.getNumber()].isRight()){
            position.goRight();
            return;
        }
    }


    public void printStar(LineNumber position) {
        for(int i=0; i<nodes.length; i++){
            if(i == position.getNumber()){
                nodes[i].printNode();
                System.out.print("* ");
                continue;
            }
            nodes[i].printNode();
            System.out.print(" ");
        }
        System.out.println();
    }
}
