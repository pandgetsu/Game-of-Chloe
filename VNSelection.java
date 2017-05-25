
/**
 * VNSelection inherits the original set of name and dialogue, but also includes two more dialogue
 * strings. Each dialogue string has a response string that goes with it
 * 
 * Class is intended for when the player has 3 dialogue options to pick from, and a response
 * is returned depending on each option
 * 
 * @Francis Nguyen 
 */
public class VNSelection extends VNDialogue
{
    private String dialogue2, dialogue3;
    private String response1, response2, response3;

    /**
     * Default constructor that sets all the String variables to empty strings
     */
    public VNSelection()
    {
        super();
        dialogue2 = "";
        dialogue3 = "";
        response1 = "";
        response2 = "";
        response3 = "";
    }
    /**
     * Constructor that has parameters for the name, each dialogue option and each response
     */
    public VNSelection(String cName, String diag1, 
        String diag2, String diag3, String res1, String res2, String res3)
    {
        super(cName, diag1);
        dialogue2 = diag2;
        dialogue3 = diag3;
        response1 = res1;
        response2 = res2;
        response3 = res3;
    }
    /**
     * Sets the second dialogue option
     */
    public void setDiag2(String diag)
    {
        dialogue2 = diag;
    }
    /**
     * Sets the third dialogue option
     */
    public void setDiag3(String diag)
    {
        dialogue3 = diag;
    }
    /**
     * Sets the first dialogue response
     */
    public void setResponse1(String res)   
    {   
        response1 = res;
    }
    /**
     * Sets the second dialogue response
     */
    public void setResponse2(String res)   
    {   
        response2 = res;
    }
    /**
     * Sets the third dialogue response
     */
    public void setResponse3(String res)   
    {   
        response3 = res;
    }
    /**
     * Returns the second dialogue option
     */
    public String getDiag2()
    {
        return dialogue2;
    }
    /**
     * Returns the third dialogue option
     */
    public String getDiag3()
    {
        return dialogue3;
    }
    /**
     * Returns the first dialogue response
     */
    public String getResponse1()
    {
        return response1;
    }
    /**
     * Returns the second dialogue response
     */
    public String getResponse2()
    {
        return response2;
    }
    /**
     * Returns the third dialogue response
     */
    public String getResponse3()
    {
        return response3;
    }
    /**
     * Indicates that the VNSelection IS a selection dialogue scenario
     * 
     * See the superclass VNDialogue for a nonselection dialogue scenario
     */
    public boolean isSelection()
    {
        return true;
    }
}
