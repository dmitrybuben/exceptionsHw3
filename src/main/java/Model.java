import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Model {

    public int fieldsQty = 6;
    public String[] checkedFields = new String[fieldsQty];

    public String[] makeMas(String str){
        String[] arr = str.split(" ");
        return arr;
    }

    public int checkFieldsQty(String[]array) {
        System.out.println(Arrays.toString(array));
        if (array.length < fieldsQty) {
            return -1;
        }
        if (array.length > fieldsQty) {
            return -2;
        } else return array.length;
    }

    public void checkFieldsFormat(String[]array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].matches("\\w+")) {
                checkedFields[i] = array[i];
            } else throw new RuntimeException("Invalid data format");
            if (array[i].matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                checkedFields[i] = array[i];
            } else throw new RuntimeException("Invalid data format");
            if (array[i].matches("\\d{7}")) {
                checkedFields[i] = array[i];
            } else throw new RuntimeException("Invalid data format");
            if (array[i].matches("[mf]")) {
                checkedFields[i] = array[i];
            } else throw new RuntimeException("Invalid data format");
        }
    }

    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("Contacts.txt", true);
        try {
            fw.write(Arrays.toString(checkedFields) + "\n");
        } catch (IOException e) {
            throw new IOException("Ошибка записи в файл");
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}


