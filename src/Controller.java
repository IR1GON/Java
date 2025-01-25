
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setLabelText("Текст змінено!");
                view.getLabel().setText(model.getLabelText());
            }
        });
    }
}