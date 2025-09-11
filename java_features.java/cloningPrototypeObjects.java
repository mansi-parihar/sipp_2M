class Document implements Cloneable {
    private String title;
    private String content;

    Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document [title=" + title + ", content=" + content + "]";
    }
}

public class cloningPrototypeObjects {
    public static void main(String[] args) {
        try {
            Document original = new Document("Report", "Quarterly financial analysis");

            Document copy = (Document) original.clone();

            copy.setTitle("Cloned Report");
            copy.setContent("This is a modified copy.");

            System.out.println("Original: " + original);
            System.out.println("Clone   : " + copy);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
