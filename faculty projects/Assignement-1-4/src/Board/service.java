package Board;

public class service {
    private int penalty ;
    private int fieldPosition ;

    public service(int fieldPosition ,int penalty) {
        this.fieldPosition = fieldPosition ;
        this.penalty = penalty ;
    }

    public int getPenalty() {
        return penalty;
    }


}
