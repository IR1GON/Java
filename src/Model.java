class Model {
    private String labelText;

    public Model() {
        this.labelText = "Початковий текст";
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String newText) {
        this.labelText = newText;
    }
}