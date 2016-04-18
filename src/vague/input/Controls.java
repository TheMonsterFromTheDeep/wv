package vague.input;

import java.awt.event.KeyEvent;

/**
 * Stores the statuses of all the different controls used in the application.
 * @author TheMonsterFromTheDeep
 */
public class Controls {
    public static final int WORKSPACE_GRID_SNAP = 0;
    public static final int WORKSPACE_SQUARE_TOOL = 1;
    public static final int WORKSPACE_TAKE_SCREENSHOT = 2;
    public static final int WORKSPACE_SAVE_IMAGE = 3;
    public static final int WORKSPACE_SAVE_AS = 4;
    public static final int EDITOR_MODIFIER_PAN_VERT = 5;
    public static final int EDITOR_MODIFIER_PAN_HORZ = 6;
    public static final int EDITOR_RESET_ZOOM = 7;
    public static final int EDITOR_RESET_PAN = 8;
    public static final int EDITOR_RESET_ZOOM_AND_PAN = 9;
    public static final int EDITOR_TOGGLE_GRID = 10;
    public static final int PENCIL_DRAW_LINE = 11;
    public static final int PENCIL_INVERT_COLORS = 12;
    public static final int TEST_COLOR = 900; //A test control for changing drawing color using the Pencil tool
    
    //Initializes the default state of the controls of the application
    public static final Chord[] DEFAULT = new Chord[] {
        new Chord(WORKSPACE_GRID_SNAP,new Control(KeyEvent.VK_CONTROL)),
        new Chord(WORKSPACE_SQUARE_TOOL,new Control(KeyEvent.VK_SHIFT)),
        new Chord(WORKSPACE_TAKE_SCREENSHOT,new Control[] { new Control(KeyEvent.VK_S), new Control(KeyEvent.VK_ALT), new Control(KeyEvent.VK_SHIFT)}),
        new Chord(WORKSPACE_SAVE_IMAGE,new Control(KeyEvent.VK_S), Chord.MODIFIER_CONTROL),
        new Chord(WORKSPACE_SAVE_AS,new Control(KeyEvent.VK_S), Chord.MODIFIER_SHIFT),
        new Chord(EDITOR_MODIFIER_PAN_VERT,new Control(KeyEvent.VK_CONTROL)),
        new Chord(EDITOR_MODIFIER_PAN_HORZ,new Control(KeyEvent.VK_SHIFT)),
        new Chord(EDITOR_RESET_ZOOM,new Control(KeyEvent.VK_8),Chord.MODIFIER_SHIFT),
        new Chord(EDITOR_RESET_PAN,new Control(KeyEvent.VK_8),Chord.MODIFIER_CONTROL),
        new Chord(EDITOR_RESET_ZOOM_AND_PAN,new Control(KeyEvent.VK_8),Chord.MODIFIER_SHIFT_AND_CONTROL),
        new Chord(EDITOR_TOGGLE_GRID,new Control(KeyEvent.VK_S),Chord.MODIFIER_SHIFT),
        new Chord(PENCIL_DRAW_LINE,new Control(KeyEvent.VK_SHIFT)),
        new Chord(PENCIL_INVERT_COLORS,new Control(KeyEvent.VK_CONTROL)),
        new Chord(TEST_COLOR,new Control(KeyEvent.VK_R))
    };
    
    public static Controls bank; //The static access controls object from which other objects access the state of controls
    
    //Stores the controls of the controls object
    private Chord[] controls;
    
    public boolean LMBDown;
    public boolean RMBDown;
    public boolean MMBDown;
    
    //Creates a Controls object based on the array of 'Control's to use
    public Controls(Chord[] controls) {
        this.controls = controls;
    }
    
    //Returns the status of the Control with the specified ID
    public boolean status(int id) {
        for (Chord c : controls) { //Loop through controls; if the id matches the one to find, return its status
            if(c.id == id) {
                return c.status;
            }
        }
        return false; //If the id wasn't found, return false by default (this should never happen)
    }
    
    public void update(int code, boolean status) {
        for (Chord c : controls) { //Loop through controls and update all the ones with the specified key code
            //Does not update by id because this method is called by a Key Event which does not know the ids
            //it simply updates any Controls that may exist with the specified key code
            c.update(code,status);
        }
    }
}