/**
 * Template for all items that are involved in a quest.
 */
public abstract class QuestItem extends Item {
    //The quest that the item is involved with
    private String quest;

    /**
     * Default Constructor Creates a new Quest Item
     */
    protected QuestItem() {
        super();
        this.quest = "Null";
    }

    /**
     * Creates a new Quest Item
     * @param quest
     */
    protected QuestItem(String quest) {
        super();
        this.quest = quest;
    }


    
    /** 
     * Sets the quest (ending)
     * @param quest
     */
    protected void setEnd(String quest) {
        this.quest = quest;
    }
    /**
     * Returns the quest (ending) that the item is involved with.
     * @return String
     */
    protected String ending() {
        return this.quest;
    }

}
