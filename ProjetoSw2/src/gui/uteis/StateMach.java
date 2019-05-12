package gui.uteis;

public class StateMach {
    public static final String MOUSE_TOOL = "mouse";


    private String selectedTool;
    private String selectedSubTool;


    public StateMach() {
        selectedTool = MOUSE_TOOL;
    }


    public String getSelectedTool() {
        return selectedTool;
    }

    public void setSelectedTool(String selectedTool) {
        this.selectedTool = selectedTool;
    }

    public String getSelectedSubTool() {
        return selectedSubTool;
    }

    public void setSelectedSubTool(String selectedSubTool) {
        this.selectedSubTool = selectedSubTool;
    }
}
