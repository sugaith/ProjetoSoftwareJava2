package gui.uteis;

import gui.formasGeometricas.MouseSelect;

public class StateMach {
    public static String NONE = "NONE";
    public static String ROTATE = "Rotação";
    public static String TRANSLATE  = "Translação";



    //TOOLS
    private String selectedTool;
    private String selectedSubTool;


    public StateMach() {

        selectedTool = MouseSelect.NOME;
        selectedSubTool = NONE;
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
