public abstract class QuestItem extends Item {
    private String quest;

    protected QuestItem() {
        super();
        this.quest = "Null";
    }
    protected QuestItem(String quest) {
        super();
        this.quest = quest;
    }


    protected void setEnd(String quest) {
        this.quest = quest;
    }
    protected String ending() {
        return this.quest;
    }

}
