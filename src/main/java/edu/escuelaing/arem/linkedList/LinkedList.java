/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.linkedList;

/**
 *
 * @author camilolopez
 */
public class LinkedList {

    private int countNodes;
    private Node nodeRoot, nodeToMove;

    public LinkedList() {
        countNodes = 0;        
    }

    /**
     *
     * @param infoNode
     */
    public void addNode(double infoNode) {
        Node nodeTemp = null;
        Node nodeToAdd = new Node(infoNode);
        if (countNodes == 0) {
            nodeToAdd.setPriorNode(null);
            nodeToAdd.setNextNode(null);
            nodeRoot = nodeToAdd;
            nodeToAdd.setIsRoot(true);
            nodeToMove = nodeRoot;
        } else {
            nodeTemp = nodeRoot;
            while (nodeTemp.getNextNode() != null) {
                nodeTemp = nodeTemp.getNextNode();
            }
            nodeTemp.setNextNode(nodeToAdd);
            nodeToAdd.setPriorNode(nodeTemp);
            nodeToAdd.setNextNode(null);
            nodeToAdd.setIsRoot(false);
        }
        countNodes++;        
    }

    /**
     *
     * @param nodeIndex
     */
    public void removeNode(int nodeIndex) {
        Node nodeTemp = nodeRoot;
        for(int x = 0; x <= nodeIndex; x++){
            nodeTemp = nodeTemp.getNextNode();
        }
        nodeTemp.getPriorNode().setNextNode(nodeTemp.getNextNode());
        nodeTemp.setNextNode(null);
        nodeTemp.setPriorNode(null);
    }
    
    public Node nextNode(){
        Node nodeToReturn;
        if(nodeToMove.isIsRoot()){
            nodeToReturn = nodeToMove;            
        }else{
            nodeToMove = nodeToMove.getNextNode();
            nodeToReturn = nodeToMove;
        }
        return nodeToReturn;
    }

    public int getCountNodes() {
        return countNodes;
    }

    public void setCountNodes(int countNodes) {
        this.countNodes = countNodes;
    }

    public Node getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(Node nodeRoot) {
        this.nodeRoot = nodeRoot;
    }
}
