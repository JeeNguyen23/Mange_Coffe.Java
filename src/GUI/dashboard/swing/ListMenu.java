
package GUI.dashboard.swing;

import GUI.dashboard.events.EventMenuSelected;
import GUI.dashboard.model.Model_Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMenu<E extends Object >  extends JList<E>{
    private final DefaultListModel model;
    private int selectdIndex = -1;
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        
    }
    public ListMenu(){
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if(o instanceof Model_Menu){
                        Model_Menu menu =(Model_Menu)o;
                        if(menu.getType() == Model_Menu.MenuType.MENU){
                            selectdIndex = index;
                            if(event != null){
                                event.selected(index);
                            }
                        }
                    }else{
                        selectdIndex = index;
                    }
                    repaint();
                }
                    
                    
             }
        
        });
        
    }
    @Override
    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if(o instanceof Model_Menu){
                    data =(Model_Menu)o;
                }else{
                    data = new Model_Menu("",o +"",Model_Menu.MenuType.EMPTY);
                }
                
                MenuITem item  = new MenuITem(data);
                item.setSelected(selectdIndex == index);
                return item;
            }
            
        };
    }
    public void addItem(Model_Menu data){
        model.addElement(data);
        
    }
}
