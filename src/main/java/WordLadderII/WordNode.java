package WordLadderII;

class WordNode {
    String word;
    int numSteps;
    WordNode pre;
    public WordNode(String word, int numSteps, WordNode pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}

