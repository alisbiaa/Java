package Board;

import java.util.ArrayList;
import java.util.Arrays;


public class board {
    private String[] inputFields;
    private final ArrayList<Object> listOfFields = new ArrayList<>() ;

    public board(String[] fields){
        this.inputFields = fields  ;
        createFields();
    }

    private void createFields(){
        for (String str : inputFields) {
            String[] field = str.split(" ") ;
            switch (field[0]) {
                case "p" : listOfFields.add(new property(listOfFields.size()) )   ; break ;
                case "l" : listOfFields.add(new lucky(listOfFields.size(), Integer.parseInt(field[1]) )  ); break ;
                case "s" : listOfFields.add(new service(listOfFields.size(), Integer.parseInt(field[1]) )) ; break ;
            }
        }
    }

    public ArrayList<Object> getListOfFields() {
        return listOfFields;
    }
}
