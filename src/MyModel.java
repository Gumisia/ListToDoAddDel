import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyModel extends AbstractListModel<String> {


    private List<String> stringList;

    public MyModel(){
        stringList = new ArrayList<>();
    }

    public void addElementList(String text){
        stringList.add(text);
        fireContentsChanged(this, 0, stringList.size());
    }

    public void deleteElem(int index){
        stringList.remove(index);
        fireContentsChanged(this, 0, stringList.size());
    }

    public void sortList(){
        Collections.sort(stringList);
    }

    @Override
    public int getSize() {
        return stringList.size();
    }

    @Override
    public String getElementAt(int index) {
        return stringList.get(index);
    }


}
