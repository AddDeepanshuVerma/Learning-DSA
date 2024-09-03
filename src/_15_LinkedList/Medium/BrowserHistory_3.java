package _15_LinkedList.Medium;

class BrowserHistory_3 {
    website curr;

    static class website {
        String name;
        website prev;
        website next;

        public website(String val, website prev, website next) {
            this.name = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public BrowserHistory_3(String homepage) {
        curr = new website(homepage, null, null);
    }

    public void visit(String url) {
        if (curr.next != null) curr.next.prev = null;
        curr.next = new website(url, curr, null);
        curr = curr.next;
    }

    public String back(int steps) {
        while (steps-- > 0 && curr.prev != null) curr = curr.prev;
        return curr.name;
    }

    public String forward(int steps) {
        while (steps-- > 0 && curr.next != null) curr = curr.next;
        return curr.name;
    }
}