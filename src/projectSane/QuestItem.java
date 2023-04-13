package projectSane;
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
     * Creates a new Quest Item with the specified quest.
     * @param quest The quest that the item is involved with.
     */
    protected QuestItem(String quest) {
        super();
        this.quest = quest;
    }


    
    /** 
     * Sets the quest (ending)
     * @param quest The quest that the item is involved with.
     */
    protected void setEnd(String quest) {
        this.quest = quest;
    }
    /**
     * Returns the quest (ending) that the item is involved with.
     * @return String The quest that the item is involved with.
     */
    protected String ending() {
        return this.quest;
    }

}
