import java.io.IOException;

public class Presenter {
    Model model;
    View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void buttonClick() {
        view.print("Enter your data: surname,name,patronymic," +
                "birthdate using format dd.mm.year," +
                "tel.number(sample:2351234)," +
                "sex(m or f),dividing the entries with the space)");

        String readData = view.str();

        String[] array = model.makeMas(readData);

        int res = model.checkFieldsQty(array);
        switch (res) {
            case -1 -> view.print(res + "\n" + "You entered not enough data - try again");
            case -2 -> view.print(res + "\n" + "You entered too much data - try again");
            default -> view.print("You have entered exact data quantity");
        }


        try {
            model.checkFieldsFormat(array);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong array size");
        }

        try {
            model.writeToFile();
        } catch (IOException e) {
            throw new RuntimeException("Error file writing");
        }
    }
}
