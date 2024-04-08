package components;

import java.util.ArrayList;

public class GameManager {
    
    private ArrayList<DropZone> dropZones;
    private ArrayList<DraggableComponent> cards;


    public GameManager() {
        this.dropZones = new ArrayList<DropZone>();
        this.cards = new ArrayList<DraggableComponent>();
    }

    public void addDropZone(DropZone dropZone) {
        dropZones.add(dropZone);
    }

    public ArrayList<DropZone> getDropZones() {
        return dropZones;
    }
    

}
