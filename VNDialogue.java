
/**
 * Class VNDialogue contains 2 strings values, one that contains the name of the person speaking
 * and one that contains the dialogue itself
 * 
 * Includes methods to both change and return these two strings
 * 
 * @Francis Nguyen 
 */
public class VNDialogue
{
    protected String charName;
    protected String dialogue;

    /**
     * Default Constructor with no arguments. Sets both charName and dialogue as empty strings
     */
    public VNDialogue()
    {
        charName = "";
        dialogue = "";
    }
    /**
     * Constructore which includes arguments to set cName and dialogue
     */
    public VNDialogue(String cName, String diag)
    {
        charName = cName;
        dialogue = diag;
    }
    /**
     * Sets the content of the String charName
     */
    public void setName(String cName)
    {
        charName = cName;
    }
    /**
     * Sets the content of the String dialogue
     */
    public void setDiag(String diag)
    {
        dialogue = diag;
    }
    /**
     * Returns the content of the String charName
     */
    public String getName()
    {
        return charName;
    }
    /**
     * Returns the content of the String dialogue
     */
    public String getDiag()
    {
        return dialogue;
    }
    /**
     * Indicates that the VNDialogue is NOT a selection dialogue scenario
     * 
     * See subclass VNSelection for a selection dialogue scenario
     */
    public boolean isSelection()
    {
        return false;
    }
}
