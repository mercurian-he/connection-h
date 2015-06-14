package sxh.connection.function;

/**
 * Created by Eleanor on 2015/6/14.
 */
public enum FunctionNames {


    EditPersonalInfo(0, "edit_info"),
    ExchangeCard(1, "exchange_card"),
    DesignCard(2, "design_card"),
    ImportContact(3, "import_contact"),
    SearchCard(4, "search_card"),
    SendPostcard(5, "send_postcard"),
    Memorial(6, "memorial");




    private final int value;
    private final String name;

    FunctionNames(final int value, final String name){
        this.value = value;
        this.name = name;
    }

    public int toInt(){
        return value;
    }

}
