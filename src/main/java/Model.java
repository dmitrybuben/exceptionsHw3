import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Model {

    public int fieldsQty = 6;
    public String[] arr;
    public String[] checkedFields = new String[fieldsQty];

    public int checkFieldsQty(String str) {
        arr = str.split(" ");
        if (arr.length < fieldsQty) {
            return -1;
        }
        if (arr.length > fieldsQty) {
            return -2;
        } else return arr.length;
    }

    public void checkFieldsFormat() {
        Pattern stringPattern = Pattern.compile("a-zA-Z");
        Pattern birthdayPattern = Pattern.compile("\\d{2}\\.\\d{2}.\\d{4}");
        Pattern telNumPattern = Pattern.compile("\\d{7}");
        Pattern sexTypePattern = Pattern.compile("[mf]");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches(stringPattern.pattern())) {
                checkedFields[i] = arr[i];
            } else if (arr[i].matches(birthdayPattern.pattern())) {
                checkedFields[i] = arr[i];
            } else if (arr[i].matches(telNumPattern.pattern())) {
                checkedFields[i] = arr[i];
            } else if (arr[i].matches(sexTypePattern.pattern())) {
                checkedFields[i] = arr[i];
                System.out.println(checkedFields[i]);
            }
        }
        System.out.println(Arrays.toString(checkedFields));
    }

    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("Contacts.txt");
        try {
            fw.write(Arrays.toString(checkedFields));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


