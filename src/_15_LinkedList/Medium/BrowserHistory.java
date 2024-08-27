package _15_LinkedList.Medium;

import java.util.Stack;

class BrowserHistory {
    String visiting;
    Stack<String> back;
    Stack<String> frwd;

    public BrowserHistory(String homepage) {
        visiting = homepage;
        back = new Stack<>();
        frwd = new Stack<>();
    }
    
    public void visit(String url) {
        back.add(visiting);
        visiting = url;
        frwd.clear();
    }
    
    public String back(int steps) {
            while (steps > 0 && !back.isEmpty()) {
            frwd.add(visiting);
            visiting = back.pop();
            steps--;
        }
        return visiting;
    }
    
    public String forward(int steps) {
        while (steps > 0 && !frwd.isEmpty()) {
            back.add(visiting);
            visiting = frwd.pop();
            steps--;
        }
        return visiting;
    }
}