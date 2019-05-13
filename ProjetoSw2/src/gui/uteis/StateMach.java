package gui.uteis;

import gui.formasGeometricas.MouseSelect;

public class StateMach {



    private String selectedTool;
    private String selectedSubTool;


    public StateMach() {
        selectedTool = MouseSelect.NOME;
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
